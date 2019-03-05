package com.yuchai.maintain.salarymaintain.service.impl;

import com.yuchai.maintain.salarymaintain.entity.SlrHoliday;
import com.yuchai.maintain.salarymaintain.mapper.SlrHolidayMapper;
import com.yuchai.maintain.salarymaintain.service.SlrHolidayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;
@Service
public class SlrHolidayServiceImpl implements SlrHolidayService {

    @Resource
    SlrHolidayMapper mapper;
    @Override
    public List<SlrHoliday> getSlrHoliday(String CurYearMonth) {
        return mapper.getSlrHoliday(CurYearMonth);
    }

    @Override
    public void saveSlrHoliday(List<SlrHoliday> holidayList) {
        Calendar cal = Calendar.getInstance();
        //根据对象中的key 为dateDate 赋值
        holidayList.forEach(item->{
            String key=item.getKey();
            if(key !=null) {
                String[] dateArr=key.split("-");
                int year = Integer.parseInt(dateArr[0] ) ;
                int month = Integer.parseInt(dateArr[1] ) ;
                int date = Integer.parseInt(dateArr[2] ) ;
                cal.set(year,month,date);
                item.setDateDate(cal.getTime());
                item.setDateType("true".equals(item.getDateType())?"holiday":"normal");
                item.setSalaryDay("true".equals(item.getSalaryDay())?"Y":"N");
            }
        });
        mapper.saveSlrHoliday(holidayList);

    }
}
