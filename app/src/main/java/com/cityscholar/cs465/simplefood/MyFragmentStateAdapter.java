package com.cityscholar.cs465.simplefood;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyFragmentStateAdapter extends FragmentStatePagerAdapter {
    private int count;

    public MyFragmentStateAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count != 0 ? count : ExampleRestaurants.RESTAURANTS.size();
    }


    @Override
    public Fragment getItem(int i) {
        return RestaurantsFragment.newInstance(ExampleRestaurants.RESTAURANTS.get(i));
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count != this.count) {
            this.count = count;
            notifyDataSetChanged();
        }
    }
}
