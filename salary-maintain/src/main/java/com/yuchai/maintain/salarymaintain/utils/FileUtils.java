package com.yuchai.maintain.salarymaintain.utils;

import com.alibaba.fastjson.util.TypeUtils;
import com.yuchai.maintain.evalmaintain.anno.beananno.EnableExport;
import com.yuchai.maintain.evalmaintain.anno.beananno.EnableExportField;
import com.yuchai.maintain.evalmaintain.anno.beananno.ImportIndex;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileUtils {
    static Logger logger = LoggerFactory.getLogger(FileUtils.class);
    /**
     * 将Excel转换为对象集合
     * @param excel Excel 文件
     * @param clazz pojo类型
     * @return
     */
    public static List<Object> parseExcelToList(File excel,Class clazz){
        List<Object> res = new ArrayList<>();
        // 创建输入流，读取Excel
        InputStream is = null;
        Sheet sheet = null;
        try {
            is = new FileInputStream(excel.getAbsolutePath());
            if (is != null) {
                Workbook workbook = WorkbookFactory.create(is);
                //默认只获取第一个工作表
                sheet = workbook.getSheetAt(0);
                if (sheet != null) {
                    int i = 2;
                    String values[] ;
                    Row row = sheet.getRow(i);
                    while (row != null) {
                        //获取单元格数目
                        int cellNum = row.getPhysicalNumberOfCells();
                        values = new String[cellNum];
                        for (int j = 0; j <= cellNum; j++) {
                            Cell cell =   row.getCell(j);
                            if (cell != null) {
                                //设置单元格内容类型
                                cell.setCellType(Cell.CELL_TYPE_STRING );
                                //获取单元格值
                                String value = cell.getStringCellValue() == null ? null : cell.getStringCellValue();
                                values[j]=value;
                            }
                        }

                        //Method methods[]= clazz.getMethods();
                        Field[] fields = clazz.getDeclaredFields();
                        Object obj = clazz.newInstance();
                        for(Field f : fields){
                            if(f.isAnnotationPresent(ImportIndex.class)){
                                ImportIndex annotation = f.getDeclaredAnnotation(ImportIndex.class);
                                int index = annotation.index();
                                f.setAccessible(true);
                                Object val =TypeUtils.cast(values[index],f.getType(),null);
                                f.set(obj,val);
                            }
                        }
                        res.add(obj);
                        i++;
                        row=sheet.getRow(i);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 导出 Excel
     * @param response http响应，用于写文件
     * @param dataList 需要导出的数据
     * @param clazz 导出数据的pojo类型
     * @param selectListMap 下拉列表的列
     */
    public static void exportExcel(HttpServletResponse response, List<Object> dataList, Class clazz, Map<Integer,String[]> selectListMap){
        //创建一个Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //建立表
        HSSFSheet hssfsheet =  workbook.createSheet();

        hssfsheet.setDefaultRowHeight( ( short )(20*20) );
        //检查当前pojo是否允许导出
        if(clazz.isAnnotationPresent(EnableExport.class)) {
            EnableExport export = (EnableExport) clazz.getDeclaredAnnotation(EnableExport.class);
            //获取所有标题名称
            List<String> colNames =new ArrayList();
            //所有允许导出的字段
            List<Field> fieldList = new ArrayList<>();
            for(Field field : clazz.getDeclaredFields()){
                if(field.isAnnotationPresent(EnableExportField.class)){
                    EnableExportField enableExportField = field.getDeclaredAnnotation(EnableExportField.class);
                    colNames.add(enableExportField.colName());
                    fieldList.add(field);
                }
            }
            //设置每列的宽度
            for(int i=0;i<fieldList.size();i++){
                Field field = fieldList.get(i);
                hssfsheet.setColumnWidth(i,field.getDeclaredAnnotation(EnableExportField.class).colWidth()*20);
            }

            HSSFRow hssfRow = null;
            HSSFCell hssfcell = null;

            //绘制表头以及菜单
            String fileName =export.fileName();

            //绘制标题
            createTitle(workbook,hssfRow,hssfcell,hssfsheet, colNames.size()-1,fileName);
            //创建标题行（表头）
            createHeadRow(workbook,hssfRow,hssfcell,hssfsheet,colNames);

            try {
                //表格样式
                HSSFCellStyle cellStyle= getBasicCellStyle(workbook);
                //插入内容
                int i=0;
                for (Object obj : dataList) {
                    hssfRow = hssfsheet.createRow(i + 2);
                    for(int j=0;j<fieldList.size();j++){
                        Field field = fieldList.get(j);
                        field.setAccessible(true);
                        Object value = field.get(obj);
                       // logger.info("导出数据=="+value);
                        hssfcell =hssfRow.createCell(j);
                        hssfcell.setCellStyle(cellStyle);
                        hssfcell.setCellValue(String.valueOf(value));
                    }
                    i++;
                }
                //创建下拉列表
                createDataValidation(hssfsheet,selectListMap);


                response.setHeader("Content-disposition", "attachment; filename="+fileName+".xls");
               // response.setHeader("Access-Control-Allow-Origin","*");
                response.setContentType("application/vnd.ms-excel");
                OutputStream ouputStream = response.getOutputStream();
                workbook.write(ouputStream);
                ouputStream.flush();
                ouputStream.close();

            } catch (IllegalAccessException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 获取一个基本的带边框的单元格
     * @param workbook
     * @return
     */
    private static HSSFCellStyle getBasicCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle hssfcellstyle = workbook.createCellStyle();
        hssfcellstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        hssfcellstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        hssfcellstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        hssfcellstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        hssfcellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        hssfcellstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        hssfcellstyle.setWrapText(true);
        return hssfcellstyle;
    }

    /**
     * 获取带有背景色的标题单元格
     * @param workbook
     * @return
     */
    private static HSSFCellStyle getTitleCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle hssfcellstyle =  getBasicCellStyle(workbook);
        hssfcellstyle.setFillForegroundColor((short) HSSFColor.CORNFLOWER_BLUE.index); // 设置背景色
        hssfcellstyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        return hssfcellstyle;
    }

    /**
     * 创建一个跨列的标题行
     * @param workbook
     * @param hssfRow
     * @param hssfcell
     * @param hssfsheet
     * @param allColNum
     * @param title
     */
    private static void createTitle(HSSFWorkbook workbook, HSSFRow hssfRow , HSSFCell hssfcell, HSSFSheet hssfsheet,int allColNum,String title){
        //在sheet里增加合并单元格
        CellRangeAddress cra = new CellRangeAddress(0, 0, 0, allColNum);
        hssfsheet.addMergedRegion(cra);
        // 使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderBottom(1, cra, hssfsheet, workbook); // 下边框
        RegionUtil.setBorderLeft(1, cra, hssfsheet, workbook); // 左边框
        RegionUtil.setBorderRight(1, cra, hssfsheet, workbook); // 有边框
        RegionUtil.setBorderTop(1, cra, hssfsheet, workbook); // 上边框

        //设置表头
        hssfRow = hssfsheet.getRow(0);
        hssfcell = hssfRow.getCell(0);
        hssfcell.setCellStyle( getTitleCellStyle(workbook));
        hssfcell.setCellType(HSSFCell.CELL_TYPE_STRING);
        hssfcell.setCellValue(title);
    }

    /**
     * 设置表头标题栏以及表格高度
     * @param workbook
     * @param hssfRow
     * @param hssfcell
     * @param hssfsheet
     * @param colNames
     */
    private static void createHeadRow(HSSFWorkbook workbook,HSSFRow hssfRow , HSSFCell hssfcell,HSSFSheet hssfsheet,List<String> colNames){
        //插入标题行
        hssfRow = hssfsheet.createRow(1);
        for (int i = 0; i < colNames.size(); i++) {
            hssfcell = hssfRow.createCell(i);
            hssfcell.setCellStyle(getTitleCellStyle(workbook));
            hssfcell.setCellType(HSSFCell.CELL_TYPE_STRING);
            hssfcell.setCellValue(colNames.get(i));
        }
    }
    /**
     * excel添加下拉数据校验
     * @param sheet 哪个 sheet 页添加校验
     * @return
     */
    public static void createDataValidation(Sheet sheet,Map<Integer,String[]> selectListMap) {
        if(selectListMap!=null) {
            selectListMap.forEach(
                    // 第几列校验（0开始）key 数据源数组value
                    (key, value) -> {
                        if(value.length>0) {
                            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(2, 65535, key, key);
                            DataValidationHelper helper = sheet.getDataValidationHelper();
                            DataValidationConstraint constraint = helper.createExplicitListConstraint(value);
                            DataValidation dataValidation = helper.createValidation(constraint, cellRangeAddressList);
                            //处理Excel兼容性问题
                            if (dataValidation instanceof XSSFDataValidation) {
                                dataValidation.setSuppressDropDownArrow(true);
                                dataValidation.setShowErrorBox(true);
                            } else {
                                dataValidation.setSuppressDropDownArrow(false);
                            }
                            dataValidation.setEmptyCellAllowed(true);
                            dataValidation.setShowPromptBox(true);
                            dataValidation.createPromptBox("提示", "只能选择下拉框里面的数据");
                            sheet.addValidationData(dataValidation);
                        }
                    }
            );
        }
    }
}
