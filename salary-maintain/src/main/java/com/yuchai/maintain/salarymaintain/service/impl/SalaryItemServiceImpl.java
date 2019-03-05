package com.yuchai.maintain.salarymaintain.service.impl;

import com.yuchai.maintain.salarymaintain.entity.SalaryItem;
import com.yuchai.maintain.salarymaintain.mapper.SalaryItemMapper;
import com.yuchai.maintain.salarymaintain.service.SalaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryItemServiceImpl implements SalaryItemService {
    @Autowired
    SalaryItemMapper salaryItemmapper;
    @Override
    public List<SalaryItem> getSalaryItemInfo() {
        return  salaryItemmapper.selectSalaryItem();
    }
}
