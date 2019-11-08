package com.san.hospitalsystem.utils;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

  public static String getProperty(String name) {
    Properties properties;
    String value = null;

    try {
      properties = PropertiesLoaderUtils.loadAllProperties("hospital.properties");
      value = properties.getProperty(name);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return value.trim();
  }
}
