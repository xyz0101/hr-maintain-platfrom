package com.yuchai.maintain.evalmaintain.utils;

public class Test {
    public static void main(String[] args){
        String table = "hr_employee_info_sync";
        String outPath = "D:\\IdeaProjects\\maintain-platfrom\\eval-maintain\\src\\main\\java\\com\\yuchai\\maintain\\evalmaintain\\entity\\";
        String packagePath = "com.yuchai.maintain.evalmaintain.entity";
        GenerateBean g = new GenerateBean(table,outPath,packagePath);
        g.startGenerate();
    }
}
