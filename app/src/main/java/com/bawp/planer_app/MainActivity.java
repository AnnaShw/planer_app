package com.bawp.planer_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

public class MainActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=findViewById(R.id.displayDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);

        //Here we open fragment by clicking on Add task button
        Button addTask=(Button)findViewById(R.id.addTaskButton);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTaskFragment AddTaskfragment=new AddTaskFragment();
                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction().add(R.id.main,AddTaskfragment).commit();

            }
        });
        Bundle bundle=getIntent().getExtras();
        if( bundle!=null){
            if(bundle.getString("task")!=null){
                Toast.makeText(getApplicationContext(),"Let's add your"+bundle.getString("task"),Toast.LENGTH_SHORT).show();
            }
        }
    }
}