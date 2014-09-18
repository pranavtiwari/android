package pkt.predictor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class PredictorActivity extends SingleFragmentActivity {
	private final String TAG = "PredictorActivity";

	@Override
	protected Fragment createFragment() {
		return new PredictionFragment();
	}
}
