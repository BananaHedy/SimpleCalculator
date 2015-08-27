package com.example.chenjinhang.calculator;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements Controller.IShell {
    @ViewById
    TextView mTextViewResult;
    @ViewById
    EditText mTextViewInput;
    private Controller mController;
    private Animation result_anim ;
    private Animation input_anim ;

    @AfterViews
    public void init() {
        mController = new Controller(this, this);
        initAnimation();
    }
    private void initAnimation(){
        result_anim = AnimationUtils.loadAnimation(this, R.anim.result_anim);
        input_anim = AnimationUtils.loadAnimation(this, R.anim.input_anim);
    }
    @Click({R.id.mBtnOne, R.id.mBtnTwo, R.id.mBtnThree, R.id.mBtnFour, R.id.mBtnFive, R.id.mBtnSix, R.id.mBtnSeven, R.id.mBtnEight, R.id.mBtnNine, R.id.mBtnZero, R.id.mBtnPoint, R.id.mBtnAdd, R.id.mBtnSub, R.id.mBtnMutiply, R.id.mBtnDivide, R.id.mBtnRightBracket, R.id.mBtnLeftBracket})
    public void onInputClick(View view) {
        MiButton miButton = (MiButton) view;
        mController.performOnResponse(miButton);
    }

    @Click({R.id.mBtnClear, R.id.mBtnEqual, R.id.mBtnDelete})
    public void onControlClick(View view) {
        switch (view.getId()) {
            case R.id.mBtnEqual:
                mController.calculate();
                break;
            case R.id.mBtnClear:
                mController.clear();
                break;
            case R.id.mBtnDelete:
                mController.delete();
                break;
        }
    }

    @Override
    public void refreshScreen(final String inputText,final String resultText, boolean foucsEnd, boolean showAnimation) {
        mTextViewResult.setText(resultText);
        mTextViewInput.setText(inputText);
        if (showAnimation) {
            mTextViewResult.startAnimation(result_anim);
            mTextViewInput.startAnimation(input_anim);
        }

        if (foucsEnd) {
            mTextViewInput.setSelection(inputText.length());
        }
    }
}
