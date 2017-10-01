package com.example.jenny.program01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GenerateParagraph extends Activity {
    public static final String EXTRA_TEXT = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_paragraph);

        Intent intent = getIntent();
        String fName = intent.getStringExtra("firstName");
        String lName = intent.getStringExtra("lastName");
        String degree = intent.getStringExtra("degree");

        String school = intent.getStringExtra("school");
        String major = intent.getStringExtra("major");
        String year = intent.getStringExtra("year").toString();

        TextView paragraph = (TextView)findViewById(R.id.infoParagraph);
        paragraph.setText(fName + " " + lName + " is pursuing a " + degree + " degree in " + major
                            + " at " + school + ", and plans to graduate in " + year + ". ");
    }
}
