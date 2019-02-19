package com.yuchai.maintain.targetmaintain.controller;


 import com.yuchai.maintain.evalmaintain.utils.Utils;
import com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply;
import com.yuchai.maintain.targetmaintain.entity.PageData;
import com.yuchai.maintain.targetmaintain.entity.Result;
import com.yuchai.maintain.targetmaintain.entity.TargetSelfDate;
import com.yuchai.maintain.targetmaintain.service.TargetRecordService;
import com.yuchai.maintain.targetmaintain.service.TargetSelfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/target")
public class TargetController {
    Logger logger = LoggerFactory.getLogger(TargetController.class);


    @Autowired
    private TargetRecordService targetRecordService;
    @Autowired
    private TargetSelfService targetSelfService;

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



}
