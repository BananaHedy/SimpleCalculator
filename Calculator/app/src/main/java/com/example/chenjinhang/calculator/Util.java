package com.example.chenjinhang.calculator;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class Util {
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
