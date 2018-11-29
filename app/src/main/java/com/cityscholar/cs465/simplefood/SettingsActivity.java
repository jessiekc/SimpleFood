package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

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
        plus=findViewById(R.id.increase);
        minus = findViewById(R.id.decrease);
        sharedpreferences=getSharedPreferences("com.example.myapp.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        minteger = sharedpreferences.getInt("limitNum", 10);
        display(minteger);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minteger = minteger + 1;
                display(minteger);

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putInt("limitNum", minteger);
                editor.commit();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minteger = minteger - 1;
                display(minteger);

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putInt("limitNum", minteger);
                editor.commit();
            }
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



//    public void increaseInteger(View view) {
//        minteger = minteger + 1;
//        display(minteger);
//
//    }public void decreaseInteger(View view) {
//        minteger = minteger - 1;
//        display(minteger);
//    }

    private void display(int number) {
//        TextView displayInteger = (TextView) findViewById(
//                R.id.integer_number);
        limitNum.setText("" + number);
    }
}
