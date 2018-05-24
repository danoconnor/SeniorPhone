package com.docproductions.seniorphone.Managers.SettingsManager;

import java.util.HashMap;
import java.util.Map;

public class SettingsManager implements ISettingsManager {
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

    private Map<SettingKey, Object> _settings = new HashMap<>();
}
