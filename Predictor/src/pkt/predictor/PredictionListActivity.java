package pkt.predictor;

import android.support.v4.app.Fragment;

public class PredictionListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new PredictionListFragment();
	}

}
