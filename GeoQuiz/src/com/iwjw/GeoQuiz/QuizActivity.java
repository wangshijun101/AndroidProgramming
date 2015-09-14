package com.iwjw.GeoQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.util.logging.Logger;

public class QuizActivity extends Activity {
    private static final String TAG = "QuizActivity";

    private static final String KEY_INDEX = "index";

    private Button mTrueButton,mFalseButton;
    private ImageButton mPreButton,mNextButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_africa,true),
            new TrueFalse(R.string.question_asia,true),
            new TrueFalse(R.string.question_mideast,false),
            new TrueFalse(R.string.question_oceans,false)
    };
    private int mCurrentIndex = 0;

    private boolean mIsCheater;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if(savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
        }

        Log.d(TAG, "onCreate called");
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mPreButton = (ImageButton) findViewById(R.id.pre_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = mCurrentIndex - 1;
                if(mCurrentIndex < 0){
                    mCurrentIndex = (mCurrentIndex + mQuestionBank.length) % mQuestionBank.length;
                }else{
                    mCurrentIndex = mCurrentIndex % mQuestionBank.length;
                }

                updateQuestion();
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this,CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();
                intent.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE,answerIsTrue);

                startActivityForResult(intent,0);
            }
        });
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX,mCurrentIndex);
    }

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //接收子串口回传的值
        if(data == null)
            return;
        mIsCheater = data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOW,false);
        Log.d(TAG, "Already get result data from the sub windows. and the result is " + mIsCheater);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();
        int messageResId = 0;
        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this,messageResId,Toast.LENGTH_SHORT).show();
    }
}
