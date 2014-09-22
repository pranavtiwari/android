package pkt.predictor;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

public class DatePickerFragment extends DialogFragment {
	public static final String EXTRA_DATE = "pkt.predictor.date";
	
	private Date mDate;

	public static DatePickerFragment newInstance(Date date) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_DATE, date);
		
		DatePickerFragment fragment = new DatePickerFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedState) {
		mDate = (Date)getArguments().getSerializable(EXTRA_DATE);
		
		// Create a calendar to get date
		Calendar cal = Calendar.getInstance();
		cal.setTime(mDate);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		View v = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_date, null);
		
		DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_datePicker);
		OnDateChangedListener onDateChangedListener = new OnDateChangedListener() {
			public void onDateChanged(DatePicker view, int year, int month, int day) {
				mDate = new GregorianCalendar(year, month, day).getTime();
				getArguments().putSerializable(EXTRA_DATE, mDate);
			}
		};

		datePicker.init(year, month, day, onDateChangedListener);

		return new AlertDialog.Builder(getActivity())
			.setView(v)
			.setTitle(R.string.trigger_date)
			.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							sendResult(Activity.RESULT_OK);
						}
					})
			.create();
	}
	
	private void sendResult(int resultCode) {
		if (getTargetFragment() == null) {
			return;
		}
		
		Intent i = new Intent();
		i.putExtra(EXTRA_DATE, mDate);
		
		getTargetFragment()
			.onActivityResult(getTargetRequestCode(), resultCode, i);
	}
}
