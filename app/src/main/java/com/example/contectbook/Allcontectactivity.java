package com.example.contectbook;

import android.animation.IntArrayEvaluator;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Allcontectactivity extends AppCompatActivity {

    FloatingActionButton btncreatenumber;
    RecyclerView recyclerView;
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> numberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contect);

        btncreatenumber = findViewById(R.id.btncreatenumber);
        recyclerView = findViewById(R.id.recycleview);

        getAllcontect();

        btncreatenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Allcontectactivity.this, Insertcontectactivity.class);
                startActivity(intent);
            }
        });
    }
    void getAllcontect(){
        DBHelper dbHelper = new DBHelper(Allcontectactivity.this);

        Cursor cursor = dbHelper.Getmydata();
        while(cursor.moveToNext()){
            int userid = cursor.getInt(0);
            String name = cursor.getString(1);
            String number = cursor.getString(2);

            idList.add(userid);
            nameList.add(name);
            numberList.add(number);
        }

        Log.e("MyDataBase",""+idList+"\n"+nameList+"\n"+numberList);

    }
}