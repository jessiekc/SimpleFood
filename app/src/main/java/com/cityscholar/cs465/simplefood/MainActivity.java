package com.cityscholar.cs465.simplefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ImageButton buttonFilters;

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

        buttonFilters = findViewById(R.id.buttonFilters);
        buttonFilters.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId() == R.id.buttonFilters){
            Intent intent = new Intent(this, filters.class);
            startActivity(intent);
        }
    }
}

