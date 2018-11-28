package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SettingsActivity extends Activity {
    private GridView allergyGridView;
    private GridViewAdapter gridAdapter;

    int minteger = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        allergyGridView = (GridView) findViewById(R.id.allergyGridView);
        gridAdapter = new GridViewAdapter(this, R.layout.allergy_grid_item_layout, getData());
        allergyGridView.setAdapter(gridAdapter);
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



    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }
}
