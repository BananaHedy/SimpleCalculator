package com.example.chenjinhang.calculator;

import android.app.Application;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class CalculateApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ResponserFactory.getInstance(this);
        SymbolMap.getInstance(this);
    }
}
