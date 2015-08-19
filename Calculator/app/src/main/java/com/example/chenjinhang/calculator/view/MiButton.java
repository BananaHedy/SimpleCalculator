package com.example.chenjinhang.calculator.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by chenjinhang on 2015/8/19.
 */
public class MiButton extends Button {
    public MiButton(Context context) {
        super(context);
    }

    public MiButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MiButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if(style == Typeface.BOLD){
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"MIUI_normal1.ttf"));
        }else{
            super.setTypeface(tf, style);
        }
    }
}
