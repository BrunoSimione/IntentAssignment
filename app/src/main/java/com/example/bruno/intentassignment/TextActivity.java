package com.example.bruno.intentassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextActivity extends AppCompatActivity {

    EditText et_recipient;
    EditText et_content;
    Button btn_sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        et_recipient = findViewById(R.id.et_message_recipient);
        et_content = findViewById(R.id.et_message_content);
        btn_sendMessage = findViewById(R.id.btn_sendMessage);

    }

    public void sendMessage(View view) {

        String recipient = et_recipient.getText().toString();
        String content = et_content.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"+recipient));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", content);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
