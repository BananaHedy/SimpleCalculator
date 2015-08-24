package com.example.chenjinhang.calculator.operator;

import android.content.Context;

import com.example.chenjinhang.calculator.responser.Responser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chenjinhang on 2015/8/24.
 */
public class OperatorFactory {
    private static OperatorFactory mFactory;
    private Map<String,String> map;
    private OperatorFactory(Context context){
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open("operator.properties");
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
    public static OperatorFactory getInstance(Context context){
        if(mFactory==null){
            mFactory = new OperatorFactory(context);
        }
        return mFactory;
    }
    public Operator createOperator(String name){
        String className = map.get(name);
        Operator operator = null;
        try {
            operator = (Operator)Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return operator;
    }
}
