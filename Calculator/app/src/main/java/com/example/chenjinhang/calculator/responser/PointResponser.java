package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.Core;
import com.example.chenjinhang.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class PointResponser extends Responser {
    @Override
    public void onResponse(StringBuilder memomry, Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) {
        //空不加
        if (memomry.length() == 0) {
            return;
        }
        //运算符后面不加
        String lastChar = Core.getLastIfOperator(memomry.toString());
        if (lastChar != null) {
            return;
        }
        //数字有点不加
        String lastNumber = Core.getLastIfNumber(memomry.toString());
        if (lastNumber != null) {
            if (lastNumber.contains(buttonText)) {
                return;
            }
        }

        memomry.append(buttonText);
    }
}
