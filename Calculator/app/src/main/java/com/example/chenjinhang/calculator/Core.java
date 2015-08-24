package com.example.chenjinhang.calculator;

import android.content.Context;

import com.example.chenjinhang.calculator.operator.Operator;
import com.example.chenjinhang.calculator.operator.OperatorFactory;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public class Core {
    private Context context;
    private Stack<BigDecimal> mNumberStack = new Stack<>();
    private Stack<Operator> mOperatorStack = new Stack<>();

    public Core(Context context) {
        this.context = context;
    }

    public String calculate(Memory memory) throws IllegalStateException {
        //分析输入构造栈
        preProcessStack(memory);
        //处理剩余栈
        postProcessStack();
        if(mNumberStack.isEmpty()){
            return "0";
        }
        BigDecimal finalResult = mNumberStack.pop();
        return finalResult.toPlainString();

    }
    private void preProcessStack(Memory memory){
        MemoryReader memoryReader = new MemoryReader(memory);
        while (memoryReader.hasNext(false)) {
            if (memoryReader.isIndexOperator()) {
                String operatorName = memoryReader.readNextUnit(false);
                Operator operator = OperatorFactory.getInstance(context).createOperator(operatorName);
                while (mOperatorStack.isEmpty() == false) {
                    Operator topOperator = mOperatorStack.peek();
                    if (topOperator.getPriority() >= operator.getPriority()) {
                        topOperator = mOperatorStack.pop();
                        topOperator.onOperate(mNumberStack, mOperatorStack);
                    }else{
                        break;
                    }
                }
                mOperatorStack.push(operator);
            } else {
                String number = memoryReader.readNextUnit(false);
                mNumberStack.push(new BigDecimal(number));
            }
        }
    }
    private void postProcessStack(){
        while (!mOperatorStack.isEmpty()) {
            mOperatorStack.pop().onOperate(mNumberStack, mOperatorStack);
        }
    }
    public void reset() {
        mNumberStack.clear();
        mOperatorStack.clear();
    }
}
