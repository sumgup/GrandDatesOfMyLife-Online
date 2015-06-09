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
import android.widget.EditText;


public class AddDateDialog extends DialogFragment {

    Button mSubmitButton;
    EditText mDate;
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

        mDate = (EditText)dialog.findViewById(R.id.date);
        mDescription = (EditText)dialog.findViewById(R.id.description);
        mSubmitButton = (Button)dialog.findViewById(R.id.button_submit);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the service and exit


                dismiss();
            }
        });

        return dialog;
    }
}
