package com.example.bruno.intentassignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnTakePic;
    Button btnAlarm;
    Button btnPlayAudio;
    ImageView imgPicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTakePic = findViewById(R.id.btn_takePicture);
        btnAlarm = findViewById(R.id.btn_setAlarm);
        btnPlayAudio = findViewById(R.id.btn_playAudio);
        imgPicture = findViewById(R.id.img_picture);
    }


    public void playAudio(View view) {

        try
        {
            Intent audioIntent = new Intent(android.content.Intent.ACTION_VIEW);
            /*
            getResources().openRawResource(R.raw.starwars);
            File file = new File("android.resource://" + getPackageName() + "/raw/starwars");

            Uri fileUri = FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), file);
            */
            //String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(file.toURI().toString());
            //String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);

            String link = "https://ia600304.us.archive.org/30/items/StarWarsTheImperialMarchDarthVadersTheme/Star%20Wars-%20The%20Imperial%20March%20%28Darth%20Vader%27s%20Theme%29.mp3";

            audioIntent.setDataAndType(Uri.parse(link), "audio/*");

            //Log.e("Audio", fileUri.toString());
            //Log.e("Audio", mimetype);
            startActivity(audioIntent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void openActivity(View view) {
        switch(view.getId()){
            case R.id.btn_openAlarmSetup:
                Intent alarmIntent = new Intent(this, AlarmActivity.class);
                startActivity(alarmIntent);
                break;
            case R.id.btn_openTakePic:
                Intent picIntent = new Intent(this, PictureActivity.class);
                startActivity(picIntent);
                break;
            case R.id.btn_showLocation:
                Intent mapIntent = new Intent(this, MapActivity.class);
                startActivity(mapIntent);
                break;
            case R.id.btn_dial:
                Intent dialIntent = new Intent(this, DialActivity.class);
                startActivity(dialIntent );
                break;
            case R.id.btn_text:
                Intent messageIntent = new Intent(this, TextActivity.class);
                startActivity(messageIntent);
                break;
        }
    }
}
