package com.docproductions.seniorphone.Adapters;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainAppAdapter extends BaseAdapter {
    public MainAppAdapter(Context c) {
        _context = c;

        _packageManager = _context.getPackageManager();
        _allApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
    }

    public int getCount() {
        return 12;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Button buttonTile;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            buttonTile = new Button(_context);
            buttonTile.setLayoutParams(new ViewGroup.LayoutParams(800, 800));
            buttonTile.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Button b = (Button)view;
                    Toast.makeText(_context, "Button clicked: " + b.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            buttonTile = (Button) convertView;
        }

        buttonTile.setText(mainApps[position].name);
        return buttonTile;
    }

    private List<ApplicationInfo> _homeScreenApps;
    private List<ApplicationInfo> _allApps;
    private PackageManager _packageManager;

    private Context _context;
}
