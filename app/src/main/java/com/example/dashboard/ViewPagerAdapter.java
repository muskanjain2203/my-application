package com.example.dashboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private int totalTabs = 5;

    public ViewPagerAdapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        context = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                Tab1Fragment nTab0 = new Tab1Fragment();
                return nTab0;

            case 1:
                Tab1Fragment cTab1 = new Tab1Fragment();
                return cTab1;

            case 2:
                Tab1Fragment fTab2 = new Tab1Fragment();
                return fTab2;

            case 3:
                Tab1Fragment pTab3 = new Tab1Fragment();
                return pTab3;

            case 4:
                Tab1Fragment xTab3 = new Tab1Fragment();
                return xTab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}