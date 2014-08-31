package pkt.criminalintent;

import android.support.v4.app.Fragment;
import android.util.Log;

public class CrimeListActivity extends SingleFragmentActivity {
	
	public static final String TAG = "CrimeListActivity";
	

	@Override
	protected Fragment createFragment() {
		Log.d(TAG, "createFragment");
		return new CrimeListFragment();
	}

}
