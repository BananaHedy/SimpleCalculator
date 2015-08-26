package com.example.chenjinhang.calculator;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class InputItem {
    private String name;
    private String symbol;
    private int type;
    private boolean isSingleUnit;
    public int getType() {
        return type;
    }

    public String getSymbol() {
        return symbol;
    }

    public InputItem(String name,String symbol,int type,boolean isSingleUnit) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
        this.isSingleUnit = isSingleUnit;
    }

    public boolean isSingleUnit() {
        return isSingleUnit;
    }

    public void setIsSingleUnit(boolean isSingleUnit) {
        this.isSingleUnit = isSingleUnit;
    }

    public String getName() {
        return name;
    }
}
