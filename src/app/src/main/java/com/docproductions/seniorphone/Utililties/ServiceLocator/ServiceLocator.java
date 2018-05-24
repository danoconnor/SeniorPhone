package com.docproductions.seniorphone.Utililties.ServiceLocator;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    public static final ServiceLocator defaultLocator = new ServiceLocator();

    public void registerService(ServiceLocatorKey key, Object service) {
        services.put(key, service);
    }

    // The code is cleaner if we ignore this warning.
    // We do check later on if the cast is successful before returning.
    @SuppressWarnings({"unchecked"})
    public <T> T getService(ServiceLocatorKey key) {
        T retVal = null;
        if (services.containsKey(key)) {
            retVal = (T) services.get(key);
        }

        if (retVal == null) {
            throw new AssertionError("Could not get service with key " + key.name());
        }

        return  retVal;
    }

    private Map<ServiceLocatorKey, Object> services = new HashMap<>();
}
