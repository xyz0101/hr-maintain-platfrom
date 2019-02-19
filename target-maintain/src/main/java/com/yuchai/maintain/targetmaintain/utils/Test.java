package com.yuchai.maintain.targetmaintain.utils;

/**
 * pojo实体文件生成
 * 根据table生成实体类
 */
public class Test {

    public static void main(String[] args){
        String table = "target_self_date";
        String outPath = "D:\\IdeaProjects\\maintain-platfrom\\target-maintain\\src\\main\\java\\com\\yuchai\\maintain\\targetmaintain\\entity\\";
        String packagePath = "com.yuchai.maintain.targetmaintain";
        GenerateBean g = new GenerateBean(table,outPath,packagePath);
        g.startGenerate();
    }
}
