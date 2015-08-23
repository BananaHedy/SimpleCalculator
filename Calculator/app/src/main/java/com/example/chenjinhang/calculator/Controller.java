package com.example.chenjinhang.calculator;

import android.content.Context;

import com.example.chenjinhang.calculator.operator.Operator;
import com.example.chenjinhang.calculator.responser.Responser;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public class Controller {
    private IShell mShell;
    private Context context;
    private Memory mMemory;
    private Stack<BigDecimal> mNumberStack;
    private Stack<Operator> mOperatorStack;
    private ResponserFactory mResponserFactory;
    private String mInputText;
    private String mResultText;

    public Controller(Context context, IShell shell) {
        this.context = context;
        this.mShell = shell;
        mMemory = new Memory();
        mNumberStack = new Stack<>();
        mOperatorStack = new Stack<>();
        mResponserFactory = ResponserFactory.getInstance(context);
    }

    public void performOnResponse(MiButton miButton) {
        Responser responser = miButton.getResponser();
        if (responser == null) {
            responser = mResponserFactory.createResponser(miButton.getName());
            if (responser == null) {
                return;
            }
            miButton.setResponser(responser);
        }
        responser.onResponse(mMemory);
        mInputText = mMemory.toString();
        refreshScreen();
    }

    public void clear() {
        mInputText = "0";
        mResultText = "";
        reset();
        refreshScreen();
    }

    private void reset() {
        mMemory.clear();
        mNumberStack.clear();
        mOperatorStack.clear();
    }

    public void delete() {
        mMemory.deleteLast();
        mInputText = mMemory.toString();
        refreshScreen();
    }

    public void calculate() {
        while (!mOperatorStack.isEmpty()) {
            mOperatorStack.pop().onOperate(mNumberStack, mOperatorStack);
        }
        if (!mNumberStack.isEmpty() && mNumberStack.size() == 1) {
            BigDecimal finalResult = mNumberStack.pop();
            mResultText = mMemory.toString();
            mInputText = finalResult.toPlainString();
        } else {
            error();
        }
        reset();
        refreshScreen();
    }

    private void error() {
        mInputText = "出错";
        mResultText = "";
    }

    private void refreshScreen() {
        if (mShell != null) {
            mShell.refreshScreen(mInputText, mResultText);
        }
    }

    interface IShell {
        void refreshScreen(String inputScreen, String resultScreen);
    }
}
