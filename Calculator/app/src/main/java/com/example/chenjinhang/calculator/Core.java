package com.example.chenjinhang.calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public class Core {
    private static Set<String> operatorSet;
    static{
        operatorSet = new HashSet<>();
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("×");
        operatorSet.add("÷");
        operatorSet.add("(");
        operatorSet.add(")");
    }
    public static String getLastIfNumber(String memory) {
        String numberPattern = "([0-9]+\\.?[0-9]*)$";
        Pattern pattern = Pattern.compile(numberPattern);
        Matcher matcher = pattern.matcher(memory);
        int count = matcher.groupCount();

        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }
    public static String getLastIfOperator(String memory){
        if(memory.length()>0){
            String lastChar  = memory.substring(memory.length()-1);
            if(operatorSet.contains(lastChar)){
                return lastChar;
            }
        }
        return null;
    }

}
