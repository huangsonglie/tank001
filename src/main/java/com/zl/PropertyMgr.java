package com.zl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public final class PropertyMgr {

    private final static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if(props == null) return null;
        return props.get(key);
    }

    public static String getString(String key){
        if(props == null) return null;
        return (String) props.get(key);
    }
}
