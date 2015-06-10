package com.sumitgup.granddatesofmylife;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;


public class AddDateDialog extends DialogFragment {

    Button mSubmitButton;
    DatePicker mDate;
    EditText mDescription;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.setContentView(R.layout.add_date);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        mDate = (DatePicker)dialog.findViewById(R.id.datePicker);
        mDescription = (EditText)dialog.findViewById(R.id.description);
        mSubmitButton = (Button)dialog.findViewById(R.id.button_submit);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the service and exit
                MyDate myDate = new MyDate();

                int day = mDate.getDayOfMonth();
                int month = mDate.getMonth() + 1;
                int year = mDate.getYear();

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, day);
                Date selectedDate = cal.getTime();

                myDate.date = selectedDate;
                myDate.description = mDescription.getText().toString();

                SaveAsyncTask tsk = new SaveAsyncTask();

                try {
                    tsk.execute(myDate);

                }
                catch (Exception ex)
                {

                }
                dismiss();
            }
        });

        return dialog;
    }

}
