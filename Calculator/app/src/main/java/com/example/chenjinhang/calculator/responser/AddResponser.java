package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.operator.AddOperator;
import com.example.chenjinhang.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class AddResponser extends Responser {

    @Override
    public void onResponse(StringBuilder memomry, Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) {
        String lastChar = memomry.substring(memomry.length() - 1);
        if(!lastChar.equals(buttonText)){
            memomry.append(buttonText);
            operatorStack.push(new AddOperator());
        }
    }
}
