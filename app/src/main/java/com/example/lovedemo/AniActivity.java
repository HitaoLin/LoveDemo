package com.example.lovedemo;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class AniActivity extends AppCompatActivity {

    private ImageView image;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);

        image = findViewById(R.id.image);

        //取得图背景的
        animationDrawable = (AnimationDrawable) image.getBackground();

         animationDrawable.start();

    }
}
