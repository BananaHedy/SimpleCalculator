package com.example.chenjinhang.calculator.operator;

import com.example.chenjinhang.calculator.OperatePriority;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/25.
 */
public class RightBracketOperator extends Operator {
    public RightBracketOperator() {
        super(OperatePriority.PRIORITY_RIGHT_BRACKET, OPERATE_NUM_ZERO);
    }

    @Override
    public void onOperate(Stack<BigDecimal> numberStack, Stack<Operator> operatorStack) throws IllegalStateException {
        while (!operatorStack.isEmpty() && !(operatorStack.peek() instanceof LeftBracketOperator)) {
            operatorStack.pop().onOperate(numberStack,operatorStack);
        }
    }
}
