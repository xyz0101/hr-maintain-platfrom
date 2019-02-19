package com.yuchai.maintain.targetmaintain.utils;


import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class IgnoreDTDEntityResolver implements EntityResolver {
    /**
     * 忽略xml文件规范的校验
     * @param publicId
     * @param systemId
     * @return
     * @throws SAXException
     * @throws IOException
     */
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
    }
}
