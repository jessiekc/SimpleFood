package com.cityscholar.cs465.simplefood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;

public class MainActivity extends FragmentActivity {

    private ImageButton buttonFilters;
    private ImageButton buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPagerRestaurants = findViewById(R.id.viewPagerRestaurants);
        viewPagerRestaurants.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return RestaurantsFragment.newInstance(ExampleRestaurants.RESTAURANTS.get(i));
            }

            @Override
            public int getCount() {
                return ExampleRestaurants.RESTAURANTS.size();
            }
        });
        viewPagerRestaurants.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener());
        viewPagerRestaurants.setPageMargin((int) (12 * getResources().getDisplayMetrics().density));

        this.<ImageButton>findViewById(R.id.buttonCheck).setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        buttonFilters = findViewById(R.id.buttonFilters);
        buttonFilters.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FilterActivity.class);
            startActivity(intent);
        });

        buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
        buttonSettings = findViewById(R.id.buttonSummary);
        buttonSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SummaryViewActivity.class);
            startActivity(intent);
        });
    }
}

