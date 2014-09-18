package pkt.predictor;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PredictionListFragment extends ListFragment {
	private ArrayList<Prediction> mPredictions;
	private static final String TAG = "PredictionListFragment";
	
	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		Log.d(TAG, "onCreate");
		getActivity().setTitle(R.id.prediction_title);
		mPredictions = PredictionLab.get(getActivity()).getPredictions();
		
		setListAdapter(new PredictionAdapter(mPredictions));
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Prediction p = ((PredictionAdapter)getListAdapter()).getItem(position);
		Log.d(TAG, p.getTicker() + " clicked");
		
		// Start PredictionActivity
		Intent i = new Intent(getActivity(), PredictionActivity.class);
		// i.putExtra(PredictionFragment.EXTRA_PREDICTION_ID, p.getId());
		startActivity(i);
	}

	private class PredictionAdapter extends ArrayAdapter<Prediction> {
		public PredictionAdapter(ArrayList<Prediction> predictions) {
			super(getActivity(), 0, predictions);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Inflate a new view if needed
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_prediction, null);
			}
			
			// Configure the view for this prediction
			Prediction p = getItem(position);
			
			TextView titleTextView = (TextView)convertView.findViewById(R.id.prediction_list_item_titleTextView);
			titleTextView.setText(p.getTicker());
			
			TextView dateTextView = (TextView)convertView.findViewById(R.id.prediction_list_item_dateTextView);
			dateTextView.setText(p.getCreationDate().toString());
			
			return convertView;
		}
	}
}
