package com.example.lovedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovedemo.activity.BaseActivity;
import com.example.lovedemo.view.PraiseView;
import com.xiaweizi.marquee.MarqueeTextView;

public class Main2Activity extends BaseActivity {

    private PraiseView mPraiseView;
    private MarqueeTextView marquee1;

    private ProgressBar progesss;
    private TextView progesssValue;
    private LinearLayout full;

    private int p =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progesss = (ProgressBar) findViewById(R.id.progesss1);
        progesssValue = (TextView) findViewById(R.id.progesss_value1);
        full = (LinearLayout) findViewById(R.id.full);


        mPraiseView = (PraiseView) findViewById(R.id.bubble);
        marquee1 = findViewById(R.id.marquee1);

        init();


    }

    private void init() {

        mPraiseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPraiseView.addBubble(1);
                p=p+4;
                if (p<=100){
                    progesss.setProgress(p);
                    initview();
                }else {
                    startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                }

            }
        });

        marquee1.startScroll();

//        Toast.makeText(this, "点我点我点我!!! ", Toast.LENGTH_SHORT).show();

    }

    private void initview() {


        progesssValue.setText(new StringBuffer().append(progesss.getProgress()).append("%"));

        setPosWay1();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            setPos();
        }
    }

    private void setPosWay1() {
        progesssValue.post(new Runnable() {
            @Override
            public void run() {
                setPos();
            }
        });
    }


    /**
     * 设置进度显示在对应的位置
     */
    public void setPos() {
        int w = getWindowManager().getDefaultDisplay().getWidth();
        Log.e("w=====", "" + w);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) progesssValue.getLayoutParams();
        int pro = progesss.getProgress();
        int tW = progesssValue.getWidth();
        if (w * pro / 100 + tW * 0.3 > w) {
            params.leftMargin = (int) (w - tW * 1.1);
        } else if (w * pro / 100 < tW * 0.7) {
            params.leftMargin = 0;
        } else {
            params.leftMargin = (int) (w * pro / 100 - tW * 0.7);
        }
        progesssValue.setLayoutParams(params);

    }

    @Override
    protected void onResume() {
        super.onResume();

        p = 0;
        init();


    }
}
