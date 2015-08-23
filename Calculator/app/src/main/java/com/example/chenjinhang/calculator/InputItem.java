package com.example.chenjinhang.calculator;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class InputItem {
    private String symbol;
    private int type;

    public int getType() {
        return type;
    }

    public String getSymbol() {
        return symbol;
    }

    public InputItem(String symbol,int type) {
        this.symbol = symbol;
        this.type = type;
    }
}
