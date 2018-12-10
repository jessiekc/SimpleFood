package com.cityscholar.cs465.simplefood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.widget.ImageButton;
import com.cityscholar.cs465.simplefood.options.Option;

import java.util.Arrays;

public class MainActivity extends FragmentActivity
        implements RestaurantsFragment.OnFragmentInteractionListener {

    private ImageButton buttonFilters;
    private ImageButton buttonSettings;
    private ImageButton buttonSummary;
    private MyFragmentStateAdapter adapter;
    private SharedPreferences sharedpreferences;
    private SharedPreferences filterPreferences;
    private ViewPager viewPagerRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences("com.example.myapp.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        filterPreferences = getSharedPreferences(FilterActivity.PREFS, Context.MODE_PRIVATE);

        viewPagerRestaurants = findViewById(R.id.viewPagerRestaurants);
        adapter = new MyFragmentStateAdapter(getSupportFragmentManager(), sharedpreferences.getInt("limitNum", 10));
        change();
        viewPagerRestaurants.setAdapter(adapter);
        viewPagerRestaurants.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener());
        viewPagerRestaurants.setPageMargin((int) (12 * getResources().getDisplayMetrics().density));

        buttonFilters = findViewById(R.id.buttonFilters);
        buttonFilters.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FilterActivity.class);
            startActivityForResult(intent, 0x1010);
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

        this.<ImageButton>findViewById(R.id.buttonShuffle).setOnClickListener(v -> {
            adapter.getNewBatch();
            viewPagerRestaurants.setCurrentItem(0, true);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setCount(sharedpreferences.getInt("limitNum", 10));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x1010 && resultCode == RESULT_OK && data != null && data.getBooleanExtra("changed", false)) {
            change();
        }
    }

    private void change() {
        final String orderStr = filterPreferences.getString("order", "filter1, filter2, filter3, filter4");
        final int[] order = Arrays.stream(orderStr.split(",", 5))
                .map(String::trim)
                .mapToInt(s -> Integer.parseInt(s.substring("filter".length())))
                .toArray();
        SparseIntArray map = new SparseIntArray(order.length);
        for (int filter : order) {
            final String index = "filter" + filter;
            map.put(filter, Option.getIndex(index, filterPreferences.getString(index, Option.getDefault(index))));
        }
        adapter.changeFilter(order, map);
        viewPagerRestaurants.setCurrentItem(0, true);
    }

    @Override
    public void onFragmentInteraction(Fragment fragment) {
        adapter.remove(fragment);
    }
}

