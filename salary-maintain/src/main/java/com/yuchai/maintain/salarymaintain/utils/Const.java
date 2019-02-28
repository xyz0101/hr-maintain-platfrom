package com.yuchai.maintain.salarymaintain.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Const {
    public static final String defaultHead="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"+
            "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n"+
            "<mapper namespace=\"none\">\n"+
            "</mapper>";
//    public static final String PROJECT_NAME="eval-maintain";
     public static final String XML_BASE_PATH = "D:\\IdeaProjects\\maintain-platfrom\\salary-maintain\\src\\main\\resources\\mapper\\";
     public static final String SCAN_PACKAGE = "com.yuchai.maintain.salarymaintain";
    public static final String CLASS_PATH="D:\\IdeaProjects\\maintain-platfrom\\eval-maintain\\salary\\classes\\com\\yuchai\\maintain\\salarymaintain";
    public static Map<String,String> TYPE_MAP = new HashMap<String, String>();
    static{
        TYPE_MAP.put(Integer.class.getName(),"NUMERIC");
        TYPE_MAP.put(Timestamp.class.getName(),"DATE");
        TYPE_MAP.put(BigDecimal.class.getName(),"NUMERIC");
        TYPE_MAP.put(Double.class.getName(),"NUMERIC");
        TYPE_MAP.put(int.class.getName(),"NUMERIC");
        TYPE_MAP.put(double.class.getName(),"NUMERIC");
        TYPE_MAP.put(String.class.getName(),"VARCHAR");
        TYPE_MAP.put(Date.class.getName(),"DATE");
        TYPE_MAP.put(java.sql.Date.class.getName(),"DATE");
        TYPE_MAP.put(java.sql.Timestamp.class.getName(),"DATE");
        System.out.println("加载完毕");
    }


}
