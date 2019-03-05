package com.yuchai.maintain.salarymaintain.controller;

import com.yuchai.maintain.salarymaintain.entity.PageData;
import com.yuchai.maintain.salarymaintain.entity.Result;
import com.yuchai.maintain.salarymaintain.entity.SlrHoliday;
import com.yuchai.maintain.salarymaintain.service.SlrHolidayService;
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


            Calendar cal =  Calendar.getInstance();
            cal.set(year,month,1);
            cal.roll(Calendar.DATE, -1);
            int dayCount = cal.get(Calendar.DATE) ;
             for(int i=1;i<=dayCount;i++){

                 cal.set(year,month,i);
                 Date date = cal.getTime();
                 //logger.info("循环日期===>"+new SimpleDateFormat("yyyy/MM/dd").format(date));
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
            logger.info(holidays.size()+"");
            logger.info(holidays.toString());
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
     * 保存节假日的修改
     * @param slrHoliday
     */
    @RequestMapping("/saveSlrHoliday")
    public void saveSlrHoliday(String slrHoliday){
        logger.info("传来数据===>"+slrHoliday);

        //前端传来的json串转对象集合
        List<SlrHoliday> holidays = Utils.getListValue(slrHoliday,SlrHoliday.class);
        slrHolidayService.saveSlrHoliday(holidays);
        logger.info(holidays.toString());

    }

}
