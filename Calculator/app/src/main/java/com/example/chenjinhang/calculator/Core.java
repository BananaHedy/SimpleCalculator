package com.example.chenjinhang.calculator;

import com.example.chenjinhang.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public class Core {
    private static Stack<BigDecimal> mNumberStack = new Stack<>();
    private static Stack<Operator> mOperatorStack = new Stack<>();


    public static String calculate(Memory memory) throws IllegalStateException {
        //分析输入构造栈
        while(memory.hasNextUnit()){
            if(memory.isNextNumber()){
                String number = memory.getNext();
                mNumberStack.push(new BigDecimal(number));
            }else{
                String operatorName = memory.getNext();
                //Operator operator = Factory.createOperator(name);
                //if(mOperatorStack.isEmpty()==true){
                //push();
                //}else{
                // Operator lastOperator = mOperatorStack.getLastOpe();
                // if(priorityHigher){
                //  push();
                // }else{
                //  lastOperator.onOperate();
                // }
                // }
            }
        }
        //处理剩余栈
        while (!mOperatorStack.isEmpty()) {
            mOperatorStack.pop().onOperate(mNumberStack, mOperatorStack);
        }
        if (!mNumberStack.isEmpty() && mNumberStack.size() == 1) {
            BigDecimal finalResult = mNumberStack.pop();
            return finalResult.toPlainString();
        }
    }
    public static void reset(){
        mNumberStack.clear();
        mOperatorStack.clear();
    }
}
