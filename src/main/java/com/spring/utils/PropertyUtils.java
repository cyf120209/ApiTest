package com.spring.utils;

import org.apache.log4j.lf5.util.ResourceUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class PropertyUtils {

    public static String getProperty(String key) {
        String value="";
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("ajaxFilter.properties");
            value=properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e);
        }
        return value;
    }

}
