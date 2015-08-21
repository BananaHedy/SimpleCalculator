package com.example.chenjinhang.calculator.operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public abstract class Operator {
    public static final int OPERATE_NUM_ONE = 1;
    public static final int OPERATE_NUM_TWO = 2;
    public static final int OPERATE_NUM_THREE = 3;

    protected int mPriority;
    protected int mOperateNum;

    public Operator(int priority, int operateNum) {
        this.mPriority = priority;
        this.mOperateNum = operateNum;
    }

    public abstract void onOperate(Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) throws IllegalStateException;
}
