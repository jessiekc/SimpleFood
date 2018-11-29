package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class FilterActivity extends Activity implements AdapterView.OnItemSelectedListener {

    SharedPreferences sharedpreferences;
    public static final String prefs = "prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        Spinner spinner = findViewById(R.id.filter1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter1_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.filter2_options, android.R.layout.simple_spinner_item);
        spinner = findViewById(R.id.filter2);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.filter3_options, android.R.layout.simple_spinner_item);
        spinner = findViewById(R.id.filter3);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.filter4_options, android.R.layout.simple_spinner_item);
        spinner = findViewById(R.id.filter4);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        DragLinearLayout dragLinearLayout = findViewById(R.id.filtersContainer);
        for (int i = 0; i < dragLinearLayout.getChildCount(); i++) {
            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child);
            dragLinearLayout.setOnViewSwapListener(new DragLinearLayout.OnViewSwapListener() {
                @Override
                public void onSwap(View firstView, int firstPosition, View secondView, int secondPosition) {
                    String currentOrder = getOrder();
                    String[] orderArray = currentOrder.split(",", 5);
                    String temp = orderArray[firstPosition];
                    orderArray[firstPosition] = orderArray[secondPosition];
                    orderArray[secondPosition] = temp;
                    String nextOrder = orderArray[0] + ", " + orderArray[1] + ", " + orderArray[2] + ", " + orderArray[3];
                    Save("order", nextOrder);

                    Log.i("THIS IS A DEBUG", sharedpreferences.getAll().toString());
                }
            });
            child.setId(i+1);
        }

        sharedpreferences = getSharedPreferences(prefs,
                Context.MODE_PRIVATE);
        sharedpreferences.edit().clear().apply();

        sharedpreferences.edit().putString("order", getOrder()).apply();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }

    private void Save(String filter, String option){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(filter, option);
        editor.apply();
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        if(parent.getId() == 2131230805) {
            Save("filter1", parent.getItemAtPosition(pos).toString());
        } else if (parent.getId() == 2131230806){
           Save("filter2", parent.getItemAtPosition(pos).toString());
        } else if (parent.getId() == 2131230807){
            Save("filter3", parent.getItemAtPosition(pos).toString());
        } else if (parent.getId() == 2131230808){
            Save("filter4", parent.getItemAtPosition(pos).toString());
        }
        Save("order", getOrder());
        sharedpreferences = getSharedPreferences(prefs,
                Context.MODE_PRIVATE);
        Log.i("THIS IS A DEBUG", sharedpreferences.getAll().toString());

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private String getOrder(){
        String pos1, pos2, pos3, pos4;

        DragLinearLayout dragLinearLayout = findViewById(R.id.filtersContainer);
        pos1 = "filter" + Integer.toString(dragLinearLayout.getChildAt(0).getId());
        pos2 = "filter" + Integer.toString(dragLinearLayout.getChildAt(1).getId());
        pos3 = "filter" + Integer.toString(dragLinearLayout.getChildAt(2).getId());
        pos4 = "filter" + Integer.toString(dragLinearLayout.getChildAt(3).getId());
        return pos1 + ", " + pos2 + ", " + pos3 + ", " + pos4;
    }

}

