package com.example.lovedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lovedemo.activity.BaseActivity;
import com.example.lovedemo.view.PraiseView;
import com.xiaweizi.marquee.MarqueeTextView;

public class Main2Activity extends BaseActivity {

    private PraiseView mPraiseView;
    private MarqueeTextView marquee1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mPraiseView = (PraiseView) findViewById(R.id.bubble);
        marquee1 = findViewById(R.id.marquee1);
        mPraiseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPraiseView.addBubble(1);
            }
        });

        marquee1.startScroll();

        Toast.makeText(this, "点我点我点我!!! ", Toast.LENGTH_SHORT).show();

    }


}
