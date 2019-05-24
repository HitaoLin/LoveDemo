package com.example.lovedemo;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lovedemo.viewpager.ViewPager.MyTransformation;
import com.example.lovedemo.viewpager.util.ImageUtil;
import com.xiaweizi.marquee.MarqueeTextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private int pagerWidth;
    private List<ImageView> imageViewList;

    private MarqueeTextView marquee1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        marquee1 = findViewById(R.id.marquee1);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        marquee1.startScroll();

        final ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
        imageViewList=new ArrayList<>();
        ImageView first=new ImageView(Main3Activity.this);
        /**
         * 为imageview生成的带犹豫倒影的bitmap
         */
        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.you3,Main3Activity.this));
        ImageView second=new ImageView(Main3Activity.this);
        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.you2,Main3Activity.this));
        ImageView third=new ImageView(Main3Activity.this);
        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.you1,Main3Activity.this));
        ImageView fourth=new ImageView(Main3Activity.this);
        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.you4,Main3Activity.this));
        ImageView fifth=new ImageView(Main3Activity.this);
        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.you5,Main3Activity.this));
        imageViewList.add(first);
        imageViewList.add(second);
        imageViewList.add(third);
        imageViewList.add(fourth);
        imageViewList.add(fifth);
        viewPager.setOffscreenPageLimit(3);
        pagerWidth= (int) (getResources().getDisplayMetrics().widthPixels*3.0f/5.0f);
        ViewGroup.LayoutParams lp=viewPager.getLayoutParams();
        if (lp==null){
            lp=new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            lp.width=pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);
        findViewById(R.id.activity_main3).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });
        viewPager.setPageTransformer(true,new MyTransformation());
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageViewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView=imageViewList.get(position);
                container.addView(imageView,position);
                return imageView;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                startActivity(new Intent(this,Main4Activity.class));
                break;
        }
    }
}
