package com.dandelion.reminder.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dandelion.reminder.fragments.ExampleFragment;

import java.util.ArrayList;
import java.util.List;

public class TabsPageFragmentAdapter extends FragmentPagerAdapter {

    private List<String> tabs;

    public TabsPageFragmentAdapter(FragmentManager fm) {
        super(fm);
        tabs = new ArrayList<>();
        tabs.add("Tab 1");
        tabs.add("Tab 2");
        tabs.add("Tab 3");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ExampleFragment.getInstance();
            case 1:
                return ExampleFragment.getInstance();
            case 2:
                return ExampleFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
