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

    public BigDecimal calculate(Memory memory) throws IllegalStateException {
        //分析输入构造栈
        preProcessStack(memory);
        //处理剩余栈
        postProcessStack();
        if(mNumberStack.size()!=1){
            throw new IllegalStateException("出错");
        }
        BigDecimal decimalResult = mNumberStack.pop();
        return decimalResult;

    }
    private void preProcessStack(Memory memory){
        MemoryReader memoryReader = new MemoryReader(memory,false);

        while (memoryReader.hasIndex()) {
            switch (memoryReader.getIndexInputType()) {
                case InputType.type_operator:
                    InputItem item = memoryReader.readIndexItem();
                    Operator operator = OperatorFactory.getInstance(context).createOperator(item.getName());
                    while (mOperatorStack.isEmpty() == false) {
                        Operator topOperator = mOperatorStack.peek();
                        if (topOperator.getPriority() >= operator.getPriority()) {
                            topOperator = mOperatorStack.pop();
                            topOperator.onOperate(mNumberStack, mOperatorStack);
                        } else {
                            break;
                        }
                    }
                    mOperatorStack.push(operator);
                    break;
                case InputType.type_number:
                    String number = memoryReader.readIndexUnit();
                    mNumberStack.push(new BigDecimal(number));
                    break;
                case InputType.type_bracket:
                    if("right_bracket".equals(memoryReader.getIndexItem().getName())){
                        memoryReader.nextIndex();
                        continue;
                    }
                    memoryReader.nextIndex();
                    Memory internalMemory = new Memory();
                    int depth = 1;
                    while(memoryReader.hasIndex()){
                        InputItem internalItem = memoryReader.readIndexItem();
                        //internalItem如果是右括号break;
                        if("left_bracket".equals(internalItem.getName())){
                            depth++;
                        }
                        if("right_bracket".equals(internalItem.getName())){
                            depth--;
                        }
                        if(depth == 0) {
                            break;
                        }
                        internalMemory.input(internalItem);
                    }
                    BigDecimal internalResult = new Core(context).calculate(internalMemory);
                    mNumberStack.push(internalResult);
                    break;
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
