package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.Memory;

/**
 * Created by HappyBanana on 2015/8/20.
 */
public abstract class Responser {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void onResponse(Memory memory);
}
