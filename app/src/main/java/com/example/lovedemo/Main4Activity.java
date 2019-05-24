package com.example.lovedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lovedemo.view.FadeInTextView;

public class Main4Activity extends AppCompatActivity {

    private FadeInTextView fad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        fad = (FadeInTextView) findViewById(R.id.fad);


        fad.setTextString("你知道吗？\n在第一次和你接触的时候，觉得你是蛮活泼的，但过段时间慢慢地觉得好像喜欢上你了，也发现你有时会出现不好的情绪，你觉得世界有点糟糕，" +
                "我很想让你知道世界并没那么糟糕，更多的是美好！\n但。。。后来由于意识到自动的“危机感”，我只能让自己不再专注于这件事情，跟你说心情不好随时可以找我。。。\n直到工作的时候，我" +
                "已经可以承担自己的生活，我那想法便渐渐的又强烈了起来，所以。。。我便联系了你！！！\n上次你说你愿意为了我看到这个世界的美好！我真的特感动。。。" +
                "那时我的第一感觉就是想和你共度余生！！\n你说你想要一次表白，我说我想当面说，可能让你失望了，因为这是今天突发奇想，所以才在这里和你表白。。。\n我不想成为你的路人，想参与你的余生！！！你愿意成为我女朋友吗？")
                .startFadeInAnimation()
                .setTextAnimationListener(new FadeInTextView.TextAnimationListener() {
                    @Override
                    public void animationFinish() {

                    }
                });



    }
}
























