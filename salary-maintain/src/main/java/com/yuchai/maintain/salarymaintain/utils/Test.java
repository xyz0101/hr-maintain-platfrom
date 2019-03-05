package com.yuchai.maintain.salarymaintain.utils;

public class Test {
    public static void main(String[] args){
        String table = "slr_special_list";
        String outPath = "D:\\IdeaProjects\\hr-maintain-platfrom\\salary-maintain\\src\\main\\java\\com\\yuchai\\maintain\\salarymaintain\\entity\\";
        String packagePath = "com.yuchai.maintain.salarymaintain.entity";
        GenerateBean g = new GenerateBean(table,outPath,packagePath);
        g.startGenerate();
    }
}
