package com.dandelion.reminder.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dandelion.reminder.fragments.BaseTabFragment;
import com.dandelion.reminder.fragments.BirthdaysFragment;
import com.dandelion.reminder.fragments.HistoryFragment;
import com.dandelion.reminder.fragments.IdeasFragment;
import com.dandelion.reminder.fragments.TodoFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, BaseTabFragment> tabs;

    public TabsFragmentAdapter(FragmentManager fm) {
        super(fm);
        initTabsMap();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap() {
        tabs = new HashMap<>();
        tabs.put(0, HistoryFragment.newInstance());
        tabs.put(1, IdeasFragment.newInstance());
        tabs.put(2, TodoFragment.newInstance());
        tabs.put(3, BirthdaysFragment.newInstance());
    }
}
