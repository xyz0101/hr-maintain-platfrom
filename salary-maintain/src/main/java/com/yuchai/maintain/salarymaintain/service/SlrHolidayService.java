package com.yuchai.maintain.salarymaintain.service;

import com.yuchai.maintain.salarymaintain.entity.SlrHoliday;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SlrHolidayService {
    //获取当前年月的节假日
    List<SlrHoliday> getSlrHoliday(@Param("CurYearMonth") String CurYearMonth);

}
