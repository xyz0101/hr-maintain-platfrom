package com.yuchai.maintain.salarymaintain.mapper;

import com.yuchai.maintain.salarymaintain.entity.EmpBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpBaseInfoMapper {

    List<EmpBaseInfo> selectEmpBaseInfo(@Param("employeeCode") String employeeCode);
}
