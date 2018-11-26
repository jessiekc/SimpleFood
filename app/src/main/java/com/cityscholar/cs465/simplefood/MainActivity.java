package com.cityscholar.cs465.simplefood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPagerRestaurants = findViewById(R.id.viewPagerRestaurants);
        viewPagerRestaurants.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return RestaurantsFragment.newInstance("1", "2");
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        viewPagerRestaurants.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener());
    }
}

