package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class SimpleNumberResponser extends Responser {

    @Override
    public boolean onResponse(StringBuilder memomry, Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) {
        memomry.append(buttonText);
        return false;
    }
}
