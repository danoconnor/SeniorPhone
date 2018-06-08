package com.docproductions.seniorphone.Adapters;

import android.content.Context;

import com.docproductions.seniorphone.Managers.SettingsManager.SettingKey;
import com.docproductions.seniorphone.Models.AppInfo;
import com.docproductions.seniorphone.Models.HomeScreenApp;
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
}
