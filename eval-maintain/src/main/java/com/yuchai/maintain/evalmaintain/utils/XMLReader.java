package com.yuchai.maintain.evalmaintain.utils;


import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;
import com.yuchai.maintain.evalmaintain.anno.IgnoreInResultMap;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XML解析器
 */
public class XMLReader {

    Logger logger = LoggerFactory.getLogger(XMLReader.class);
    /**
     * 生成xml文件
     * @param xmlPath
     * @return
     */
    public File generateXML(String interfacePath,String xmlPath,boolean isCURD){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            File file = new File(xmlPath);
            if(!file.exists()){
                file.createNewFile();
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(Const.defaultHead);
                bw.newLine();
                bw.close();
                logger.info("文件不存在，创建文件");
                generateDefaultNode(file,interfacePath);
                return file;
            } else{
                logger.info("存在文件，不初始化");
               // generateDefaultNode(file,interfacePath);
                return file;
            }
        }catch (IOException e){
            logger.info(xmlPath);
            e.printStackTrace();
        }finally {
            Utils.closeIo(fw);
            Utils.closeIo(bw);
        }
        return  null;
    }

    /**
     * 生成默认节点
     * @param xmlFile xml文件
     * @param interfacePath 接口路径
     * @return
     */
    private boolean generateDefaultNode(File xmlFile,String interfacePath){
        //生成默认的mapper节点
        Document doc = null;
        List<Element> elementList = null;
        // 解析xml文档内容
          doc = Utils.getDocument(xmlFile);
            if(doc!=null){
                Element root = doc.getRootElement();
               // interfacePath =Utils.convertPackagePath(interfacePath);
                root.addAttribute("namespace",interfacePath);

                saveXML(xmlFile,doc);
            }
    return false;

    }

    /**
     * 根据实体生成resultMap映射
     * @param xmlsMap
     * @param clazz
     */
    public void generageResultMaps(Map<String,File> xmlsMap,Class clazz){
        long b = System.currentTimeMillis();
        for(Map.Entry<String,File> entry:xmlsMap.entrySet()){

            generageResultMap(entry.getValue(),clazz);

        }
        long e = System.currentTimeMillis();
        logger.info("耗时==>"+(e-b));


    }

    /**
     * 根据实体生成resultMap映射
     *
     * @param xmlFile
     * @param clazz
     */
    public void generageResultMap(File xmlFile,Class clazz){
        EnableGenerateResMap resanno = (EnableGenerateResMap) clazz.getAnnotation(EnableGenerateResMap.class);
        String xmlName =  xmlFile.getName();
        xmlName = xmlName.substring(0,xmlName.lastIndexOf("."));
        logger.info("文件名===>"+xmlName);
        String[] xmls = resanno.xmlNames();
        if(Arrays.asList(xmls).contains(xmlName)) {
            // 解析xml文档内容
            Document doc = Utils.getDocument(xmlFile);
            //result 的id
            String id = clazz.getSimpleName() + "Map";
            Element element = getResultMapElement(doc,id);
            Field fields[] = clazz.getDeclaredFields();
            String type = resanno.classPath();
            element.addAttribute("id", id);
            element.addAttribute("type", type);
            //获取当前resultMap节点下面的所有result子节点
            Map<String,Element> resultsMap = getResultElementsMap(element);
            //循环字段生成子节点
            //对于新增的字段可以生成，但是字段修改则不会删除无用节点，因此需要再做一次删除操作
            for (Field f : fields) {
                if(!f.isAnnotationPresent(IgnoreInResultMap.class)) {
                    logger.info(f.getType().getName());
                    String property = f.getName();
                    String column = Utils.humpToLine(property);
                    String jdbcType = Const.TYPE_MAP.get(f.getType().getName());
                    Element subEle =resultsMap.get(property)==null? element.addElement("result"):resultsMap.get(property);
                    subEle.addAttribute("column", column);
                    subEle.addAttribute("property", property);
                    subEle.addAttribute("jdbcType", jdbcType);
                    //在这时候将 resultsMap中的已处理元素设置为null
                    resultsMap.put(property,null);

                }
            }
            //删除废弃字段的节点
            deleteOtherResultNode(resultsMap);
            //删除这个xml里面的无用的resultMap
            deleteOtherResultMapNode(element);
            saveXML(xmlFile, doc);
        }
    }
    /**
     * 删除废弃字段的节点
     * @param element
     */
    private void deleteOtherResultMapNode( Element element){
        List<Element> elementList = null;
        elementList = element.getParent().elements();
        for(Element e:elementList){
           String attrPath= e.attributeValue("type");
           if(attrPath!=null) {
               String path = Utils.convertFilePath(attrPath);
               logger.info("deleteOtherResultMapNode==>" + path + ".class");
               path = Utils.getCurrPath(path + ".class");
               if (!new File(path).exists()) {
                   e.getParent().remove(e);
               }
           }
        }
    }

    /**
     * 删除废弃字段的节点
     * @param resultsMap
     */
    private void deleteOtherResultNode( Map<String,Element> resultsMap ){
        for(Map.Entry<String,Element> entry:resultsMap.entrySet()){
            if(entry.getValue()!=null)
            entry.getValue().getParent().remove(entry.getValue());

        }
    }


    /**
     * 获取resultMap下面的字段节点
     * 用属性字段名做key
     * @param resultMapElement
     * @return
     */
    private  Map<String, Element> getResultElementsMap(Element resultMapElement){
        List<Element> elementList = null;
        Map<String, Element> elementMap = new HashMap<String, Element>();
        elementList = resultMapElement.elements();
        for (Element element : elementList) {
            if ("result".equals(element.getName())) {
                elementMap.put(element.attributeValue("property"), element);
            }
        }
    return elementMap;

    }

    /**
     * 获取resultMap节点
     * @param doc
     * @param id
     * @return
     */
    private Element getResultMapElement(Document doc,String id){

        Map<String, Element> elementMap = new HashMap<String, Element>();
        List<Element> elementList = null;

        Element root = doc.getRootElement();
        elementList = root.elements();
        for (Element element : elementList) {
            if ("resultMap".equals(element.getName())) {
                elementMap.put(element.attributeValue("id"), element);
            }
        }
        Element element = null;
        if (elementMap.get(id) == null) {
            element = root.addElement("resultMap");

        } else {
            element = elementMap.get(id);
        }


    return element;
    }

    /**
     * 保存xml文件
     * @param xmlFile
     * @param doc
     */
    private void saveXML(File xmlFile,Document doc) {

        FileOutputStream out=null;
        XMLWriter writer = null;
        try {
            //指定文件输出的位置
            out =new FileOutputStream(xmlFile.getAbsolutePath());
            // 指定文本的写出的格式：
            OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
            format.setEncoding("UTF-8");
            //1.创建写出对象
            writer=new XMLWriter(out,format);
            //2.写出Document对象
            writer.write(doc);
            //3.关闭流
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            Utils.closeIo(out);
        }

    }

}
