package com.cityscholar.cs465.simplefood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.widget.ImageButton;
import android.widget.Toast;
import com.cityscholar.cs465.simplefood.options.Option;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
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
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                if (adapter.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No more restaurants to show at this time :(", Toast.LENGTH_LONG).show();
                }
            }
        });
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
            startActivityForResult(intent, 0x1011);
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
        if (filterPreferences.getBoolean("new", true)) {
            Snackbar.make(MainActivity.this.findViewById(R.id.main),
                    "Want to see better recommendations?", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Customize", v -> {
                        filterPreferences.edit().putBoolean("new", false).apply();
                        Intent intent = new Intent(MainActivity.this, FilterActivity.class);
                        startActivityForResult(intent, 0x1010);
                    }).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 0x1010 && data.getBooleanExtra("changed", false)) {
                change();
            } else if (requestCode == 0x1011 && data.getBooleanExtra("dismissed", false)) {
                adapter.forceUpdate();
            }
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
    public void onFragmentInteraction(Fragment fragment, long duration) {
        adapter.remove(fragment);
        if (duration / 1000000.0 < 500) {
            Snackbar.make(MainActivity.this.findViewById(R.id.main),
                    "You just made a quick dismiss", Snackbar.LENGTH_LONG)
                    .setAction("Tell us why", v -> {
                        Toast.makeText(MainActivity.this, "To be implemented soon :(", Toast.LENGTH_LONG)
                                .show();
                    }).show();
        }
    }
}

