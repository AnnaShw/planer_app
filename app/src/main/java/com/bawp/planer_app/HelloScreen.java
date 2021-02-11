package com.bawp.planer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class HelloScreen extends AppCompatActivity {
    private static int Splash_Screen=5000;
    //Variavles
    Animation topAnim,bottomAnim;
    ImageView planerImg;
    TextView hellotext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.hello_screen);

        //Animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        planerImg=findViewById(R.id.imageView);
        hellotext=findViewById(R.id.helloScreenText);

        planerImg.setAnimation(topAnim);
        hellotext.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(HelloScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },Splash_Screen);
    }
}