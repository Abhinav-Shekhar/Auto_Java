package com.android.auto_java;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Diagnostics extends AppCompatActivity {

    private EditText firstInput;
    private TextView finalOutput;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //turn off dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostics);

        //statubar color code
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#000000"));
        //end of statusbar color code

    }


    //code for diagnosing the result

    public void Diagnose(View v){

        TextView finalResult = findViewById(R.id.finalResult);
        EditText rpmValue = findViewById(R.id.rpmValue);
        EditText ectValue = findViewById(R.id.ectValue);
        EditText airTempValue = findViewById(R.id.airTempValue);
        EditText calculatedLoadValue = findViewById(R.id.calculatedLoadValue);
        EditText throttlePositionValue = findViewById(R.id.throttlePositionValue);
        EditText oxygenDetailsValue = findViewById(R.id.oxygenDetailsValue);

        String rpmString  = rpmValue.getText().toString();
        int finalRPM = Integer.parseInt(rpmString);

        String ectString  = ectValue.getText().toString();
        int finalECT = Integer.parseInt(ectString);

        String airTempString  = airTempValue.getText().toString();
        int finalairTemp = Integer.parseInt(airTempString);

        String calculatedLoadString  = calculatedLoadValue.getText().toString();
        int finalCalculatedString = Integer.parseInt(calculatedLoadString);

        String throttlePositionString  = throttlePositionValue.getText().toString();
        int finalThrottlePosition = Integer.parseInt(throttlePositionString);

        String oxygenDetailsString  = oxygenDetailsValue.getText().toString();
        int finalOxygenDetails = Integer.parseInt(oxygenDetailsString);




        //Diagnose Condition
        if((finalRPM >= 750 && finalRPM <= 900) && (finalCalculatedString >= 20 && finalCalculatedString <= 40) && (finalECT <= 49) && (finalairTemp <= 23) && (finalThrottlePosition <= 7) && (finalOxygenDetails <= 9 && finalOxygenDetails >= 4) ){
            finalResult.setText("No Issues Found");
        }
        else{
            finalResult.setText("Faulty Vehicle");
        }

        //Displaying the final Output
        TextView rpmResult = findViewById(R.id.rpmResultValue);
        TextView ectResult = findViewById(R.id.ectvalueResult);
        TextView airtempResult = findViewById(R.id.airtempreusltValue);
        TextView calculatedLoadResult = findViewById(R.id.calculatedLoadResult);
        TextView throttlePositionResult = findViewById(R.id.throttlePositionResult);
        TextView oxygenValueResult = findViewById(R.id.oxygenValueResult);


        if(finalRPM >= 750 && finalRPM <= 900){
            rpmResult.setText("Normal");
        }
        else if(finalRPM < 750){
            rpmResult.setText("Issues Found, Value is low");
        }
        else{
            rpmResult.setText("Issues Found, Value os high");
        }

        if(finalECT <= 49){
            ectResult.setText("Normal");
        }
        else{
            ectResult.setText("Issues Found, Value is high");
        }

        if(finalairTemp <= 23){
            airtempResult.setText("Normal");
        }
        else{
            airtempResult.setText("Issues Found, Value is high");
        }

        if(finalCalculatedString >= 20 && finalCalculatedString <= 40){
            calculatedLoadResult.setText("Normal");
        }
        else if(finalCalculatedString < 20){
            calculatedLoadResult.setText("Issues Found, Value is low");
        }
        else{
            calculatedLoadResult.setText("Issues Found, Value is high");
        }

        if(finalThrottlePosition <= 7){
            throttlePositionResult.setText("Normal");
        }
        else{
            throttlePositionResult.setText("Issues Found, Value is high");
        }

        if(finalOxygenDetails <= 9 && finalOxygenDetails >= 4){
            oxygenValueResult.setText("Normal");
        }
        else{
            oxygenValueResult.setText("Issues Found, Value is low");
        }

    }


}