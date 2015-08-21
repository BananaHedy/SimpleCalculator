package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public abstract class Responser {
    protected String buttonText;

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public abstract void onResponse(StringBuilder memomry,Stack<BigDecimal> numberStack,Stack<Operator> operatorStack);
}
