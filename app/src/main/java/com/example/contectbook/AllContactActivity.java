package com.example.contectbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AllContactActivity extends AppCompatActivity {

    FloatingActionButton btnctreatenumber;
    RecyclerView recyclerView;

    ArrayList<Integer> idlist = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> numberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contact);

        btnctreatenumber = findViewById(R.id.btnctreatenumber);
        recyclerView = findViewById(R.id.recycleview);

        getAllcontact();

        btnctreatenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AllContactActivity.this, Insertcontectactivity.class);
                startActivity(intent);
            }
        });
    }

    void getAllcontact(){

        DBHelper dbHelper = new DBHelper(AllContactActivity.this);

        Cursor cursor = dbHelper.Getmydata();

        while(cursor.moveToNext()){
            int userid = cursor.getInt(0);
            String name = cursor.getString(1);
            String number = cursor.getString(2);

            idlist.add(userid);
            nameList.add(name);
            numberList.add(number);
        }

        Contactadapter contactadapter = new Contactadapter(AllContactActivity.this,nameList,numberList,idlist);
        recyclerView.setAdapter(contactadapter);
    }
}