package com.docproductions.seniorphone.Utililties.ServiceLocator;

import com.docproductions.seniorphone.Managers.SettingsManager.ISettingsManager;

public class ServiceLocatorFactory {
    public static ISettingsManager SettingsManager() { return ServiceLocator.defaultLocator.getService(ServiceLocatorKey.SETTINGS_MANAGER); }
}
