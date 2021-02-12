package com.bawp.planer_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import java.util.LinkedList;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.ListView;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    //variables
    ImageButton save,delete;
    EditText name;
    ArrayAdapter arrayAdapter;
    LinkedList<String>lst;
    private ListView Lview;


    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lst = new LinkedList<String>();
        //Display current date
        TextView textView = findViewById(R.id.displayDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);

        name = findViewById(R.id.taskInput);
        Lview = findViewById(R.id.listView);

        //add some task

        save=findViewById(R.id.addTask);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lst.add(name.getText().toString());
                arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, lst);
                Lview.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
                Lview.invalidateViews();
                Lview.refreshDrawableState();
            }
        });
        //Delete some task
        delete=findViewById(R.id.deleteTask);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lst.size()>0){
                    lst.remove(name.getText().toString());
                    arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, lst);
                    Lview.setAdapter(arrayAdapter);
                    arrayAdapter.notifyDataSetChanged();
                    Lview.invalidateViews();
                    Lview.refreshDrawableState();
                }else{
                    Toast.makeText(MainActivity.this, "Task list already empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        }


    }
