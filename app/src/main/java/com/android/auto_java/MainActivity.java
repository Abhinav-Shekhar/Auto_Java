package com.android.auto_java;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonOne, buttonTwo, buttonThree, buttonFour;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //statubar color code
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#000000"));
        //end of statusbar color code

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navigate to Connection page page
        buttonOne = (Button) findViewById(R.id.firstbutton);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Connections.class);
                startActivity(intent);
            }
        });

        //navigate to Diagnose page
        buttonTwo = (Button) findViewById(R.id.secondbutton);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Diagnostics.class);
                startActivity(intent);
            }
        });

        //navigate to Measures page
        buttonThree = (Button) findViewById(R.id.thirdbutton);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Measures.class);
                startActivity(intent);
            }
        });

        //navigate to Settings page
        buttonFour = (Button) findViewById(R.id.fourthbutton);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });


    }
}