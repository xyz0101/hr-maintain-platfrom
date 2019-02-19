package com.yuchai.maintain.targetmaintain.utils;

/**
 * mapper.xml 文件生成
 */
public class TestXml {
    public static void main(String[] args){

        new ClassScanner().generateXML(Const.SCAN_PACKAGE);
    }
}
