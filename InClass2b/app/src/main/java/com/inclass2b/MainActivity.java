package com.inclass2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

/*
Assignment: Inclass 2
File Name: Inclass 2b
Student Name: Anoosh Hari and Dayakar Ravuri 29A
 */

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText inputText;
    TextView result;
    String res;
    Button convert;

    final String TAG = "In Class 02b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        inputText = findViewById(R.id.inchValueId);
        result = findViewById(R.id.resultValueId);
        convert = findViewById(R.id.convertButton);

//        DecimalFormat df = new DecimalFormat("00.00000");

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int checkedId = radioGroup.getCheckedRadioButtonId();
                    if (checkedId == R.id.radioMeters) {
                        BigDecimal bd = new BigDecimal(Float.parseFloat(String.valueOf(inputText.getText())) * 0.0254);
                        res = bd.setScale(4, BigDecimal.ROUND_HALF_UP).toString();
                        result.setText(res+" Meters");
                        Log.d(TAG, "onClick: Calculated in Meters -> " + res);
                    } else if (checkedId == R.id.radioFeet) {
                        BigDecimal bd = new BigDecimal((Float.valueOf(String.valueOf(inputText.getText())) / 12));
                        res = bd.setScale(4, BigDecimal.ROUND_HALF_UP).toString();
                        result.setText(res+" Foot");
                        Log.d(TAG, "onClick: Calculated Feet -> " + res);
                    } else if (checkedId == R.id.radioMiles) {
                        BigDecimal bd = new BigDecimal((Float.valueOf(String.valueOf(inputText.getText())) / 63360));
                        res = bd.setScale(4, BigDecimal.ROUND_HALF_UP).toString();
                        result.setText(res+" Miles");
                        Log.d(TAG, "onClick: Calculated Miles -> " + res);
                    } else if (checkedId == R.id.radioClearAll) {
                        result.setText("");
                        inputText.setText("");
                        Log.d(TAG, "onClick: Cleared contents");
                    }
                } catch (Exception e){
                    result.setText("");
                    callToast(getResources().getString(R.string.toast_message));
                }
            }
        });
    }

    public void callToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Log.d(TAG, "onClick: "+msg);
    }
}