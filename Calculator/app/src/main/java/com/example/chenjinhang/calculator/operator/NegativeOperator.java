package com.example.chenjinhang.calculator.operator;

import com.example.chenjinhang.calculator.OperatePriority;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by HappyBanana on 2015/8/25.
 */
public class NegativeOperator extends Operator {
    public NegativeOperator() {
        super(OperatePriority.PRIORITY_NEGATIVE, OPERATE_NUM_ONE);
    }

    @Override
    public void onOperate(Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) throws IllegalStateException {
        if(numberStack.size()<getOperateNum()){
            throw new IllegalStateException("操作数不够");
        }

        BigDecimal decimal = numberStack.pop();
        decimal = decimal.negate();
        numberStack.push(decimal);
    }
}
