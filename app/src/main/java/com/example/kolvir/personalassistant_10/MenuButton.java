package com.example.kolvir.personalassistant_10;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuButton {

    ImageButton menuButton, btnTop, btnMid, btnBot;
    boolean openMenuButton;
    Animation buttonAnimationTop,buttonAnimationMid,buttonAnimationBot;

    public MenuButton(Context context,ImageButton main,ImageButton top,ImageButton mid,ImageButton bot){

        menuButton = main;
        btnTop = top;
        btnMid = mid;
        btnBot = bot;

        //buttonAnimation = AnimationUtils.loadAnimation(this,R.anim.);

        buttonAnimationTop= AnimationUtils.loadAnimation(context,R.anim.move_top_button);
        buttonAnimationMid = AnimationUtils.loadAnimation(context,R.anim.move_mid_button);
        buttonAnimationBot = AnimationUtils.loadAnimation(context,R.anim.move_bottom_button);


        openMenuButton = false;

        openMenuButton = false;
        btnTop.setEnabled(false);
        btnMid.setEnabled(false);
        btnBot.setEnabled(false);
        btnTop.setVisibility(View.INVISIBLE);
        btnMid.setVisibility(View.INVISIBLE);
        btnBot.setVisibility(View.INVISIBLE);
    }

    public void Up(){
        menuButton.setImageResource(R.drawable.mainbtnon);
    }

    public void Tap(){
        if (openMenuButton) {
            menuButton.setImageResource(R.drawable.mainbtnoff);
            openMenuButton = false;
            btnTop.clearAnimation();
            btnMid.clearAnimation();
            btnBot.clearAnimation();
            btnTop.setEnabled(false);
            btnMid.setEnabled(false);
            btnBot.setEnabled(false);
            btnTop.setVisibility(View.INVISIBLE);
            btnMid.setVisibility(View.INVISIBLE);
            btnBot.setVisibility(View.INVISIBLE);
        } else {
            menuButton.setImageResource(R.drawable.mainbtnopen);
            openMenuButton = true;
            btnTop.setEnabled(true);
            btnMid.setEnabled(true);
            btnBot.setEnabled(true);
            btnTop.setVisibility(View.VISIBLE);
            btnTop.startAnimation(buttonAnimationTop);
            btnMid.setVisibility(View.VISIBLE);
            btnMid.startAnimation(buttonAnimationMid);
            btnBot.setVisibility(View.VISIBLE);
            btnBot.startAnimation(buttonAnimationBot);
        }
    }



}
