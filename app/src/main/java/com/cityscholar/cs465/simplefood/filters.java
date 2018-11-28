package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class filters extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        Spinner spinner = findViewById(R.id.filter1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.filter2);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.filter3);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.filter4);
        spinner.setAdapter(adapter);

        DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.filtersContainer);
        for(int i = 0; i < dragLinearLayout.getChildCount(); i++){
            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child);
        }
    }
}

