package com.yuchai.maintain.evalmaintain.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.yuchai.maintain.evalmaintain.constant.Const;
import com.yuchai.maintain.evalmaintain.entity.*;
import com.yuchai.maintain.evalmaintain.mapper.EvalIncludeEmployeesMapper;
import com.yuchai.maintain.evalmaintain.service.EvalDistQuotaService;
import com.yuchai.maintain.evalmaintain.service.EvalYearEvaluateService;
import com.yuchai.maintain.evalmaintain.service.HrDeptRegionService;
import com.yuchai.maintain.evalmaintain.utils.FileUtils;
import com.yuchai.maintain.evalmaintain.utils.Utils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

//解决跨域问题 全局跨域
//@CrossOrigin(origins = "*", maxAge = 3600,methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/eval")
public class EvalController {
    Logger logger = LoggerFactory.getLogger(EvalController.class);

    @Autowired
    private EvalYearEvaluateService evalYearEvaluateService;
    @Autowired
    private HrDeptRegionService hrDeptRegionService;
    @Autowired
    private EvalDistQuotaService evalDistQuotaService;

    @RequestMapping("/getEvalByYear")
    public List<EvalYearEvaluate> getByYear(String year){
        return evalYearEvaluateService.getEvalByYear(year);
    }

    /**
     * 查询评价数据
     * @param searchValue
     * @param sortKey
     * @param sortValue
     * @param curPage
     * @return
     */
    @RequestMapping("/getEvalYearByCondition")
    public   List<Result>  getEvalYearByCondition(String searchValue,String sortKey,String sortValue,String curPage){
        Integer curPageNum =  Utils.isNullValue(curPage) ?1:Integer.parseInt(curPage);
        Result res = new Result();
        Map<String,Object> conditionMap = new HashMap();
        logger.info("查询条件===>"+searchValue);
        logger.info("排序条件===>"+sortKey+"   "+sortValue);
        JSONObject jo = Utils.getJsonObject(searchValue);
            for(String key: jo.keySet()){
                Object value = jo.get(key);
                if(!Utils.isNullValue(value)){
                    if("employeeLevel".equals(key)){
                        logger.info("数组的类型是====>"+value.getClass().toString());
                        JSONArray arr = (JSONArray)value;
                        if(arr.size()!=0){
                            conditionMap.put(key,  arr.toArray());
                        }

                    }else{
                        conditionMap.put(key, value);
                    }

                }

            }

        if(!Utils.isNullValueOrNull(sortKey)&&!Utils.isNullValueOrNull(sortValue)){
            String sortField = Utils.humpToLine(sortKey);
            conditionMap.put("sortKey",sortField);
            conditionMap.put("sortValue",sortValue.replaceAll("end",""));
        }
        conditionMap.put("start",Const.PAGE_SIZE*(curPageNum-1)+1);
        conditionMap.put("end",curPageNum*Const.PAGE_SIZE);
        //获取页面总数
        Integer totalNum = evalYearEvaluateService.getEvalYearByConditionCount(conditionMap);
        List<EvalMgrYearV> resList = evalYearEvaluateService.getEvalYearByCondition(conditionMap);
        PageInfo pi = new PageInfo();
        pi.setCurPage(curPageNum);
        pi.setTotalNum(totalNum);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        pd.setListData(resList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        logger.info("调用成功"+((PageData)res.getData()).getListData());
        List<Result> result = new ArrayList();
        result.add(res);
        return result;
    }

    /**
     * 更新评价的状态
     * @param updateParams
     * @return
     */
    @RequestMapping(value = "/updateEvalYearMgr",method = RequestMethod.PUT)
    public void updateEvalYearMgr(@RequestBody String updateParams){
        logger.info("修改后的数据====>"+updateParams);
        if(!Utils.isNullValueOrNull(updateParams)) {
            evalYearEvaluateService.updateEvalMgrYear(updateParams);
        }
    }

    /**
     * 获取所有的需要评价的员工
     * @param curPage
     * @return
     */
    @RequestMapping("/getEvalIncludeEmps")
    public List<Result> getEvalIncludeEmps(String curPage){
        Integer curPageNum =  Utils.isNullValue(curPage) ?1:Integer.parseInt(curPage);
        List<Result> resList = new ArrayList<>();
        Result res = new Result();
        //获取页面总数
        Integer totalNum = evalYearEvaluateService.getEvalEmployeeCount();
        List<EvalIncludeEmployees> dataList = evalYearEvaluateService.getEvalEmployeeRange();
        PageInfo pi = new PageInfo();
        pi.setCurPage(curPageNum);
        pi.setTotalNum(totalNum);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        pd.setListData(dataList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        resList.add(res);

        return resList;

    }

    /**
     * 上传人员范围Excel
     * @param multipartFile
     */
    @RequestMapping(value = "/postExcel",method = RequestMethod.POST)
    public void postExcelFile(@RequestParam("excelFile")MultipartFile multipartFile){
        if(multipartFile.isEmpty()){
            logger.info("上传失败,请重试！");
        }else{
            String filePath = Const.FILE_PATH+"评价人员范围.xlsx";
            File file = new File(filePath );
            try {
                //写入文件
                multipartFile.transferTo(file);
                long b = System.currentTimeMillis();
                //处理数据
                List emps = FileUtils.parseExcelToList(file,EvalIncludeEmployees.class);
                logger.info("处理数据完成===耗时==>"+(System.currentTimeMillis()-b));
                b = System.currentTimeMillis();
                //上传数据
                evalYearEvaluateService.addEvalEmployeeRange(emps);
                logger.info("上传成功===耗时==>"+(System.currentTimeMillis()-b));
            } catch (IOException e) {
                logger.error(e.toString(), e);
            }


        }
    }

    /**
     * 导出人员范围
     * @param response
     */
    @RequestMapping("/getExcel")
    public void exportExcel(HttpServletResponse response){
        //获取数据
        List<Result> dataList =this.getEvalIncludeEmps("1");
        List<Object> emps = ((PageData)dataList.get(0).getData()).getListData();
        //导出数据
        FileUtils.exportExcel(response,emps,EvalIncludeEmployees.class,null);
    }

    /**
     * 获取所有线
     * @return
     */
    @RequestMapping("/getHrDeptRegion")
    public List<Result> getHrDeptRegion(){
        List<Result> resList = new ArrayList<>();
        Result res = new Result();
        List<HrDeptRegion> dataList =  hrDeptRegionService.getHrDeptRegion();
        PageInfo pi = new PageInfo();
        pi.setCurPage(0);
        pi.setTotalNum(0);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        pd.setListData(dataList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        resList.add(res);
        return resList;

    }

    /**
     * 获取部门列表
     * @param searchValue
     * @return
     */
    @RequestMapping("/getOrgList")
    public List<Result> getOrgList(String searchValue){
        JSONObject jo = Utils.getJsonObject(searchValue);
        Date inputDate = null;
        if(!Utils.isNullValueOrNull(jo.get("dataDate"))) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                inputDate = sdf.parse(jo.get("dataDate").toString().substring(0, 10));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            logger.info(jo.get("dataDate").toString());
        }
        List<Result> resList = new ArrayList<>();
        Result res = new Result();
        List<OrgInfo> dataList =  hrDeptRegionService.getAllOrganization(inputDate);



        PageInfo pi = new PageInfo();
        pi.setCurPage(0);
        pi.setTotalNum(0);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        pd.setListData(dataList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        resList.add(res);
        return resList;
    }

    /**
     * 获取线与部门关系
     * @param searchValue
     * @return
     */
    @RequestMapping("/getHrDeptRegionDtl")
    public List<Result> getHrDeptRegionDtl(String searchValue){
        logger.info(searchValue);
        Date inputDate = null;
            JSONObject jo = Utils.getJsonObject(searchValue);
           if(!Utils.isNullValueOrNull(jo.get("dataDate"))) {
               DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               try {
                   inputDate = sdf.parse(jo.get("dataDate").toString().substring(0, 10));
               } catch (ParseException e) {
                   e.printStackTrace();
               }
               logger.info(jo.get("dataDate").toString());
           }


        List<Result> resList = new ArrayList<>();
        Result res = new Result();
        List<HrDeptRegionDtl> dataList =  hrDeptRegionService.getHrDeptRegionDtl(inputDate);



        PageInfo pi = new PageInfo();
        pi.setCurPage(0);
        pi.setTotalNum(0);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        pd.setListData(dataList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        resList.add(res);
        return resList;

    }

    /**
     * 保存数据操作（线）
     * @param addValue
     * @param deleteValue
     * @param updateValue
     */
    @RequestMapping(value = "/saveDeptRegionData",method=RequestMethod.POST)
    public void saveDeptRegionData(String addValue,String deleteValue,String updateValue){
        logger.info("saveDeptRegionData===>"+updateValue);
        List<HrDeptRegion> addList = Utils.getListValue(addValue,HrDeptRegion.class);
        List<HrDeptRegion> deleteList = Utils.getListValue(deleteValue,HrDeptRegion.class);
        List<HrDeptRegion> updateList = Utils.getListValue(updateValue,HrDeptRegion.class);
        this.hrDeptRegionService.saveDeptRegion(addList,deleteList,updateList);
    }

    /**
     * 保存数据操作（线与部门）
     * @param addValue
     * @param deleteValue
     * @param updateValue
     */
    @RequestMapping(value = "/saveDeptRegionDtlData",method=RequestMethod.POST)
    public void saveDeptRegionDtlData(String addValue,String deleteValue,String updateValue){
        logger.info("saveDeptRegionDtlData===>"+addValue);
        List<HrDeptRegionDtl> addList = Utils.getListValue(addValue,HrDeptRegionDtl.class);
        List<HrDeptRegionDtl> deleteList = Utils.getListValue(deleteValue,HrDeptRegionDtl.class);
        List<HrDeptRegionDtl> updateList = Utils.getListValue(updateValue,HrDeptRegionDtl.class);
        this.hrDeptRegionService.saveDeptRegionDtl(addList,deleteList,updateList);
    }



    /**
     * 新增线
     * @param addValue
     */
    @RequestMapping(value="/addHrDeptRegion" ,method = RequestMethod.POST)
    public void addHrDeptRegion( String addValue){
        logger.info("输出addValue===>"+ Utils.getListValue(addValue,HrDeptRegion.class) );
    }

    /**
     * 查询指定年份的评语分布率
     * @param searchValue
     * @return
     */
    @RequestMapping("/getEvalDistQuota")
    public List<Result> getEvalDistQuota(String searchValue){
        logger.info(searchValue);

        JSONObject jo = Utils.getJsonObject(searchValue);
        Date inputDate = null;
        if(!Utils.isNullValueOrNull(jo.get("dataDate"))) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                inputDate = sdf.parse(jo.get("dataDate").toString().substring(0, 10));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            logger.info(jo.get("dataDate").toString());
        }


        String curYear= "9999";
        List<Result> resList = new ArrayList<>();
        Result res = new Result();
        //评语分布率
        Calendar cal =Calendar.getInstance();
        if(inputDate!=null) {
            cal.setTime(inputDate);
            curYear = cal.get(Calendar.YEAR) + "";
        }

        //获取部门选择列表并且去掉6-7级部门
        List<OrgInfo> orgList= this.hrDeptRegionService.getAllOrganization(inputDate).stream().
                filter(item->  !"hr000001".equals( item.getOrganizationCode()) ).collect(Collectors.toList());
        //添加一个N/A
        orgList.add(new OrgInfo("N/A","N/A"));
        //获取线选择列表
        List<HrDeptRegion> deptRegionList= this.hrDeptRegionService.getHrDeptRegion();

        List<EvalDistQuota> dataList =   evalDistQuotaService.getEvalDistQuotaByYear( curYear);
        //为部门名称和线名称赋值
        dataList.stream().forEach(
                item->{
                    deptRegionList.stream().forEach(region->{
                        if(region.getDrCode().equals(item.getDrCode())){
                            item.setDrName( region.getDrName());
                        }
                    });
                    orgList.stream().forEach(org->{
                        if(org.getOrganizationCode().equals(item.getDeptNo())){
                            item.setDeptName(org.getOrganizationName());
                        }
                    });
                });
        logger.info("结果=====>"+dataList);

        PageInfo pi = new PageInfo();
        pi.setCurPage(0);
        pi.setTotalNum(0);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        Map<String ,List> selectLists = new HashMap<>();
        selectLists.put("orgList",orgList);
        selectLists.put("deptRegionList",deptRegionList);
        pd.setSelectLists(selectLists);
        pd.setListData(dataList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        resList.add(res);
        return resList;

    }

    /**
     *  导出评语分布率
     * @param searchValue
     * @param response
     */
    @RequestMapping(value = "/exportEvalDistQuota",method = RequestMethod.GET)
    public void exportEvalDistQuota(@RequestParam(name = "searchValue") String searchValue  ,HttpServletResponse response ){
         //获取数据
        List<Result> dataList =this.getEvalDistQuota(searchValue);
        Map<String, List> map= ((PageData)dataList.get(0).getData()).getSelectLists() ;
        List<OrgInfo> orgList= map.get("orgList");
        String[] orgArr = new String[orgList.size()];
        orgList.stream().forEach(
            (item)->{
                    int index=orgList.indexOf(item);
                    orgArr[index] = item.getOrganizationName();
                }
        );
        List<HrDeptRegion> deptRegionList= map.get("deptRegionList");
        String[] deptRegionArr = new String[deptRegionList.size()];
        deptRegionList.stream().forEach(
                item->{
                    int index=deptRegionList.indexOf(item);
                    deptRegionArr[index] = item.getDrName();
                }
        );
        Map<Integer,String[]> selectListMap = new HashMap<>();
        selectListMap.put(2,deptRegionArr);
        selectListMap.put(3,orgArr);
        logger.info("条件===>"+searchValue);
        List<Object> distQuotaList = ((PageData)dataList.get(0).getData()).getListData();
        logger.info("导出数据===>"+distQuotaList);
        //导出数据
        FileUtils.exportExcel(response,distQuotaList,EvalDistQuota.class,selectListMap);
    }

    /**
     * 上传评语分布率Excel
     * @param multipartFile
     */
    @RequestMapping(value = "/postExcelEvalDistQuota" ,method = {RequestMethod.POST,RequestMethod.GET})
    public void postExcelEvalDistQuota(@RequestParam("excelFile")MultipartFile multipartFile,@RequestParam("year") String year){
        if(multipartFile.isEmpty()){

            logger.info("上传失败,请重试！");
        }else{


            if(!Utils.isNullValueOrNull(year)) {
                Date date = new Date(Long.valueOf(year));
                Calendar cal = Calendar.getInstance( );
                cal.setTime(date);
                year = cal.get(Calendar.YEAR)+"";
                logger.info(year);
                String filePath = Const.FILE_PATH+"评语分布率.xlsx";
                File file = new File(filePath );
                try {
                    //写入文件
                    multipartFile.transferTo(file);
                    long b = System.currentTimeMillis();
                    //处理数据
                    List  evalDistQuotaList = FileUtils.parseExcelToList(file,EvalDistQuota.class);
                    //获取部门和线
                    //获取部门选择列表并且去掉6-7级部门
                    List<OrgInfo> orgList= this.hrDeptRegionService.getAllOrganization(date).stream().
                            filter(item->  !"hr000001".equals( item.getOrganizationCode()) ).collect(Collectors.toList());
                    //添加一个N/A
                    orgList.add(new OrgInfo("N/A","N/A"));
                    //获取线选择列表
                    List<HrDeptRegion> deptRegionList= this.hrDeptRegionService.getHrDeptRegion();

                    //设置部门编号和线编号
                    evalDistQuotaList.forEach( item->{
                        if(item!=null ){
                            EvalDistQuota item1 = (EvalDistQuota)item;
                            orgList.forEach(org->{
                                if(org.getOrganizationName().equals(((EvalDistQuota) item1).getDeptNo())){
                                    ((EvalDistQuota) item).setDeptNo(org.getOrganizationCode());
                                }
                            });
                            deptRegionList.forEach(region->{
                                if(region.getDrName().equals(((EvalDistQuota) item1).getDrCode())){
                                    ((EvalDistQuota) item).setDrCode(region.getDrCode());
                                }
                            });

                        }
                    });


                    logger.info("处理数据完成===耗时==>"+(System.currentTimeMillis()-b));
                    b = System.currentTimeMillis();
                    //上传数据
                    logger.info("上传成功===数据==>"+evalDistQuotaList);
                    evalDistQuotaService.addEvalDistQuotaWithYear(evalDistQuotaList,year);
                    logger.info("上传成功===耗时==>"+(System.currentTimeMillis()-b));
                } catch (IOException e) {
                    logger.error(e.toString(), e);
                }

            }else{
                logger.error("年份不合法");
            }
        }

    }

    /**
     * 更新评语分布率
     * @param updateValue
     */
    @RequestMapping(value = "/saveEvalDistQuota",method = RequestMethod.POST)
    public void saveEvalDistQuota(String addValue,String deleteValue,String updateValue){
        List<EvalDistQuota> updateList =  Utils.getListValue(updateValue,EvalDistQuota.class);
        logger.info("保存数据====>"+updateValue);
        evalDistQuotaService.updateEvalDistQuotaWithYear(updateList);
    }
    @RequestMapping(value = "/getEvalEmployeeInfos" ,method = {RequestMethod.GET})
    public List<Result> getEvalEmployeeInfos(String searchValue,String curPage){
        Integer curPageNum =  Utils.isNullValue(curPage) ?1:Integer.parseInt(curPage);
        Result res = new Result();
        Map<String,Object> conditionMap = new HashMap();
        logger.info("查询条件===>"+searchValue);
        JSONObject jo = Utils.getJsonObject(searchValue);
        for(String key: jo.keySet()){
            Object value = jo.get(key);
            if(!Utils.isNullValue(value)){
                if("dataDate".equals(key)){
                    String valueStr = String.valueOf(value);
                    value= valueStr.length()>=10?TypeUtils.castToDate( valueStr.substring(0,10)):null;

                }

                    conditionMap.put(key, value);
            }

        }
        conditionMap.put("start",Const.PAGE_SIZE*(curPageNum-1)+1);
        conditionMap.put("end",curPageNum*Const.PAGE_SIZE);
        //获取页面总数
        Integer totalNum = evalYearEvaluateService.getEvalEmployeeInfosCountWithCondition(conditionMap);
        List<EvalEmployeeInfos> resList = evalYearEvaluateService.getEvalEmployeeInfosWithCondition(conditionMap);
        PageInfo pi = new PageInfo();
        pi.setCurPage(curPageNum);
        pi.setTotalNum(totalNum);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        pd.setListData(resList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        logger.info("调用成功"+((PageData)res.getData()).getListData());
        List<Result> result = new ArrayList();
        result.add(res);
        return result;
    }

    /**
     * 调用刷新程序的存储过程
     * @param datePoint
     * @return
     */
    @RequestMapping("/callRefreshEvalData")
    public Result callRefreshEvalData(String datePoint){
        logger.info("执行者===>"+Thread.currentThread().getName());
        logger.info(datePoint);
        Result res = new Result();
        JSONObject jo = Utils.getJsonObject(datePoint);
        Date inputDate = null;
        if(!Utils.isNullValueOrNull(jo.get("dataDate"))) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                inputDate = sdf.parse(jo.get("dataDate").toString().substring(0, 10));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            logger.info(jo.get("dataDate").toString());
        }
        if(inputDate!=null){
            String executorId = UUID.randomUUID().toString();
            evalYearEvaluateService.refreshEvalData(inputDate,"admin",executorId);
            res.setRtnCode("200");
            res.setRtnMsg("SUCCESS");
            res.setData(executorId);
            logger.info("调用完成");
        }else{
            logger.error("时间不能为空");
            res.setRtnCode("500");
            res.setRtnMsg("ERROR");
            res.setData("null");

        }

    return res;

    }
    @RequestMapping("/getProcessRate")
    public Result getProcessRate(String executorId){
        Object rate = 0.0;
        Result res = new Result();
        EvalRefreshDataExecutor executor = null;
        if(Utils.isNullValueOrNull(executorId)){
                //根据状态获取进程
                executor=evalYearEvaluateService.getExecutorByStatus(EvalRefreshDataExecutor.START);
                if(executor!=null){
                    rate = getRate(executor).intValue();
                }else{
                    rate="null";
                }
        }else{
            //获取进程信息
             executor = evalYearEvaluateService.getExecutorById(executorId);
             if(executor!=null){
                 rate = getRate(executor).intValue();
             }else{
                 rate="null";
             }
        }
        if(executor!=null){
            res.setRtnCode(executor.getExecutorRtnCode());
           if(Utils.isNullValueOrNull(executorId))
               res.setRtnMsg(executor.getExecutorId());
           else
               res.setRtnMsg(executor.getExecutorRtnInfo());
            res.setData(rate);
            logger.info("返回===》" +res);
        }else{

            res.setData(rate);
        }


        return res;

    }

    /**
     * 获取进度值
     * @param executor
     * @return
     */
    private Double getRate(EvalRefreshDataExecutor executor) {
        int total = evalYearEvaluateService.getAllEmpCount();
        Map map = new HashMap();
        map.put("executorId",executor.getExecutorId());
        int processCount = evalYearEvaluateService.getEvalEmployeeInfosCountWithCondition(map);
       // logger.info("总数===》"+total+"   已进行==>"+processCount);

        return ((processCount*1.00)/(total*1.00))*100;
    }

    /**
     * 获取部门对应的部门正职
     * @return
     */
    @RequestMapping("/getOrgLeaderList")
    public List<Result> getOrgLeaderList(){
        List dataList = hrDeptRegionService.getDeptMgrs();
        List<Result> resList = new ArrayList<>();
        Result res = new Result();
        PageInfo pi = new PageInfo();
        pi.setCurPage(0);
        pi.setTotalNum(0);
        pi.setPageSize(Const.PAGE_SIZE);
        PageData pd = new PageData();
        pd.setListData(dataList);
        pd.setPageInfo(pi);
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(pd);
        resList.add(res);
        logger.info("数据====>"+resList);

        return resList;
    }

    /**
     * 保存部门正职信息
     * @param addValue
     * @param deleteValue
     * @param updateValue
     */
    @RequestMapping("/saveOrgLeaderList")
    public void saveOrgLeaderList(String addValue,String deleteValue,String updateValue){
        List<HrDeptMgr> updateList =  Utils.getListValue(updateValue,HrDeptMgr.class);
        hrDeptRegionService.updateDeptMgr(updateList);
        logger.info("保存数据====>"+updateValue);

    }


    /**
     * 获取人员编号和姓名
     * @return
     */
    @RequestMapping("/getInputEmpList")
    public List<HrEmployeeInfoSync> getInputEmpList(String inputValue){
        List dataList = evalYearEvaluateService.getEmpByCodeOrName(inputValue);
        return dataList;
    }

    /**
     * 完成年度评价的数据准备
     * @param dataDate
     * @return
     */
    @RequestMapping("/finishEvalReady")
    public Result finishEvalReady(String dataDate){
        Result res = new Result();
        if(!Utils.isNullValueOrNull(dataDate)){
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            dataDate= sdf.format( TypeUtils.castToDate(dataDate));
            Map<String,Object> map = new HashMap();
            map.put("P_CUR_USER","admin");
            map.put("P_DATA_DATE",dataDate);
            evalYearEvaluateService.createNextYearEvaluate(map);
            logger.info(map.toString());
            if("S".equals(map.get("x_rtn_code") )  ){
                res.setData(map.get("x_next_year"));
                res.setRtnCode(String.valueOf( map.get("x_rtn_code")) );
                res.setRtnMsg(String.valueOf( map.get("x_rtn_msg"))  );
            }else{
                res.setRtnCode(String.valueOf( map.get("x_rtn_code")) );
                res.setRtnMsg(String.valueOf( map.get("x_rtn_msg"))  );
            }
        }else{
            res.setRtnCode("500");
            res.setRtnMsg("输入的时间不合法");
        }
        return res;

    }

}
