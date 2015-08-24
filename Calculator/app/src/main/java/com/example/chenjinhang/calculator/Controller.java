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
        refreshScreen();
    }

    public void clear() {
        reset();
        refreshScreen();
    }

    private void reset() {
        mInputText = "0";
        mResultText = "";
        mCore.reset();
        mMemory.reset();
    }

    public void delete() {
        mMemory.removeLastInput();
        mInputText = mMemory.toString();
        refreshScreen();
    }

    public void calculate() {
        try {
            mResultText = mInputText;
            mInputText = mCore.calculate(mMemory);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            error();
        }
        refreshScreen();
        reset();
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
