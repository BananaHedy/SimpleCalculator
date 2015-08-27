package com.example.chenjinhang.calculator;

import android.content.Context;

import com.example.chenjinhang.calculator.operator.Operator;
import com.example.chenjinhang.calculator.operator.OperatorFactory;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by HappyBanana on 2015/8/20.
 */
public class Core {
    private Context context;
    private MemoryReader mMemoryReader;
    private Stack<BigDecimal> mNumberStack = new Stack<>();
    private Stack<Operator> mOperatorStack = new Stack<>();

    public Core(Context context) {
        this.context = context;
    }

    public BigDecimal calculate(Memory memory) throws IllegalStateException {
        mMemoryReader = new MemoryReader(memory, false);
        //构造栈
        contructStack();
        //处理剩余栈
        processStack();
        //分析结果栈
        analyzeNumberStack();
        BigDecimal decimalResult = mNumberStack.pop().setScale(8, BigDecimal.ROUND_HALF_UP);
        return decimalResult;

    }

    private void contructStack() {
        while (mMemoryReader.hasIndex()) {
            switch (mMemoryReader.getIndexInputType()) {
                case InputType.type_operator:
                    meetIndexTypeOperator();
                    break;
                case InputType.type_number:
                    meetIndexTypeNumber();
                    break;
                case InputType.type_bracket:
                    meetIndexTypeBracket();
                    break;
            }
        }
    }

    private void meetIndexTypeBracket() {
        if ("right_bracket".equals(mMemoryReader.getIndexItem().getName())) {
            mMemoryReader.nextIndex();
            //右括号不管
        } else {
            //将匹配的右括号内的内容放进内部储存，递归运算
            mMemoryReader.nextIndex();
            Memory internalMemory = new Memory();
            int depth = 1;
            while (mMemoryReader.hasIndex()) {
                InputItem internalItem = mMemoryReader.readIndexItem();
                //internalItem如果是右括号break;
                if ("left_bracket".equals(internalItem.getName())) {
                    depth++;
                }
                if ("right_bracket".equals(internalItem.getName())) {
                    depth--;
                }
                if (depth == 0) {
                    break;
                }
                internalMemory.input(internalItem);
            }
            BigDecimal internalResult = new Core(context).calculate(internalMemory);
            mNumberStack.push(internalResult);
        }
    }

    private void meetIndexTypeNumber() {
        String number = mMemoryReader.readIndexUnit();
        mNumberStack.push(new BigDecimal(number));
    }

    private void meetIndexTypeOperator() {
        InputItem item = mMemoryReader.readIndexItem();
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
    }

    private void processStack() {
        while (!mOperatorStack.isEmpty()) {
            mOperatorStack.pop().onOperate(mNumberStack, mOperatorStack);
        }
    }

    private void analyzeNumberStack() {
        if (mNumberStack.size() == 0) {
            throw new IllegalStateException("无结果");
        }
        if (mNumberStack.size() > 1) {
            throw new IllegalStateException("多于一个结果");
        }
    }

    public void reset() {
        mNumberStack.clear();
        mOperatorStack.clear();
    }
}
