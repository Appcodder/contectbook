package com.example.contectbook;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Insertcontectactivity extends AppCompatActivity {

    EditText etname;
    EditText etnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertcontect);

        etname = findViewById(R.id.etname);

        etnumber = findViewById(R.id.etnumber);

        findViewById(R.id.btnsubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                String number = etnumber.getText().toString();

                DBHelper dbHelper = new DBHelper(Insertcontectactivity.this);
                dbHelper.insertmydata(name, number);
            }
        });
    }
}