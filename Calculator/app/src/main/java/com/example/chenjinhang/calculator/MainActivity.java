package com.example.chenjinhang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    TextView mTextViewInput;
    private Controller mController;
    @AfterViews
    public void init(){
        mController = new Controller();
    }
    @Click({R.id.mBtnClear,R.id.mBtnDelete,R.id.mBtnEqual})
    public void onControlClick(View view){
        switch (view.getId()){
            case R.id.mBtnEqual:
                break;
            case R.id.mBtnClear:
                break;
            case R.id.mBtnDelete:
                break;
        }
    }
    @Override
    public void refreshScreen(String inputScreen, String resultScreen) {
        mTextViewInput.setText(inputScreen);
        mTextViewResult.setText(resultScreen);
    }
}
