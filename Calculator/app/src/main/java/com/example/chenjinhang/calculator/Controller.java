package com.example.chenjinhang.calculator;

import android.content.Context;

import com.example.chenjinhang.calculator.responser.Responser;
import com.example.chenjinhang.calculator.responser.ResponserFactory;

/**
 * Created by HappyBanana on 2015/8/20.
 */
public class Controller {
    private Context context;
    private IShell mShell;
    private Core mCore;
    private Memory mMemory;
    private String mInputText;
    private String mResultText;

    public Controller(Context context, IShell shell) {
        this.context = context;
        this.mShell = shell;
        mCore = new Core(context);
        mMemory = new Memory();
    }

    public void performOnResponse(MiButton miButton) {
        Responser responser = miButton.getResponser();
        if (responser == null) {
            responser = ResponserFactory.getInstance(context).createResponser(miButton.getName());
            if (responser == null) {
                return;
            }
            miButton.setResponser(responser);
        }
        responser.onResponse(mMemory);
        mInputText = mMemory.toString();
        refreshScreen(true,false);
    }

    public void clear() {
        reset();
        refreshScreen(true,false);
    }

    private void reset() {
        mInputText = "0";
        mResultText = "";
        mCore.reset();
        mMemory.reset();
    }

    public void delete() {
        if(mMemory.size()==1){
            mResultText = "";
        }
        if(!mMemory.isEmpty()){
            mMemory.removeLastInput();
        }
        mInputText = mMemory.toString();
        refreshScreen(true,false);
    }

    public void calculate() {
        try {
            mInputText = mInputText+"=";
            refreshScreen(true, false);

            String calculateResult = mCore.calculate(mMemory).stripTrailingZeros().toEngineeringString();
            mMemory.reset();
            mMemory.input(new InputItem(calculateResult, calculateResult, InputType.type_number, true));

            mResultText = mInputText;
            mInputText = calculateResult;
            refreshScreen(false,true);
        } catch (IllegalStateException|ArithmeticException e) {
            reset();
            e.printStackTrace();
            error(e.getMessage());
            refreshScreen(false,false);
        }
    }

    private void error(String msg) {
        mInputText = msg;
        mResultText = "";
    }

    private void refreshScreen(boolean foucsEnd,boolean showAnimation) {
        if (mShell != null) {
            mShell.refreshScreen(mInputText, mResultText , foucsEnd,showAnimation);
        }
    }

    interface IShell {
        void refreshScreen(String inputScreen, String resultScreen,boolean foucsEnd,boolean showAnimation);
    }
}
