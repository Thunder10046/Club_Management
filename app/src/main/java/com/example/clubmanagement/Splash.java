package com.example.clubmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    ImageView image_splash;
    TextView dream;

    Animation img, txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image_splash = findViewById(R.id.image_splash);
        dream = findViewById(R.id.dream);

        img = AnimationUtils.loadAnimation(this, R.anim.imageanim);
        txt = AnimationUtils.loadAnimation(this, R.anim.textanim);

        image_splash.setAnimation(img);
        dream.setAnimation(txt);


        final Handler myhandle = new Handler();
        myhandle.postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(Splash.this, MainActivity2.class));
            finish();
            }
        },2500);
    }
}