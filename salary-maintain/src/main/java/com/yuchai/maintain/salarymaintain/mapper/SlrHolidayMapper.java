package com.yuchai.maintain.salarymaintain.mapper;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.salarymaintain.entity.SlrHoliday;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@EnableGenerateXml(classPath = "com.yuchai.maintain.salarymaintain.mapper.SlrHolidayMapper")
public interface SlrHolidayMapper {
    List<SlrHoliday> getSlrHoliday(@Param("CurYearMonth") String CurYearMonth);
    void saveSlrHoliday(@Param("holidayList") List<SlrHoliday> holidayList);
}
