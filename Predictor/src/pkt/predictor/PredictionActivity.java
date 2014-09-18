package pkt.predictor;

import java.util.UUID;

import android.support.v4.app.Fragment;

public class PredictionActivity extends SingleFragmentActivity {
	private final String TAG = "PredictionActivity";

	@Override
	protected Fragment createFragment() {
		return new PredictionFragment();
		
//		UUID predictionId = (UUID)getIntent()
//				.getSerializableExtra(PredictionFragment.EXTRA_PREDICTION_ID);
//		return PredictionFragment.newInstance(predictionId);
	}
}
