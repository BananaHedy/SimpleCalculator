package com.example.chenjinhang.calculator;

import android.content.Context;

import com.example.chenjinhang.calculator.responser.Responser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class ResponserFactory {
    private static ResponserFactory mFactory;
    private Map<String,String> map;
    private ResponserFactory(Context context){
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open("responser.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            map = new HashMap<>();
            for(String name:properties.stringPropertyNames()){
                map.put(name, properties.getProperty(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static ResponserFactory getInstance(Context context){
        if(mFactory==null){
            mFactory = new ResponserFactory(context);
        }
        return mFactory;
    }
    public Responser createResponser(String name){
        String className = map.get(name);
        Responser responser = null;
        try {
            responser = (Responser)Class.forName(className).newInstance();
            responser.setName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return responser;
    }
}
