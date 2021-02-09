package com.inclass2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.security.acl.Group;

/*
Assignment: Inclass 2
File Name: Inclass 2a
Student Name: Anoosh Hari and Dayakar Ravuri 29A
 */

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    TextView result;
    Button meterButton;
    Button feetButton;
    Button milesButton;
    Button clearButton;
    String res;

    final String TAG = "In Class 02a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.inchValueId);
        result = findViewById(R.id.resultValueId);
        meterButton = findViewById(R.id.metersButton);
        feetButton = findViewById(R.id.feetButton);
        milesButton = findViewById(R.id.milesButton);
        clearButton = findViewById(R.id.clearButton);

        meterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BigDecimal bd = new BigDecimal((Float.parseFloat(String.valueOf(inputText.getText()))*0.0254));
                    res = bd.setScale(4, BigDecimal.ROUND_HALF_UP).toString();
                    result.setText(res+" Meters");
                    Log.d(TAG, "onClick: Calculated in Meters -> "+res);
                } catch (NullPointerException e) {
                    result.setText("");
                    callToast(getResources().getString(R.string.toast_message_npe));
                } catch (Exception e){
                    result.setText("");
                    callToast(getResources().getString(R.string.toast_message));
                }
            }
        });

        feetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    BigDecimal bd = new BigDecimal((Float.valueOf(String.valueOf(inputText.getText()))/12));
                    res = bd.setScale(4, BigDecimal.ROUND_HALF_UP).toString();
                    result.setText(res+" Foot");
                    Log.d(TAG, "onClick: Calculated Feet -> "+res);
                } catch (NullPointerException e) {
                    result.setText("");
                    callToast(getResources().getString(R.string.toast_message_npe));
                } catch (Exception e){
                    result.setText("");
                    callToast(getResources().getString(R.string.toast_message));
                }
            }
        });

        milesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BigDecimal bd = new BigDecimal((Float.valueOf(String.valueOf(inputText.getText()))/63360));
                    res = bd.setScale(4, BigDecimal.ROUND_HALF_UP).toString();
                    result.setText(res+" Miles");
                    Log.d(TAG, "onClick: Calculated Miles -> "+res);
                } catch (NullPointerException e) {
                    result.setText("");
                    callToast(getResources().getString(R.string.toast_message_npe));
                } catch (Exception e){
                    result.setText("");
                    callToast(getResources().getString(R.string.toast_message));
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                inputText.setText("");
                Log.d(TAG, "onClick: Cleared contents");
            }
        });
    }

    public void callToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Log.d(TAG, "onClick: "+msg);
    }

//    @Override
//    public void onClick(View v) {
//        try {
//            if(v.getId()==R.id.metersButton){
//                res = String.valueOf((Float.parseFloat(String.valueOf(inputText.getText()))*0.0254));
//                result.setText(res);
//                Log.d(TAG, "onClick: Calculated in Meters -> "+res);
//            } else if (v.getId()==R.id.feetButton){
//                res = String.valueOf((Float.valueOf(String.valueOf(inputText.getText()))/12));
//                result.setText(res);
//                Log.d(TAG, "onClick: Calculated Feet -> "+res);
//            }else if (v.getId()==R.id.milesButton){
//                res = String.valueOf((Float.valueOf(String.valueOf(inputText.getText()))/63360));
//                result.setText(res);
//                Log.d(TAG, "onClick: Calculated Miles -> "+res);
//            } else if (v.getId()==R.id.clearButton){
//                result.setText("");
//                inputText.setText("");
//                Log.d(TAG, "onClick: Cleared contents");
//            }
//        } catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
//            Log.d(TAG, "onClick: "+e.getMessage());
//        }
//    }
}