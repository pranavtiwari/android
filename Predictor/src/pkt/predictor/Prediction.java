package pkt.predictor;
import java.util.Date;
import java.util.UUID;


public class Prediction {
	private UUID mId;
	private String mTicker;
	private int mThreshold;
	private int mComparison; // 0 : LT, 1 : GT, 2 : ==
	private Date mDate;
	
	public Prediction() {
		// Generate unique id
		mId = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return mTicker + ": " + mThreshold;
	}

	public String getTicker() {
		return mTicker;
	}

	public void setTicker(String ticker) {
		mTicker = ticker;
	}

	public int getThreshold() {
		return mThreshold;
	}

	public void setThreshold(int threshold) {
		mThreshold = threshold;
	}

	public int getComparison() {
		return mComparison;
	}

	public void setComparison(int comparison) {
		mComparison = comparison;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public UUID getId() {
		return mId;
	}

}
