package com.example.kolvir.personalassistant_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageButton menuButton, b1, b2, b3;
    boolean openMenuButton;
    Animation buttonAnimation;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButton = (ImageButton) findViewById(R.id.buttonMenu);
        b1 = (ImageButton) findViewById(R.id.button1);
        b2 = (ImageButton) findViewById(R.id.button2);
        b3 = (ImageButton) findViewById(R.id.button3);


        //buttonAnimation = AnimationUtils.loadAnimation(this,R.anim.);

        buttonAnimation = AnimationUtils.loadAnimation(this,R.anim.movebutton);


        openMenuButton = false;

        openMenuButton = false;
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Меняем текст в TextView (tvOut)
                Log.i("MYLOG", "PRESS");
            }
        };

        View.OnTouchListener otlBtnOk = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.i("MYLOG", "TouchDown");
                    menuButton.setImageResource(R.drawable.kek2);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.i("MYLOG", "TouchUp");

                    if (openMenuButton) {
                        menuButton.setImageResource(R.drawable.kek);
                        openMenuButton = false;
                        b1.clearAnimation();
                        b2.clearAnimation();
                        b3.clearAnimation();
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b1.setVisibility(View.INVISIBLE);
                        b2.setVisibility(View.INVISIBLE);
                        b3.setVisibility(View.INVISIBLE);
                    } else {
                        menuButton.setImageResource(R.drawable.kek3);
                        openMenuButton = true;
                        b1.setEnabled(true);
                        b2.setEnabled(true);
                        b3.setEnabled(true);
                        b1.setVisibility(View.VISIBLE);
                        b1.startAnimation(buttonAnimation);
                        b2.setVisibility(View.VISIBLE);
                        b2.startAnimation(buttonAnimation);
                        b3.setVisibility(View.VISIBLE);
                        b3.startAnimation(buttonAnimation);
                    }

                }
                return false;
            }
        };

        menuButton.setOnTouchListener(otlBtnOk);

    }

}

