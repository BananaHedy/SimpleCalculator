package com.example.chenjinhang.calculator.operator;

import android.preference.TwoStatePreference;

import com.example.chenjinhang.calculator.OperatePriority;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/24.
 */
public class DivideOperator extends Operator {
    public DivideOperator() {
        super(OperatePriority.PRIORITY_DIVIDE, OPERATE_NUM_TWO);
    }

    @Override
    public void onOperate(Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) throws IllegalStateException {
        if (numberStack.size() < getOperateNum()){
            throw new IllegalStateException("操作数不足");
        }
        BigDecimal firstDecimal = numberStack.pop();
        BigDecimal secondDecimal = numberStack.pop();
        numberStack.push(secondDecimal.divide(firstDecimal,8,BigDecimal.ROUND_HALF_UP));
    }
}
