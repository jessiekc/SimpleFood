package com.cityscholar.cs465.simplefood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;

public class MainActivity extends FragmentActivity {

    private ImageButton buttonFilters;
    private ImageButton buttonSettings;
    private ImageButton buttonSummary;
    private MyFragmentStateAdapter adapter;
    private SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences("com.example.myapp.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);

        ViewPager viewPagerRestaurants = findViewById(R.id.viewPagerRestaurants);
        adapter = new MyFragmentStateAdapter(getSupportFragmentManager(), sharedpreferences.getInt("limitNum", 10));
        viewPagerRestaurants.setAdapter(adapter);
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
        buttonSummary = findViewById(R.id.buttonSummary);
        buttonSummary.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SummaryViewActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setCount(sharedpreferences.getInt("limitNum", 10));
    }
}

