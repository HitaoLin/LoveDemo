package com.example.lovedemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.lovedemo.activity.BaseActivity;
import com.example.lovedemo.view.BombView;

import static com.example.lovedemo.activity.BaseActivity.getUIHandler;

/**
 * 测试烟花效果
 */
public class MainActivity extends BaseActivity {

    private BombView mBombView;

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            mBombView.startBomb();
            getUIHandler().postDelayed(task, 2000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBombView = (BombView) findViewById(R.id.bombview);

        getUIHandler().postDelayed(task, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
//                Intent mainIntent = new Intent(SplashActivity.this,NewloginActivity.class);
                Intent mainIntent = new Intent(MainActivity.this,Main2Activity.class);

                MainActivity.this.startActivity(mainIntent);

                MainActivity.this.finish();

            }
        },8000);

        //防止抖动
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBombView.release();
    }

}
