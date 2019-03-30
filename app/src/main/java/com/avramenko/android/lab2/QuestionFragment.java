package com.avramenko.android.lab2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionFragment extends Fragment {
    EditText editText;
    RadioGroup radGrp;
    Button okButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        editText = (EditText) view.findViewById(R.id.editText);
        radGrp = (RadioGroup) view.findViewById(R.id.radios);
        okButton = (Button) view.findViewById(R.id.okButton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radGrp.getCheckedRadioButtonId();

                if (editText.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(view.getContext(), "Enter question first.", Toast.LENGTH_LONG);
                    toast.show();
                } else if (radGrp.getCheckedRadioButtonId() == -1) {
                    Toast toast = Toast.makeText(view.getContext(), "Select answer.", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    if (selectedId != 1) {
                        View radioButton = radGrp.findViewById(selectedId);
                        int radioId = radGrp.indexOfChild(radioButton);
                        RadioButton btn = (RadioButton) radGrp.getChildAt(radioId);
                        String str = editText.getText().toString() + " " + btn.getText().toString();
                        Toast toast = Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG);
                        toast.show();
                    }

                }
            }
        });
        return view;
    }
}
