package com.cityscholar.cs465.simplefood;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MyFragmentStateAdapter extends FragmentStatePagerAdapter {
    private int count;
    Set<Object> cached = new HashSet<>();

    public MyFragmentStateAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count != 0 ? count : ExampleRestaurants.RESTAURANTS.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (cached.contains(object)) {
            return super.getItemPosition(object);
        }
        cached.add(object);
        return POSITION_NONE;
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

    public void shuffle() {
        Collections.shuffle(ExampleRestaurants.RESTAURANTS);
        cached.clear();
        notifyDataSetChanged();
    }
}
