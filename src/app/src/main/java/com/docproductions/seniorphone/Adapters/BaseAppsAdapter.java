package com.docproductions.seniorphone.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.docproductions.seniorphone.Models.AppInfo;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAppsAdapter extends BaseAdapter {
    public BaseAppsAdapter(Context c) {
        _context = c;
        _apps = new ArrayList<>();

        PackageManager _packageManager = _context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        for (ResolveInfo info : _packageManager.queryIntentActivities(intent, 0)) {
            AppInfo appInfo = new AppInfo();
            appInfo.name = info.loadLabel(_packageManager).toString();
            appInfo.packageName = info.activityInfo.packageName;
            appInfo.icon = info.activityInfo.loadIcon(_packageManager);

            _apps.add(appInfo);
        }
    }

    public int getCount() {
        return _apps.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    protected List<AppInfo> _apps;
    protected Context _context;
}
