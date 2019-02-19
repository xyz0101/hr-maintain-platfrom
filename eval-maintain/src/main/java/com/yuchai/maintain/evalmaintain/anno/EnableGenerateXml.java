package com.yuchai.maintain.evalmaintain.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 配置允许生成xml文件
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableGenerateXml {
    public boolean generateCURD() default  false;
    public String xmlName() default  "";
    public String classPath()  ;
}
