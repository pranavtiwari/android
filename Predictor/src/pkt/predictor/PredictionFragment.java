package pkt.predictor;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
	private Button mCreationDateButton;
	private Button mTriggerDateButton;
	
	private final String TAG = "PredictorFragment";
	private static final String DIALOG_DATE = "date";
	
	public static final String EXTRA_PREDICTION_ID = "pkt.predictor.prediction_id";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "OnCreate");
		super.onCreate(savedInstanceState);


		UUID predictionId = (UUID)getArguments().getSerializable(EXTRA_PREDICTION_ID);
		Log.d(TAG, predictionId.toString());
 		mPrediction = PredictionLab.get(getActivity()).getPrediction(predictionId);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");
		View v = inflater.inflate(R.layout.fragment_prediction, parent, false);
		
		mTicker = (EditText)v.findViewById(R.id.prediction_title);
		mTicker.setText(mPrediction.getTitle());
		mTicker.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mPrediction.setTicker(c.toString());
			}
			public void beforeTextChanged(CharSequence c, int start, int before, int count) {}
			public void afterTextChanged(Editable c) {}
		});
		
		mTriggerDateButton = (Button)v.findViewById(R.id.trigger_date);
		mTriggerDateButton.setText(mPrediction.getTriggerDate().toString());
		mTriggerDateButton.setEnabled(true);
		mTriggerDateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				FragmentManager fm = getActivity()
					.getSupportFragmentManager();
				DatePickerFragment dialog = new DatePickerFragment();
				dialog.show(fm, DIALOG_DATE);
			}
		});
		
		mCreationDateButton = (Button)v.findViewById(R.id.creation_date);
		mCreationDateButton.setText(mPrediction.getCreationDate().toString());
		mCreationDateButton.setEnabled(false);
		
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
