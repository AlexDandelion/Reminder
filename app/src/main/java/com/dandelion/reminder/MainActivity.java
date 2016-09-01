package com.dandelion.reminder;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dandelion.reminder.adapters.TabsPageFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initialToolbar();
        initNavigationView();
        initTabs();
    }

    private void initialToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.view_navigation_open, R.string.view_navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.actionNotificationItem:
                        showNotificationTab();
                        break;
                }
                return true;
            }
        });
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsPageFragmentAdapter adapter = new TabsPageFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void showNotificationTab() {
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }
}
