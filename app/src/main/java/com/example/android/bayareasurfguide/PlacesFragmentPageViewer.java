package com.example.android.bayareasurfguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

public class PlacesFragmentPageViewer extends FragmentPagerAdapter {
    private Context _context;

    public PlacesFragmentPageViewer(FragmentManager fm, Context context) {
        super(fm);
        _context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SurfSpotsFragment();
        } else if(position == 1) {
            return new FoodAndDrinkFragment();
        } else if(position == 2) {
            return new HotelsFragment();
        } else {
            return new EventsFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return _context.getString(R.string.tab_title_1);
        } else if(position == 1) {
            return _context.getString(R.string.tab_title_2);
        } else if(position == 2) {
            return _context.getString(R.string.tab_title_3);
        } else {
            return _context.getString(R.string.tab_title_4);
        }
    }
}
