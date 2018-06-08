package com.docproductions.seniorphone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.docproductions.seniorphone.Adapters.BaseAppsAdapter;
import com.docproductions.seniorphone.Adapters.HomeScreenAppsAdapter;
import com.docproductions.seniorphone.Utililties.ServiceLocator.ServiceLocatorConfiguration;

public class HomeScreenActivity extends AppCompatActivity {

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
    }
}
