package com.example.chenjinhang.calculator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.chenjinhang.calculator.responser.Responser;

/**
 * Created by chenjinhang on 2015/8/19.
 */
public class MiButton extends Button {
    private String mName;
    private Responser mResponser;

    public MiButton(Context context) {
        super(context);
    }

    public MiButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs == null) {
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MiButton);
        mName = a.getString(R.styleable.MiButton_button_name);
        a.recycle();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Responser getResponser() {
        return mResponser;
    }

    public void setResponser(Responser responser) {
        mResponser = responser;
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if (style == Typeface.BOLD) {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "MIUI_normal1.ttf"));
        } else {
            super.setTypeface(tf, style);
        }
    }
}
