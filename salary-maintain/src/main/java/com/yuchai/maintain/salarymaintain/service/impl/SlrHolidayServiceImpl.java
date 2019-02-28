package com.yuchai.maintain.salarymaintain.service.impl;

import com.yuchai.maintain.salarymaintain.entity.SlrHoliday;
import com.yuchai.maintain.salarymaintain.mapper.SlrHolidayMapper;
import com.yuchai.maintain.salarymaintain.service.SlrHolidayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SlrHolidayServiceImpl implements SlrHolidayService {

    @Resource
    SlrHolidayMapper mapper;
    @Override
    public List<SlrHoliday> getSlrHoliday(String CurYearMonth) {
        return mapper.getSlrHoliday(CurYearMonth);
    }
}
