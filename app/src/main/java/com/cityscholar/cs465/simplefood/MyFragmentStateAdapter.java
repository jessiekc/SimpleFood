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
    private int initialCount;
    private final SparseArray<Object> cached;

    public MyFragmentStateAdapter(FragmentManager fm, int count) {
        super(fm);
        this.initialCount = count;
        this.count = ExampleRestaurants.reserve(this.initialCount);
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
            fragment = RestaurantsFragment.newInstance(ExampleRestaurants.get(i));
            cached.put(i, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (initialCount != count) {
            this.initialCount = count;
            this.count = ExampleRestaurants.reserve(this.initialCount);
            notifyDataSetChanged();
        }
    }

    public void getNewBatch() {
        int i = 0;
        for (; i <= count; i++) {
            final RestaurantsFragment o = (RestaurantsFragment) cached.get(i);
            if (o == null || !o.isSeen()) {
                break;
            }
        }
        ExampleRestaurants.removeUntil(i);
        cached.clear();
        this.count = ExampleRestaurants.reserve(this.initialCount);
        notifyDataSetChanged();
    }

    public void changeFilter(int[] order, SparseIntArray map) {
        ExampleRestaurants.sort(order, map);
        cached.clear();
        this.count = ExampleRestaurants.reserve(this.initialCount);
        notifyDataSetChanged();
    }

    public void remove(Fragment fragment) {
        int key = cached.keyAt(cached.indexOfValue(fragment));
        ExampleRestaurants.remove(key);
        for (int k = count; k >= key; k--) {
            cached.remove(k);
        }
        count -= 1;
        notifyDataSetChanged();
    }

    public void forceUpdate() {
        cached.clear();
        notifyDataSetChanged();
    }
}
