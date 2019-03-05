package com.yuchai.maintain.salarymaintain.mapper;

import com.yuchai.maintain.salarymaintain.entity.SalaryItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SalaryItemMapper {

    List<SalaryItem> selectSalaryItem();

}
