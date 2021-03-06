package com.cosc426.unitconversions;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Expand the menu; adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks
        int id = item.getItemId();

        if (id == R.id.mileKilometer) {
            Intent mileKilometerActivity = new Intent(getApplicationContext(), MileKilometerActivity.class);
            startActivity(mileKilometerActivity);
            return true;
        } else if (id == R.id.feetMeter) {
            Intent feetMeterActivity = new Intent(getApplicationContext(), FeetMeterActivity.class);
            startActivity(feetMeterActivity);
            return true;
        } else if (id == R.id.inchCentimeter) {
            Intent inchCentimeterActivity = new Intent(getApplicationContext(), InchCentimeter.class);
            startActivity(inchCentimeterActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
