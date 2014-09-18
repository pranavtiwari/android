package pkt.predictor;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PredictionListFragment extends ListFragment {
	private ArrayList<Prediction> mPredictions;
	private static final String TAG = "PredictionListFragment";
	
	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		Log.d(TAG, "onCreate");
		getActivity().setTitle(R.id.prediction_title);
		mPredictions = PredictionLab.get(getActivity()).getPredictions();
		
		ArrayAdapter<Prediction> adapter =
				new ArrayAdapter<Prediction>(getActivity(), android.R.layout.simple_list_item_1, mPredictions);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Prediction p = (Prediction)(getListAdapter()).getItem(position);
		Log.d(TAG, p.getTicker() + " clicked");
	}

	private class PredictionAdapter extends ArrayAdapter<Prediction> {
		public PredictionAdapter(ArrayList<Prediction> predictions) {
			super(getActivity(), 0, predictions);
		}
	}
}
