package com.example.chenjinhang.calculator.operator;

import com.example.chenjinhang.calculator.OperatePriority;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/24.
 */
public class SubtractOperator extends Operator {
    public SubtractOperator() {
        super(OperatePriority.PRIORITY_SUBTRACT, OPERATE_NUM_TWO);
    }

    @Override
    public void onOperate(Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) throws IllegalStateException {
        if (numberStack.size() < getOperateNum()){
            throw new IllegalStateException("操作数不足");
        }
        BigDecimal firstDecimal = numberStack.pop();
        BigDecimal secondDecimal = numberStack.pop();
        numberStack.push(secondDecimal.subtract(firstDecimal));
    }
}
