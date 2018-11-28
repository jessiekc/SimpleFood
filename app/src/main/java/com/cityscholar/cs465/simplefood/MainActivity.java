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
        viewPagerRestaurants.setPageMargin((int) (12 * getResources().getDisplayMetrics().density));

        ImageButton selectButton = findViewById(R.id.buttonCheck);
        selectButton.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
//                Intent intent = null;
//                intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California"));
//                startActivity(intent);
        });

        buttonFilters = findViewById(R.id.buttonFilters);
        buttonFilters.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FilterActivity.class);
            startActivity(intent);
        });
    }
}

