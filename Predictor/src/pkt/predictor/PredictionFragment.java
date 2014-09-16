package pkt.predictor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

// Controller that interacts with model:Prediction and views:??
public class PredictionFragment extends Fragment {
	private Prediction mPrediction;
	private EditText mTicker;
	private final String TAG = "PredictorFragment";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "OnCreate");
		super.onCreate(savedInstanceState);
		mPrediction = new Prediction();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");
		View v = inflater.inflate(R.layout.fragment_prediction, parent, false);
		
		mTicker = (EditText)v.findViewById(R.id.prediction_title);
		mTicker.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mPrediction.setTicker(c.toString());
			}
			public void beforeTextChanged(CharSequence c, int start, int before, int count) {}
			public void afterTextChanged(Editable c) {}
		});
		return v;
	}

}
