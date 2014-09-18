package pkt.predictor;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


// Controller that interacts with model:Prediction and views:??
public class PredictionFragment extends Fragment {
	private Prediction mPrediction;
	private EditText mTicker;
	private Button mDateButton;
	
	private final String TAG = "PredictorFragment";
	
	public static final String EXTRA_PREDICTION_ID = "pkt.predictor.prediction_id";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "OnCreate");
		super.onCreate(savedInstanceState);
		UUID predictionId = (UUID)getArguments().getSerializable(EXTRA_PREDICTION_ID);
		mPrediction = PredictionLab.get(getActivity()).getPrediction(predictionId);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");
		View v = inflater.inflate(R.layout.fragment_prediction, parent, false);
		
		mTicker = (EditText)v.findViewById(R.id.prediction_title);
		mTicker.setText(mPrediction.getTicker());
		mTicker.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mPrediction.setTicker(c.toString());
			}
			public void beforeTextChanged(CharSequence c, int start, int before, int count) {}
			public void afterTextChanged(Editable c) {}
		});
		
		mDateButton = (Button)v.findViewById(R.id.prediction_date);
		mDateButton.setText(mPrediction.getTriggerDate().toString());
		mDateButton.setEnabled(false);
		
		return v;
	}

	public static PredictionFragment newInstance(UUID id) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_PREDICTION_ID, id);
		PredictionFragment fragment = new PredictionFragment();
		fragment.setArguments(args);
		return fragment;
	}	


}
