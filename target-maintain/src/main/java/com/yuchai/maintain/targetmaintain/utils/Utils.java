package com.yuchai.maintain.targetmaintain.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuchai.maintain.evalmaintain.utils.IgnoreDTDEntityResolver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    static Logger logger = LoggerFactory.getLogger(com.yuchai.maintain.targetmaintain.utils.Utils.class);
    private static SAXReader reader = new SAXReader(false);
    public  static void closeIo(Object obj){
        if(obj!=null){
            try {

                ((Closeable)obj).close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    /**
     * 获取json对象
     * @param searchValue
     * @return
     */
    public static JSONObject getJsonObject(String searchValue){
        if(! isNullValueOrNull(searchValue) &&!"undefined".equals(searchValue)  ) {
            JSONObject jo = JSON.parseObject(searchValue);
            return jo;
        }
        return new JSONObject();
    }

    /**
     * 将jsonArray转为对象集合
     * @param jsonValue
     * @param clazz
     * @return
     */
    public static List getListValue(String jsonValue, Class clazz){
        List resList = new ArrayList();
        JSONArray addArray = com.yuchai.maintain.evalmaintain.utils.Utils.getJsonArray(jsonValue);
        for(int i=0;i<addArray.size() ;i++){
            JSONObject jo = (JSONObject) addArray.get(i);
            //出现无法赋值的情况可能是字段命名问题，类似以is开头，或者以一个小写字母开头的会导致生成get，set 方法的时候不会转大写，所以无法赋值
            Object obj = JSON.toJavaObject(jo,clazz);
            resList.add(obj);
        }
        return resList;
    }

    /**
     * 获取jso数组n对象
     * @param jsonValue
     * @return
     */
    public static JSONArray getJsonArray(String jsonValue){
        if(! isNullValueOrNull(jsonValue) &&!"undefined".equals(jsonValue)  ) {
            JSONArray ja = JSON.parseArray(jsonValue);
            return ja;
        }
        return new JSONArray();
    }


    public static String convertPackagePath(String path){
        return path.replaceAll("/","\\.");
    }
    public static String convertFilePath(String path){
        return path.replaceAll("\\.","/");
    }
    public static boolean isNullValue(Object obj){
        if(obj==null||"".equals(obj)){
            return true;
        }
        return false;
    }
    public static boolean isNullValueOrNull(Object obj){
        if(obj==null||"".equals(obj)||"null".equals(obj)){
            return true;
        }
        return false;
    }
    public static Document getDocument(File xmlFile){
        Document doc = null;

        try {
            // 忽略DTD，降低延迟
            reader.setEntityResolver(new IgnoreDTDEntityResolver());
            doc = reader.read(xmlFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return  doc;
    }

    public static String getCurrPath(String path){
        logger.info("路径    "+path);
        // String curPath = Utils.class.getResource("/"+path).getPath();
        String curPath="D:/IdeaProjects/maintain-platfrom/eval-maintain/target/classes/"+path;
        logger.info(curPath);
        return curPath;



    }
    /**
     *驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str){
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        // sb.delete(0, 1);
        return sb.toString();

    }

    /***
     * 下划线命名转为驼峰命名
     *
     * @param para
     *        下划线命名的字符串
     */

    public static String UnderlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
