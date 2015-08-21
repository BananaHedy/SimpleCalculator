package com.example.chenjinhang.calculator.operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public abstract class Operator {

    public abstract void onOperate(Stack<BigDecimal> numberStack,Stack<Operator> operatorStack) throws IllegalStateException;
}
