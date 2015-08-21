package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.Core;
import com.example.chenjinhang.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class SimpleNumberResponser extends Responser {

    @Override
    public void onResponse(StringBuilder memomry, Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) {
        String lastNumber = Core.getLastIfNumber(memomry.toString());
        if (lastNumber != null && !lastNumber.equals("") && !numberStack.empty()) {
            numberStack.pop();
        }
        memomry.append(buttonText);
        lastNumber = Core.getLastIfNumber(memomry.toString());
        if (lastNumber != null && !lastNumber.equals("")) {
            numberStack.push(new BigDecimal(lastNumber));
        }
    }


}
