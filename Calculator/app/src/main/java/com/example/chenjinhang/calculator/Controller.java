package com.example.chenjinhang.calculator;

import android.content.Context;

import com.example.chenjinhang.calculator.responser.Responser;
import com.example.chenjinhang.calculator.responser.ResponserFactory;

/**
 * Created by chenjinhang on 2015/8/20.
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
        refreshScreen(true);
    }

    public void clear() {
        reset();
        refreshScreen(true);
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
        refreshScreen(true);
    }

    public void calculate() {
        try {
            mResultText = mInputText+"=";
            String calculateResult = mCore.calculate(mMemory).toString();
            calculateResult = Util.subZeroAndDot(calculateResult);
            mMemory.reset();
            mMemory.input(new InputItem(calculateResult,calculateResult,InputType.type_number,true));
            mInputText = calculateResult;
        } catch (IllegalStateException|ArithmeticException e) {
            reset();
            e.printStackTrace();
            error(e.getMessage());
        }
        refreshScreen(false);
    }

    private void error(String msg) {
        mInputText = msg;
        mResultText = "";
    }

    private void refreshScreen(boolean foucsEnd) {
        if (mShell != null) {
            mShell.refreshScreen(mInputText, mResultText , foucsEnd);
        }
    }

    interface IShell {
        void refreshScreen(String inputScreen, String resultScreen,boolean foucsEnd);
    }
}
