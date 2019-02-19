package com.yuchai.maintain.evalmaintain.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * (实体类上面使用)允许使用实体类生成resultMap
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableGenerateResMap {
    public String[] xmlNames() ;
    public String classPath()  ;
}
