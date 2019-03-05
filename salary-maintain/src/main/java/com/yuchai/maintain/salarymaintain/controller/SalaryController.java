package com.yuchai.maintain.salarymaintain.controller;

import com.alibaba.fastjson.JSONArray;
import com.netflix.discovery.converters.Auto;
import com.yuchai.maintain.salarymaintain.entity.PageData;
import com.yuchai.maintain.salarymaintain.entity.Result;
import com.yuchai.maintain.salarymaintain.entity.SlrHoliday;
import com.yuchai.maintain.salarymaintain.entity.SlrSpecialList;
import com.yuchai.maintain.salarymaintain.service.EmpBaseInfoService;
import com.yuchai.maintain.salarymaintain.service.SalaryItemService;
import com.yuchai.maintain.salarymaintain.service.SlrHolidayService;
import com.yuchai.maintain.salarymaintain.service.SlrSpecialListService;
import com.yuchai.maintain.salarymaintain.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/salary")
@RestController
public class SalaryController {
Logger logger = LoggerFactory.getLogger(SalaryController.class);
    @Autowired
    SlrHolidayService slrHolidayService;
    @Autowired
    SlrSpecialListService slrSpecialListService;
    @Autowired
    EmpBaseInfoService empBaseInfoService;
    @Autowired
    SalaryItemService salaryItemService;

    @RequestMapping("/getSlrHoliday")
    public List<Result> getSlrHoliday(String yearMonth){
        if(!Utils.isNullValueOrNull(yearMonth)) {
            int year = Integer.parseInt( yearMonth.substring(0,4)) ;
            int month = Integer.parseInt( yearMonth.substring(4,6)) ;
            logger.info("当前日期==>" + year+" "+month+1);

            List<SlrHoliday> holidays = slrHolidayService.getSlrHoliday(year+""+((month+1)>=10?month+1:"0"+(month+1)));
            Map<String, SlrHoliday> dateMap = new HashMap<>();
            holidays.forEach(item -> {
                item.setDateType( "normal".equals( item.getDateType())?"false":"true" );
                item.setSalaryDay( "N".equals( item.getSalaryDay())?"false":"true" );
                dateMap.put(new SimpleDateFormat("yyyy/MM/dd").format(item.getDateDate()), item);
            });
            logger.info(holidays.toString());

            Calendar cal =  Calendar.getInstance();
            cal.set(year,month,1);
            cal.roll(Calendar.DATE, -1);
            int dayCount = cal.get(Calendar.DATE) ;
             for(int i=1;i<=dayCount;i++){

                 cal.set(year,month,i);
                 Date date = cal.getTime();
                 logger.info("循环日期===>"+new SimpleDateFormat("yyyy/MM/dd").format(date));
                 if(dateMap.get(new SimpleDateFormat("yyyy/MM/dd").format(date))==null){

                     SlrHoliday holiday = new SlrHoliday();
                     holiday.setDateDate(date);
                     holiday.setKey(cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+i);
                     holiday.setDateType("false");
                     holiday.setSalaryDay("false");
                     holidays.add(holiday);
                 }else{
                     dateMap.get(new SimpleDateFormat("yyyy/MM/dd").format(date)).
                             setKey(cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+i);

                 }
             }


                List<Result> resList = new ArrayList<>();
            Result res = new Result();
            res.setRtnCode("200");
            res.setRtnMsg("SUCCESS");
            PageData pd = new PageData();
            pd.setListData(holidays);
            res.setData(pd);
            resList.add(res);
            logger.info(resList.toString());
            return resList;
        }else{
            return new ArrayList<>();
        }

    }

    /**
     * 获取特殊人员列表和工资项信息
     * @return
     */
    @RequestMapping(value="/querySalaryReadyInfo")
    public List<Result> querySalaryReadyInfo(){
        List<Result> resultList = new ArrayList<Result>();
        Result result = new Result();
        result.setRtnCode("200");
        result.setRtnMsg("SUCCESS");
        PageData pageDate = new PageData();
        pageDate.setListData(slrSpecialListService.querySpecialList());
        //获取工资项信息
        HashMap<String,List> resultMap = new HashMap<String,List>();
        resultMap.put("salaryitem",salaryItemService.getSalaryItemInfo());
        pageDate.setSelectLists(resultMap);
        result.setData(pageDate);
        resultList.add(result);
        return resultList;
    }

    /**
     * 保存表的修改信息
     * @param
     * @return
     */
    @RequestMapping(value="/saveSpecialConfigItem")
    public Integer saveSpecialConfigItem(String updateList,String deleteList, String addList){
        List<SlrSpecialList> slrUpdateSpecialLists = Utils.getListValue(updateList,SlrSpecialList.class);
        List<SlrSpecialList> slrDeleteSpecialLists = Utils.getListValue(deleteList,SlrSpecialList.class);
        List<SlrSpecialList> slrAddSpecialLists = Utils.getListValue(addList,SlrSpecialList.class);

        return slrSpecialListService.saveSpecialUpdate(slrUpdateSpecialLists,slrDeleteSpecialLists,slrAddSpecialLists);
    }
}
