package com.docproductions.seniorphone.Models;

import android.graphics.Color;

import java.io.Serializable;

public class HomeScreenApp implements Serializable {
    public String packageName;
    public Color backgroundColor;

    public HomeScreenApp(String packageName, Color backgroundColor) {
        this.packageName = packageName;
        this.backgroundColor = backgroundColor;
    }
}
