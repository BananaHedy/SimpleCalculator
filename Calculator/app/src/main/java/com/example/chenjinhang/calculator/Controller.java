package com.example.chenjinhang.calculator;

import android.view.View;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by chenjinhang on 2015/8/20.
 */
public class Controller {
    private IShell mShell ;
    private StringBuilder mMemory;
    private Stack<BigDecimal> mNumberStack;
    private Stack<IOperator> mOperatorStack;
    private String mInputScreen;
    private String mResultScreen;

    public void performOnResponse(View view) {
        // TODO: 2015/8/20
    }
    public void clear(){}
    public void delete(){}
    public void calculate(){}
    interface IShell {
        void refreshScreen(String inputScreen, String resultScreen);
    }
}
