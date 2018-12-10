package com.cityscholar.cs465.simplefood;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.List;
import java.util.Map;

public class MyFragmentStateAdapter extends FragmentStatePagerAdapter {
    private int count;
    private final SparseArray<Object> cached;

    public MyFragmentStateAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = ExampleRestaurants.reserve(count);
        cached = new SparseArray<>(this.count);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (cached.indexOfValue(object) >= 0) {
            return super.getItemPosition(object);
        }
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int i) {
        RestaurantsFragment fragment = (RestaurantsFragment) cached.get(i);
        if (fragment == null) {
            fragment = RestaurantsFragment.newInstance(ExampleRestaurants.take());
            cached.put(i, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count != this.count) {
            if (count < cached.size()) {
                this.count = count;
            } else {
                this.count = ExampleRestaurants.reserve(count - cached.size()) + cached.size();
            }
            notifyDataSetChanged();
        }
    }

    public void getNewBatch() {
        for (int i = 0; i < cached.size(); ) {
            final RestaurantsFragment o = (RestaurantsFragment) cached.valueAt(i);
            if (o.isSeen()) {
                cached.removeAt(i);
            } else {
                i++;
            }
        }
        if (count > cached.size()) {
            count = ExampleRestaurants.reserve(count - cached.size()) + cached.size();
        }
        notifyDataSetChanged();
    }

    public void changeFilter(int[] order, SparseIntArray map) {
        ExampleRestaurants.sort(order, map);
        cached.clear();
        notifyDataSetChanged();
    }

    public void remove(Fragment fragment) {
        cached.removeAt(cached.indexOfValue(fragment));
        count -= 1;
        notifyDataSetChanged();
    }
}
