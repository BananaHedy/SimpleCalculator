package com.example.chenjinhang.calculator.operator;

import com.example.chenjinhang.calculator.OperatePriority;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class AddOperator extends Operator {
    public AddOperator() {
        super(OperatePriority.PRIORITY_ADD, OPERATE_NUM_ONE);
    }

    @Override
    public void onOperate(Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) throws IllegalStateException {
        if (numberStack.size() < mOperateNum){
            throw new IllegalStateException("操作数不足");
        }
        BigDecimal firstDecimal = numberStack.pop();
        BigDecimal secondDecimal = numberStack.pop();
        numberStack.push(firstDecimal.add(secondDecimal));
    }
}
