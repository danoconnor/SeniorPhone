package com.docproductions.seniorphone.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.docproductions.seniorphone.Managers.SettingsManager.SettingKey;
import com.docproductions.seniorphone.Models.AppInfo;
import com.docproductions.seniorphone.Models.HomeScreenApp;
import com.docproductions.seniorphone.R;
import com.docproductions.seniorphone.Utililties.ServiceLocator.ServiceLocatorFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeScreenAppsAdapter extends BaseAppsAdapter {
    public HomeScreenAppsAdapter(Context c) {
        super(c);

        // Filter the apps list to only the ones that should be displayed on the home screen
        List<HomeScreenApp> savedHomeScreenApps = ServiceLocatorFactory.SettingsManager().getSetting(SettingKey.HOME_SCREEN_APPS);

        int i = 0;
        while (i < _apps.size()) {
            boolean isHomeScreenApp = false;
            for (HomeScreenApp homeScreenApp : savedHomeScreenApps) {
                if (homeScreenApp.packageName.equals(_apps.get(i).packageName)) {
                    isHomeScreenApp = true;
                    break;
                }
            }

            if (!isHomeScreenApp) {
                _apps.remove(i);
            }
            else {
                i++;
            }
        }
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View tile;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            tile = LayoutInflater.from(_context).inflate(R.layout.home_screen_apps_tile, null);
        } else {
            tile = convertView;
        }

        tile.setBackgroundColor(Color.BLUE);

        TextView tileText = tile.findViewById(R.id.appLabel);
        tileText.setText(_apps.get(position).name);

        return tile;
    }
}
