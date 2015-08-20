package com.example.chenjinhang.calculator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public interface IResponser {
    boolean onResponse(StringBuilder memomry,Stack<BigDecimal> numberStack,Stack<IOperator> operatorStack);
}
