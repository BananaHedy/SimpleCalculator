package com.example.chenjinhang.calculator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public interface IOperator {
    void onOperate(Stack<BigDecimal> numberStack,Stack<IOperator> operatorStack) throws IllegalStateException;
}
