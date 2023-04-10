package com.example.delaytransitionlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    CardView cardView;
    LinearLayout linearMain;
    Animation animationCard;
    boolean visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find all Ids here
        linearMain=findViewById(R.id.linear_layout_main);
        imageView=findViewById(R.id.imageView_home);
        cardView=findViewById(R.id.card_main);

        animationCard= AnimationUtils.loadAnimation(this,R.anim.bubbleeffect);
        MyBounceInterpolator myBounceInterpolator1=new MyBounceInterpolator(0.2,20);
        animationCard.setInterpolator(myBounceInterpolator1);

        new Handler().postDelayed(() -> {
            visible = false;
            TransitionManager.beginDelayedTransition(linearMain);
            visible = !visible;
            imageView.setVisibility(visible ? View.VISIBLE : View.GONE);
            cardView.setVisibility(visible ? View.VISIBLE : View.GONE);
            cardView.startAnimation(animationCard);
        },3500);
    }
}