package com.docproductions.seniorphone.Managers.SettingsManager;

import com.docproductions.seniorphone.Models.HomeScreenApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingsManager implements ISettingsManager {
    public SettingsManager() {
        // Load everything into memory on initialization
        readSettingsFromDisk();
    }

    @Override
    public <T> T getSetting(SettingKey key) {
        T retVal = (T) _settings.get(key);

        if (retVal == null) {
            throw new AssertionError("Could not get setting with key: " + key.name());
        }

        return retVal;
    }

    @Override
    public void putSetting(SettingKey key, Object value) {
        _settings.put(key, value);
        writeSettingsToDisk();
    }

    private void writeSettingsToDisk() {
        // TODO
    }

    private void readSettingsFromDisk() {
        // TODO

        // Temp data until the setup flow and read/write from disk is working
        List<HomeScreenApp> fakeHomeScreenAppList = new ArrayList<>();
        fakeHomeScreenAppList.add(new HomeScreenApp("com.google.android.youtube", null));
        fakeHomeScreenAppList.add(new HomeScreenApp("com.google.android.videos", null));
        fakeHomeScreenAppList.add(new HomeScreenApp("com.google.android.play.games", null));
        fakeHomeScreenAppList.add(new HomeScreenApp("com.google.android.music", null));
        fakeHomeScreenAppList.add(new HomeScreenApp("com.google.android.talk", null));
        fakeHomeScreenAppList.add(new HomeScreenApp("com.google.android.apps.maps", null));
        _settings.put(SettingKey.HOME_SCREEN_APPS, fakeHomeScreenAppList);

        // Fake data
        _settings.put(SettingKey.HAS_COMPLETED_SETUP, false);
    }

    private Map<SettingKey, Object> _settings = new HashMap<>();
}
