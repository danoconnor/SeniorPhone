package com.docproductions.seniorphone;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.docproductions.seniorphone.Adapters.HomeScreenAppsAdapter;
import com.docproductions.seniorphone.Utililties.ServiceLocator.ServiceLocatorConfiguration;
import com.docproductions.seniorphone.Utililties.Utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class HomeScreenActivity extends AppCompatActivity {

    private Timer timeTextTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Register our services so we can access them through the ServiceLocatorFactory
        ServiceLocatorConfiguration.initializeDefaultConfiguration();

        GridView mainAppsView = findViewById(R.id.mainAppsView);
        mainAppsView.setAdapter(new HomeScreenAppsAdapter(this));
        mainAppsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(HomeScreenActivity.this, "Hello world: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        // Update the clock text every second
        final TextView timeText = findViewById(R.id.timeText);
        timeTextTimer = new Timer();
        final java.text.DateFormat dateFormat = DateFormat.getTimeFormat(getApplicationContext());

        timeTextTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Utilities.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        timeText.setText(dateFormat.format(Calendar.getInstance().getTime()));
                    }
                });
            }
        }, 0, 1000);
    }
}
