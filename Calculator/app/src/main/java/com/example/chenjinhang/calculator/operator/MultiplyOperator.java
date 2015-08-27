package com.example.chenjinhang.calculator.operator;

import com.example.chenjinhang.calculator.OperatePriority;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by HappyBanana on 2015/8/24.
 */
public class MultiplyOperator extends Operator {
    public MultiplyOperator() {
        super(OperatePriority.PRIORITY_MUTIPLY, OPERATE_NUM_TWO);
    }

    @Override
    public void onOperate(Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) throws IllegalStateException {
        if (numberStack.size() < getOperateNum()){
            throw new IllegalStateException("操作数不足");
        }
        BigDecimal firstDecimal = numberStack.pop();
        BigDecimal secondDecimal = numberStack.pop();
        numberStack.push(firstDecimal.multiply(secondDecimal));
    }
}
