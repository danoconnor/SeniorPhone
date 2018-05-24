package com.docproductions.seniorphone.Utililties.ServiceLocator;

import com.docproductions.seniorphone.Managers.SettingsManager.SettingsManager;

public class ServiceLocatorConfiguration {
    public static void initializeDefaultConfiguration() {
        ServiceLocator.defaultLocator.registerService(ServiceLocatorKey.SETTINGS_MANAGER, new SettingsManager());
    }
}
