package com.yuchai.maintain.evalmaintain.test;

import com.yuchai.maintain.evalmaintain.entity.EvalDistQuota;
import com.yuchai.maintain.evalmaintain.utils.Utils;

import java.util.List;

public class T {
    public static void main(String[] args){
    String str = "[{\"aCal\":0,\"bCal\":0,\"lastUpdatedBy\":\"admin\",\"objectVersionNumber\":1,\"evalApplyNo\":\"null\",\"dCal\":0,\"cCal\":0,\"lastUpdateDate\":\"2019-01-25 00:00:00\",\"creationDate\":\"2019-01-25 00:00:00\",\"evalYear\":\"2018\",\"jobLevel\":\"1\",\"drCode\":\"DR001\",\"deptNo\":\"30000176\",\"sCal\":0,\"quotaStat\":\"completed\",\"drName\":\"经营管理线\",\"deptName\":\"人力资源部\",\"sResult\":1,\"aResult\":0,\"bResult\":0,\"createdBy\":\"admin\",\"cResult\":0,\"dResult\":0}]";

    List<EvalDistQuota> res = Utils.getListValue(str,EvalDistQuota.class);
        System.out.println(res);

    }
}
