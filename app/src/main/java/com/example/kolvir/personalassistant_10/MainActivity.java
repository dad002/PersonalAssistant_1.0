package com.example.kolvir.personalassistant_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    MenuButton menuButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       menuButton = new MenuButton(this,(ImageButton)findViewById(R.id.buttonMenu),(ImageButton)findViewById(R.id.buttonTop),(ImageButton)findViewById(R.id.buttonMid),(ImageButton)findViewById(R.id.buttonBot));

        View.OnTouchListener otlBtnOk = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    menuButton.Up();
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                   menuButton.Tap();
                }
                return false;
            }
        };

        menuButton.menuButton.setOnTouchListener(otlBtnOk);

    }

}

