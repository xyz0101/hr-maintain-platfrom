package com.yuchai.maintain.targetmaintain.controller;


 import com.alibaba.fastjson.JSONArray;
 import com.alibaba.fastjson.JSONObject;
 import com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply;
import com.yuchai.maintain.targetmaintain.entity.PageData;
import com.yuchai.maintain.targetmaintain.entity.Result;
import com.yuchai.maintain.targetmaintain.entity.TargetSelfDate;
 import com.yuchai.maintain.targetmaintain.service.BpmVirtualTodoListService;
 import com.yuchai.maintain.targetmaintain.service.TargetRecordService;
import com.yuchai.maintain.targetmaintain.service.TargetSelfService;
 import com.yuchai.maintain.targetmaintain.utils.Utils;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import javax.swing.text.html.parser.Entity;
 import java.util.*;

@RestController
@RequestMapping("/target")
public class TargetController {
    Logger logger = LoggerFactory.getLogger(TargetController.class);



    @Autowired
    private TargetSelfService targetSelfService;
    @Autowired
    private TargetRecordService targetRecordService;
    @Autowired
    private BpmVirtualTodoListService bvts;

    @RequestMapping("/getTargetByYear")
    public List<EvalTargetsApply> getByYear(String year){
        return targetRecordService.getTargetApplyByYear(year);
    }

    /**
     * 获取所有的时间节点
     * @return
     */
    @RequestMapping("/getAllDatePoint")
    public List<Result> getAllDatePoint(){
        List<Result> resList = new ArrayList();
        Result res = new Result();
        PageData pd = new PageData();
        List<TargetSelfDate> data = targetSelfService.getAllSelfDatePoint();
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        pd.setListData(data);
        res.setData(pd);
        resList.add(res);
        return resList;
    }

    /**
     * 获取所有权限是否开放
     * @return
     */
    @RequestMapping("/getAuthIsOpen")
    public List<Result> getAuthIsOpen(){
        List<Result> resList = new ArrayList();
        Result res = new Result();
        boolean data = targetSelfService.allAuthIsOpen();
        res.setRtnCode("200");
        res.setRtnMsg("SUCCESS");
        res.setData(data);
        resList.add(res);
        return resList;
    }

    /**
     * 更新全部是否全部开放权限
     * @param value
     */
    @RequestMapping(value = "/updateAllAuth",method = RequestMethod.PUT)
    public void updateAllAuth(String value){
        if(!Utils.isNullValueOrNull(value)){
            logger.info("修改数据====>"+value);
          this.targetSelfService.changeAllAuth( Boolean.valueOf(value));
        }
    }

    /**
     * 更新时间节点
     * @param addValue
     * @param deleteValue
     * @param updateValue
     */
    @RequestMapping(value = "/updateDatePoint",method = RequestMethod.POST)
    public void updateDatePoint(String addValue,String deleteValue,String updateValue){
        List<TargetSelfDate> updateList =  Utils.getListValue(updateValue,TargetSelfDate.class);
        logger.info("保存数据====>"+updateValue);
        if(!Utils.isNullValueOrNull(updateValue))
        this.targetSelfService.updateDatePoint(updateList);
    }

    /**
     * 查询员工评价信息
     * @param year
     * @return
     */
    @RequestMapping(value="/queryEmpEvalData")
    public List<EvalTargetsApply> queryEmpEvalInfo(String year){
        return targetRecordService.queryEmpEvalInfo(year);
    }

    @RequestMapping(value="/insertEvalVirtRecord")
    public Integer insertRecord( String param){
         JSONArray json = JSONArray.parseArray(param);
        return bvts.createProcess(json);
    }

    @RequestMapping(value = "/deleteRocordProcess")
    public Integer deleteVirtRecord(String param){
        JSONArray jsonArray = JSONArray.parseArray(param);
        return bvts.deleteProcessVirt(jsonArray);
    }


    @RequestMapping(value = "/getEndDate")
    public Map<String, Object> getCurQuEnddate(String qN){
        return targetRecordService.selectEnddate(qN);
    }



}
