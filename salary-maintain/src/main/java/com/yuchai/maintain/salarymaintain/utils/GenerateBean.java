package com.yuchai.maintain.salarymaintain.utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenerateBean {
    private String table;
    private String outPath;
    private String packagePath;
    public  GenerateBean(String table,String outPath,String packagePath){
        this.outPath=outPath;
        this.table=table;
        this.packagePath = packagePath;
    }

    public boolean startGenerate()   {
        Connection conn = DBUtils.getConnection();
        String sql = "select * from "+this.table;
        PreparedStatement stat=null;
        try {
            stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            ResultSetMetaData data = rs.getMetaData();
            String className = Utils.toUpperCaseFirstOne(Utils.UnderlineToHump(this.table) );
            Map<String,String> fieldMap = new HashMap<String,String>();
            for (int i = 1; i <= data.getColumnCount(); i++) {
// 获得所有列的数目及实际列数
                int columnCount = data.getColumnCount();
// 获得指定列的列名
                String columnName = data.getColumnName(i);
// 获得指定列的列值
                int columnType = data.getColumnType(i);
// 获得指定列的数据类型名
                String columnTypeName = data.getColumnTypeName(i);
// 所在的Catalog名字
                String catalogName = data.getCatalogName(i);
// 对应数据类型的类
                String columnClassName = data.getColumnClassName(i);
// 在数据库中类型的最大字符个数
                int columnDisplaySize = data.getColumnDisplaySize(i);
// 默认的列的标题
                String columnLabel = data.getColumnLabel(i);
// 获得列的模式
                String schemaName = data.getSchemaName(i);
// 某列类型的精确度(类型的长度)
                int precision = data.getPrecision(i);
// 小数点后的位数
                int scale = data.getScale(i);
// 获取某列对应的表名
                String tableName = data.getTableName(i);
// 是否自动递增
                boolean isAutoInctement = data.isAutoIncrement(i);
// 在数据库中是否为货币型
                boolean isCurrency = data.isCurrency(i);
// 是否为空
                int isNullable = data.isNullable(i);
// 是否为只读
                boolean isReadOnly = data.isReadOnly(i);
// 能否出现在where中
                boolean isSearchable = data.isSearchable(i);

                String columnNameHump = Utils.UnderlineToHump(columnName);
                //日期类型用Date类型
                columnClassName=columnClassName.contains("Timestamp")?columnClassName="java.util.Date":columnClassName;
                fieldMap.put(columnNameHump,columnClassName);
                //生成文件



//                System.out.println(columnCount);
//                System.out.println("获得列" + i + "的字段名称:" + columnName);
//                System.out.println("获得列" + i + "的类型,返回SqlType中的编号:" + columnType);
//                System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
//                System.out.println("获得列" + i + "所在的Catalog名字:" + catalogName);
//                System.out.println("获得列" + i + "对应数据类型的类:" + columnClassName);
//                System.out.println("获得列" + i + "在数据库中类型的最大字符个数:" + columnDisplaySize);
//                System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
//                System.out.println("获得列" + i + "的模式:" + schemaName);
//                System.out.println("获得列" + i + "类型的精确度(类型的长度):" + precision);
//                System.out.println("获得列" + i + "小数点后的位数:" + scale);
//                System.out.println("获得列" + i + "对应的表名:" + tableName);
//                System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
//                System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
//                System.out.println("获得列" + i + "是否为空:" + isNullable);
//                System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
//                System.out.println("获得列" + i + "能否出现在where中:" + isSearchable);
            }
            createFile(className,fieldMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    private void createFile(String className, Map<String, String> fieldMap) {
        String path = this.outPath+className+".java";
        File f = new File(path);
        FileWriter fw =null;
        BufferedWriter bw = null;

        try {
//            if(!f.exists())
//                f.createNewFile();
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.write("package "+this.packagePath+";");
            bw.newLine();

            Set<String> set = new HashSet();
            for(Map.Entry<String,String> entry: fieldMap.entrySet()){
                set.add(entry.getValue());
            }
            for(String importClass:set){
                bw.write("import "+importClass+";");
                bw.newLine();
            }
            bw.newLine();
            bw.write("public class "+ className+"{");
            bw.newLine();
            for(Map.Entry<String,String> entry: fieldMap.entrySet()){
                String classType = entry.getValue().split("\\.")[entry.getValue().split("\\.").length-1];

                bw.write("private "+classType+ " "+entry.getKey() +";");
                bw.newLine();
            }
            bw.write("}");
            bw.newLine();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Utils.closeIo(bw);
            Utils.closeIo(fw);
        }


    }


}
