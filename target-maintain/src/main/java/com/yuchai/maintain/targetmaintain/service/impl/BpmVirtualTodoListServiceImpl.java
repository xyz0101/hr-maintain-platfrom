package com.yuchai.maintain.targetmaintain.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuchai.maintain.targetmaintain.entity.BpmVirtualTodoList;
import com.yuchai.maintain.targetmaintain.mapper.BpmVirtualTodoListMapper;
import com.yuchai.maintain.targetmaintain.service.BpmVirtualTodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BpmVirtualTodoListServiceImpl implements BpmVirtualTodoListService {
    @Autowired
    private BpmVirtualTodoListMapper bvtlm;
    @Autowired
    private BpmVirtualTodoList bvt;
    @Override
    public Boolean queryProcessIsExist(String Instanceid, Number MAX, Number MIN) {
        return null;
    }

    @Override
    public int createProcess(JSONArray json) {
        int a =0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Object dataV :json){
                Map<String,String> paramMap = new HashMap<String,String>();
                JSONObject data = (JSONObject)dataV;
                String[] label = String.valueOf(data.get("label")).split(",");
                paramMap.put("title",data.get("date")+"年目标登记自评流程(第"+label[0]+"季度,截止时间;"+data.get("enddate")+")");
                paramMap.put("creatorName","xxxx");
                paramMap.put("createTime",sdf.format(new Date()).toString());
                paramMap.put("assignee",String.valueOf(data.get("empCode")));
                paramMap.put("assigneddate",null);
                paramMap.put("activityLabel",data.get("date")+"年第"+label[0]+"季度自评");
                paramMap.put("formurl","/ycloud/hr/tar/faces/evalTargetRecord.jspx?taskId=emp_zp_no_process&instanceId=ZP"+label[1]+data.get("empCode")+bvtlm.getMaxN());
                paramMap.put("instanceId","ZP"+label[1]+data.get("empCode")+(bvtlm.getMaxN()+1));
                paramMap.put("taskId",null);
                System.err.println(bvtlm.getMaxN());
                a = bvtlm.insert(paramMap);
        }
        return a;
    }

    @Override
    public Integer deleteProcessVirt(JSONArray array) {
        int code = 0 ;
        List<Object> list = new ArrayList<Object>();
        HashMap<String,Object> map = new HashMap<String,Object>();
        String label = "" ;
        for(Object obj : array){
            //System.err.println(((JSONObject)obj).get("employeeCode")+"<---->"+((JSONObject)obj).get("code"));
            list.add(String.valueOf(((JSONObject)obj).get("employeeCode")));
            label =String.valueOf(((JSONObject)obj).get("code"));
            //code =  bvtlm.deleteVirtProcess(map);
        }
        map.put("activityLabel",label);
        map.put("assignee",list);
        return code =  bvtlm.deleteVirtProcess(map);
    }
}
