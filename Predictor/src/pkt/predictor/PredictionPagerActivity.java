package pkt.predictor;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class PredictionPagerActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<Prediction> mPredictions;
	
	@Override
	public void onCreate(Bundle savedInstState) {
		super.onCreate(savedInstState);
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		
		mPredictions = PredictionLab.get(this).getPredictions();
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm){
			@Override
			public int getCount() {
				return mPredictions.size();
			}
			
			@Override
			public Fragment getItem(int pos) {
				Prediction pred = mPredictions.get(pos);
				return PredictionFragment.newInstance(pred.getId());
			}
		});
		
		UUID predictionId = (UUID)getIntent()
				.getSerializableExtra(PredictionFragment.EXTRA_PREDICTION_ID);
		for (int i = 0; i < mPredictions.size(); i++) {
			if (mPredictions.get(i).getId().equals(predictionId)) {
				mViewPager.setCurrentItem(i);
				break;
			}
		}
		
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				Prediction pred = mPredictions.get(pos);
				if (pred.getTitle() != null) {
					setTitle(pred.getTicker());
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
