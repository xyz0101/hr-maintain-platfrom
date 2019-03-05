package com.yuchai.maintain.salarymaintain.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuchai.maintain.salarymaintain.entity.SlrSpecialList;
import com.yuchai.maintain.salarymaintain.mapper.SlrSpecialListMapper;
import com.yuchai.maintain.salarymaintain.service.SlrSpecialListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SlrSpecialListServiceImpl implements SlrSpecialListService{
    @Autowired
    private SlrSpecialListMapper slrSpecialListMapper;
    @Override
    public List<SlrSpecialList> querySpecialList() {
        return slrSpecialListMapper.getSlrSpecialList();
    }

    @Transactional
    @Override
    public Integer updateSpecialListInfo(List<SlrSpecialList> slrSpecialLists) {
        return slrSpecialListMapper.updateRecord(slrSpecialLists);
    }
    @Transactional
    @Override
    public Integer addSpecialListInfo(List<SlrSpecialList> slrSpecialLists) {
        return slrSpecialListMapper.addRecord(slrSpecialLists);
    }
    @Transactional
    @Override
    public Integer deleteSpecialListInfo(List<SlrSpecialList> slrSpecialLists) {
        return slrSpecialListMapper.deleteRecord(slrSpecialLists);
    }

    @Transactional
    @Override
    public Integer saveSpecialUpdate(List<SlrSpecialList> updateList, List<SlrSpecialList> deleteList, List<SlrSpecialList> addList) {
        if(updateList.size()>0) {
            slrSpecialListMapper.updateRecord(updateList);
        }
        if(deleteList.size()>0){
            slrSpecialListMapper.deleteRecord(deleteList);
        }
        if(addList.size()>0){
            slrSpecialListMapper.addRecord(addList);
        }
        return 1;

    }
}
