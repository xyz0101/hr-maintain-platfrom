package com.yuchai.maintain.evalmaintain.utils;

public class Test {
    public static void main(String[] args){
        String table = "SLR_EMP_SALARY_V_test";
        String outPath = "D:\\IdeaProjects\\maintain-platfrom\\eval-maintain\\src\\main\\java\\com\\yuchai\\maintain\\evalmaintain\\entity\\";
        String packagePath = "com.yuchai.maintain.evalmaintain.entity";
        GenerateBean g = new GenerateBean(table,outPath,packagePath);
        g.startGenerate();
    }
}
