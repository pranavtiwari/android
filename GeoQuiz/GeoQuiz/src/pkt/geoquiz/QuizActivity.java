package pkt.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends Activity {
	
	private Button mTrueButton;
	private Button mFalseButton;
	private ImageButton mNextButton;
	private ImageButton mPrevButton;
	private TextView mQuestionTextView;
	private static final String TAG = "QuizActivity";
	private static final String KEY_INDEX = "index";
	
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_const, false),
			new TrueFalse(R.string.question_ind, false),
			new TrueFalse(R.string.question_asia, true),
	};
	
	private int mCurrentIndex = 0;
	
	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
		updateQuestion();
		
		mTrueButton = (Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(QuizActivity.this,
						R.string.incorrect_toast,
						Toast.LENGTH_SHORT).show();
			}
		});
		
		mFalseButton = (Button)findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(QuizActivity.this,
						R.string.correct_toast,
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
		mNextButton = (ImageButton)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});

		mPrevButton = (ImageButton)findViewById(R.id.prev_button);
		mPrevButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (mCurrentIndex + mQuestionBank.length - 1) % mQuestionBank.length;
				updateQuestion();
			}
		});

		if (savedInstanceState != null) {
			mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		Log.i(TAG, "onSaveInstanceState");
		savedInstanceState.putInt(KEY_INDEX,  mCurrentIndex);
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

}