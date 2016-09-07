package com.dandelion.reminder.fragments;

public abstract class BaseTabFragment extends android.support.v4.app.Fragment {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
