package com.yuchai.maintain.targetmaintain.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface BpmVirtualTodoListService {

    public Boolean queryProcessIsExist(String Instanceid,Number MAX,Number MIN);

    public int createProcess(JSONArray json);

    public Integer deleteProcessVirt(JSONArray array);

}
