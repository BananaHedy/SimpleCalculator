package com.example.chenjinhang.calculator;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class SymbolMap {
    private static SymbolMap symbolMap;
    private static Map<String,String> map;
    private SymbolMap(Context context){
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open("symbol.properties");
            Properties properties = new Properties();
            properties.load(new InputStreamReader(inputStream,"utf-8"));
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
    public static SymbolMap getInstance(Context context){
        if(symbolMap ==null){
            symbolMap = new SymbolMap(context);
        }
        return symbolMap;
    }

    public static String getSymbol(String name){
        return map.get(name);
    }
}
