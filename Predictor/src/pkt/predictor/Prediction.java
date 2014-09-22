package pkt.predictor;
import java.util.Date;
import java.util.UUID;


public class Prediction {
	private UUID mId;
	private String mTicker;
	private int mThreshold;
	private int mComparison; // 0 : LT, 1 : GT, 2 : ==
	private Date mTriggerDate;
	private Date mCreationDate;
	
	public Prediction() {
		// Generate unique id
		mId = UUID.randomUUID();
		mCreationDate = new Date();
		mTriggerDate = new Date();
	}
	
	@Override
	public String toString() {
		return mTicker + ": " + mThreshold;
	}
	
	public String getTitle() {
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

	public Date getTriggerDate() {
		return mTriggerDate;
	}

	public void setTriggerDate(Date mTriggerDate) {
		this.mTriggerDate = mTriggerDate;
	}

	public Date getCreationDate() {
		return mCreationDate;
	}

	private void setCreationDate(Date mCreationDate) {
		// Don't let anyone modify creation date
		this.mCreationDate = mCreationDate;
	}

	public UUID getId() {
		return mId;
	}

}
