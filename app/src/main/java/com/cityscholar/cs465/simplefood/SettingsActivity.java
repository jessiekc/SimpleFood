package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingsActivity extends Activity {
    private GridView allergyGridView;
    private GridViewAdapter gridAdapter;


    TextView limitNum;
    Button plus;
    Button minus;
    SharedPreferences sharedpreferences;
    int minteger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        allergyGridView = findViewById(R.id.allergyGridView);
        gridAdapter = new GridViewAdapter(this, R.layout.allergy_grid_item_layout, getData());
        allergyGridView.setAdapter(gridAdapter);

        limitNum = findViewById(R.id.integer_number);
        plus = findViewById(R.id.increase);
        minus = findViewById(R.id.decrease);

        sharedpreferences = getSharedPreferences("com.example.myapp.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        minteger = sharedpreferences.getInt("limitNum", 10);
        display(minteger);

        plus.setOnClickListener(v -> {
            minteger = minteger + 1;
            display(minteger);
            sharedpreferences.edit().putInt("limitNum", minteger).apply();
        });

        minus.setOnClickListener(v -> {
            minteger = minteger - 1;
            display(minteger);
            sharedpreferences.edit().putInt("limitNum", minteger).apply();
        });

    }

    // Prepare some dummy data for gridview
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.allergy_image_ids);
        TypedArray titles = getResources().obtainTypedArray(R.array.allergy_image_titles);

        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, titles.getString(i)));
        }
        return imageItems;
    }


    private void display(int number) {
        limitNum.setText("" + number);
    }
}
