package com.example.bruno.intentassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialActivity extends AppCompatActivity {

    Button dial1;
    Button dial2;
    Button dial3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        dial1 = findViewById(R.id.btn_caller1);
        dial2 = findViewById(R.id.btn_caller2);
        dial3 = findViewById(R.id.btn_caller3);
    }

    public void callPerson(View view) {

        String phoneNumber;
        switch(view.getId()){
            case R.id.btn_caller1:
                phoneNumber = "2125551212";
                break;
            case R.id.btn_caller2:
                phoneNumber = "5551231212";
                break;
            case R.id.btn_caller3:
                phoneNumber = "1110001234";
                break;
            default:
                phoneNumber = "2220001234";
                break;
        }


        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
