package com.example.bruno.intentassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MapActivity extends AppCompatActivity {

    Spinner ddlLocations;
    Button btnShowLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ddlLocations = findViewById(R.id.ddl_locations);
        btnShowLocation = findViewById(R.id.btn_location);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.location_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        ddlLocations.setAdapter(adapter);

    }

    public void openMapLocation(View view) {

        String selectedLocation = String.valueOf(ddlLocations.getSelectedItem());
        String uri;
        switch(selectedLocation){
            case "Toronto":
                uri = "geo:43.6567919,-79.4609319";
                break;
            case "New York":
                uri = "geo:40.6974034,-74.1197632";
                break;
            case "Miami":
                uri = "geo:25.7823907,-80.2994982";
                break;
            case "London":
                uri = "geo:51.5285582,-0.2416796";
                break;
            default:
                uri = "geo:43.6567919,-79.4609319";
                break;
        }
        Uri gmmIntentUri = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
