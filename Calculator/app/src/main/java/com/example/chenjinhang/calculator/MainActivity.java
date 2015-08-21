package com.example.chenjinhang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.chenjinhang.calculator.responser.Responser;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements Controller.IShell {
    @ViewById
    TextView mTextViewResult;
    @ViewById
    TextView mTextViewInput;
    private Controller mController;


    @AfterViews
    public void init() {
        mController = new Controller(this,this);

    }

    @Click({R.id.mBtnOne, R.id.mBtnTwo, R.id.mBtnThree, R.id.mBtnFour, R.id.mBtnFive, R.id.mBtnSix, R.id.mBtnSeven, R.id.mBtnEight, R.id.mBtnNine, R.id.mBtnZero, R.id.mBtnPoint, R.id.mBtnAdd, R.id.mBtnSub, R.id.mBtnMutiply, R.id.mBtnDivide, R.id.mBtnRightBracket, R.id.mBtnLeftBracket})
    public void onInputClick(View view){
        MiButton miButton = (MiButton)view;
        mController.performOnResponse(miButton);
    }
    @Click({R.id.mBtnClear, R.id.mBtnEqual})
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
    public void refreshScreen(String inputText, String resultText) {
        mTextViewInput.setText(inputText);
        mTextViewResult.setText(resultText);
    }
}
