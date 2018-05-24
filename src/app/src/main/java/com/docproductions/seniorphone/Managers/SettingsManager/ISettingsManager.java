package com.docproductions.seniorphone.Managers.SettingsManager;

public interface ISettingsManager {
    public <T> T getSetting(SettingKey key);
    public void putSetting(SettingKey key, Object value);
}
