package com.docproductions.seniorphone.Utililties;

import android.os.Handler;
import android.os.Looper;

public class Utilities {
    public static void runOnMainThread(Runnable codeToRun) {
        final Handler mainThread = new Handler(Looper.getMainLooper());
        mainThread.post(codeToRun);
    }
}
