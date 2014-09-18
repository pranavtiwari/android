package pkt.predictor;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class PredictionLab {
	private ArrayList<Prediction> mPredictions;

	private static PredictionLab sPredictionLab;
	private Context mAppContext;
	
	private PredictionLab(Context appContext) {
		mAppContext = appContext;
		mPredictions = new ArrayList<Prediction>();
		
		for (int i = 0; i < 100; i++) {
			Prediction p = new Prediction();
			p.setTicker("GOOG" + i);
			p.setThreshold(600 + i);
			p.setComparison(i % 2);
			mPredictions.add(p);
		}
	}
	
	public ArrayList<Prediction> getPredictions() {
		return mPredictions;
	}
	
	public Prediction getPrediction(UUID id) {
		for (Prediction p : mPredictions) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public static PredictionLab get(Context c) {
		if (sPredictionLab == null) {
			sPredictionLab = new PredictionLab(c);
		}
		return sPredictionLab;
	}
}
