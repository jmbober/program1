package com.example.jenny.program01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class EnterInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        NumberPicker yearPicker = (NumberPicker) findViewById(R.id.year);
        yearPicker.setMinValue(2017);
        yearPicker.setMaxValue(2020);
        yearPicker.setWrapSelectorWheel(true);


        Button btn = (Button) findViewById(R.id.btnToGenerateParagraph);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToNextPage();
            }
        });

    }

    public void goToNextPage(){
        EditText firstName = (EditText) findViewById(R.id.firstName);
        String fName = firstName.getText().toString();

        EditText lastName = (EditText) findViewById(R.id.lastName);
        String lName = lastName.getText().toString();

        RadioGroup degreeOpts = (RadioGroup) findViewById(R.id.degree);
        int degreePos = degreeOpts.getCheckedRadioButtonId();
        RadioButton selectedDegree = (RadioButton) findViewById(degreePos);
        String degree = selectedDegree.getText().toString();

        Spinner schoolSelection = (Spinner) findViewById(R.id.school);
        String school = schoolSelection.getSelectedItem().toString();

        EditText majorText = (EditText) findViewById(R.id.major);
        String major = majorText.getText().toString();

        NumberPicker yearText = (NumberPicker) findViewById(R.id.year);
        Integer y = yearText.getValue();
        String year = y.toString();

        Intent intent = new Intent(EnterInfo.this, GenerateParagraph.class);
        intent.setType("text/plain");
        intent.putExtra("firstName", fName);
        intent.putExtra("lastName", lName);
        intent.putExtra("degree", degree);
        intent.putExtra("school", school);
        intent.putExtra("major", major);
        intent.putExtra("year", year);

        startActivity(intent);
    }
}
