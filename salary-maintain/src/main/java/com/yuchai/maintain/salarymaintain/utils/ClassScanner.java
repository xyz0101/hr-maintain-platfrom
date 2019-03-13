package com.yuchai.maintain.salarymaintain.utils;



import com.yuchai.maintain.salarymaintain.anno.EnableGenerateResMap;
import com.yuchai.maintain.salarymaintain.anno.EnableGenerateXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class ClassScanner implements Observer {
    List<Class> classes = new ArrayList<Class>();
    Logger logger = LoggerFactory.getLogger(ClassScanner.class);
    static JavaCompiler javac = ToolProvider.getSystemJavaCompiler();

    /**
     * 递归扫描所有的类
     * @param basePath
     * @return
     */
    private void scannClass(String basePath){

        String classPath = Utils.convertFilePath(basePath);
        classPath = Utils.getCurrPath(classPath);


        File f = new File(classPath);
        if(f.exists()) {
            File files[] = f.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                  logger.info("路径是====>" + file.getName());
                    scannClass( basePath+"."+file.getName());
                } else {

                    try {
                        //logger.info("文件路径是====>" + file.getName());
                        if(file.getName().endsWith(".class")) {
                            logger.info("最后更新时间====>" + basePath);
                            Class clazz = Class.forName(basePath + "." + (file.getName().replaceAll("\\." + "class", "")));
                            classes.add(clazz);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            System.out.println("文件不存在");
        }

    }

    public void generateXML(String basePath){
        XMLReader xr = new XMLReader();
        this.scannClass(basePath);
        Map<String,File> xmlsMap = new HashMap<String, File>();
        //logger.info(classes.size()+"");

        //循环生成xml文件
        for (Class clazz: classes){
             logger.info(clazz.getName());
            if(clazz.isAnnotationPresent(EnableGenerateXml.class)){
                EnableGenerateXml xmlanno = (EnableGenerateXml) clazz.getAnnotation(EnableGenerateXml.class);

                String xmlName = xmlanno.xmlName();

                if("".equalsIgnoreCase(xmlName)){
                    xmlName=clazz.getSimpleName();
                }
               logger.info("EnableGenerateXml====>"+clazz.getResource("/").getPath());
                String xmlPath = Const.XML_BASE_PATH+xmlName+".xml";
                File xml= xr.generateXML(xmlanno.classPath(),xmlPath,false);
                 xmlsMap.put(xmlName,xml);

            }
        }


        //循环生成resultMap节点
        for (Class clazz: classes){
            if(clazz.isAnnotationPresent(EnableGenerateResMap.class)){
                xr.generageResultMaps(xmlsMap,clazz);
               logger.info("EnableGenerateResMap====>"+clazz.getResource("/").getPath());
            }
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        try {
            String url = String.valueOf(arg ) ;
            File file = new File(url);
            String filename = file.getName();
            url=url.replaceAll("\\\\","/");
            File f = new File(url);
            if(f.isFile()){

                url = f.getParent() ;
            }
            logger.info("目录==="+ url);
            String outPath =  url.replaceAll("src\\\\main\\\\java","target\\\\classes");
            logger.info(outPath);
           boolean  flag =this.CompilerJavaFile(url,outPath);
            if(flag) {
                Thread.sleep(1000);
                this.generateXML(Const.SCAN_PACKAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private  boolean CompilerJavaFile(String sourceFileInputPath,
                                           String classFileOutputPath) throws Exception{
        classFileOutputPath="D:/IdeaProjects/maintain-platfrom/mybatis-util/target/classes/";
        Thread.sleep(500);
        logger.info("当前时间====>" + System.currentTimeMillis());
       // logger.info("source路径=====>"+sourceFileInputPath+"   "+(new File(classFileOutputPath).isDirectory())+"  "+(new File(sourceFileInputPath).isFile())+"  "+(new File(sourceFileInputPath).exists()));
        if(new File(classFileOutputPath).isDirectory()&&new File(sourceFileInputPath).isFile()) {
        logger.info("开始编译---------------");
            // 设置编译选项，配置class文件输出路径
            Iterable<String> options = Arrays.asList("-d", classFileOutputPath);
            StandardJavaFileManager fileManager =  javac
                    .getStandardFileManager(null, null, null);

            Iterable<? extends JavaFileObject> compilationUnits = fileManager
                    .getJavaFileObjectsFromFiles(Arrays.asList(new File(
                            sourceFileInputPath)));

            return javac.getTask(null, fileManager, null, options,
                    null, compilationUnits).call();
        }else{
            return false;
        }
    }
}
