package com.iwjw.GeoQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by flying on 9/12/2015 0012.
 */
public class CheatActivity extends Activity {

    private static final String TAG = "QuizActivity";

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.iwjw.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOW =
            "com.iwjw.geoquiz.answer_show";
    private Button mShowAnswer;
    private TextView mShowText;
    private boolean mAnswerIsTrue;
    private void setAnswerShowResult(boolean isAnswerShow){
        //将值回传给父窗口
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW,isAnswerShow);
        Log.d(TAG,"push a data to parent window! and the value is :" + isAnswerShow);
        setResult(RESULT_OK, data);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        //从父窗口获取值
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowText = (TextView)findViewById(R.id.answerTextView);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue)
                    mShowText.setText(R.string.true_button);
                else{
                    mShowText.setText(R.string.true_button);
                }
                setAnswerShowResult(mAnswerIsTrue);
            }
        });
    }

}