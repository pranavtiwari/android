package pkt.predictor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class DatePickerFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedState) {
		View v = getActivity().getLayoutInflater()
				.inflate(R.id.dialog_date_datePicker, null);
		return new AlertDialog.Builder(getActivity())
			.setView(v)
			.setTitle(R.string.trigger_date)
			.setPositiveButton(android.R.string.ok, null)
			.create();
	}
}
