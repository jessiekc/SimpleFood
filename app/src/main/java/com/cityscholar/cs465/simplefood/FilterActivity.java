package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.jmedeisis.draglinearlayout.DragLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = FilterActivity.class.getSimpleName();

    SharedPreferences sharedpreferences;
    public static final String PREFS = "PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        RelativeLayout filt1 = findViewById(R.id.filter1container);
        RelativeLayout filt2 = findViewById(R.id.filter2container);
        RelativeLayout filt3 = findViewById(R.id.filter3container);
        RelativeLayout filt4 = findViewById(R.id.filter4container);

        sharedpreferences = getSharedPreferences(PREFS,
                Context.MODE_PRIVATE);
        String filtsOrder = sharedpreferences.getString("order", "filter1,filter2,filter3,filter4");
        String[] filtsOrderArray = filtsOrder.split(",", 5);
        DragLinearLayout dragLinearLayout = findViewById(R.id.filtersContainer);

        int childCount = dragLinearLayout.getChildCount();
        for(int i = 0; i < childCount; i++){
            dragLinearLayout.removeViewAt(0);
        }

        for(int i = 0; i < childCount; i++){
            if(filtsOrderArray[i].equals("filter1")){
                dragLinearLayout.addView(filt1, i);
                changeWeight(filt1, 4-i);
            }
            else if(filtsOrderArray[i].equals("filter2")){
                dragLinearLayout.addView(filt2, i);
                changeWeight(filt2, 4-i);
            }
            else if(filtsOrderArray[i].equals("filter3")){
                dragLinearLayout.addView(filt3, i);
                changeWeight(filt3, 4-i);
            }
            else if(filtsOrderArray[i].equals("filter4")){
                dragLinearLayout.addView(filt4, i);
                changeWeight(filt4, 4-i);
            }
        }

        Spinner spinner = filt1.findViewById(R.id.filter1);
        List<String> spinnerArray = buildSpinOptions(sharedpreferences.getString("filter1", "Less than $10"), "Less than $10", "$10-$20", "$20-$30", "More than $30");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = filt2.findViewById(R.id.filter2);
        spinnerArray = buildSpinOptions(sharedpreferences.getString("filter2", "Less than 1 mile"), "Less than 1 mile", "1-5 miles", "5-10 miles", "More than 10 miles");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = filt3.findViewById(R.id.filter3);
        spinnerArray = buildSpinOptions(sharedpreferences.getString("filter3", "chinese"), "chinese", "mexican", "thai", "mediterranean");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = filt4.findViewById(R.id.filter4);
        spinnerArray = buildSpinOptions(sharedpreferences.getString("filter4", "familiar"), "familiar", "kinda familiar", "new");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        for (int i = 0; i < dragLinearLayout.getChildCount(); i++) {
            ViewGroup child = (ViewGroup) dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child.getChildAt(0));
            dragLinearLayout.setOnViewSwapListener((firstView, firstPosition, secondView, secondPosition) -> {
                String currentOrder = getOrder();
                String[] orderArray = currentOrder.split(",", 5);
                String temp = orderArray[firstPosition];
                orderArray[firstPosition] = orderArray[secondPosition];
                orderArray[secondPosition] = temp;
                String nextOrder = orderArray[0] + "," + orderArray[1] + "," + orderArray[2] + "," + orderArray[3];
                Save("order", nextOrder);

                changeWeight(firstView, 4-secondPosition);
                changeWeight(secondView, 4-firstPosition);

                Log.d(TAG, sharedpreferences.getAll().toString());
            });
            if(child == filt1){
                child.setId(1);
            }else if(child == filt2){
                child.setId(2);
            }else if(child == filt3){
                child.setId(3);
            }else if(child == filt4){
                child.setId(4);
            }
        }

    }

    private void Save(String filter, String option){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(filter, option);
        editor.apply();
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        if(parent.getId() == R.id.filter1) {
            Save("filter1", parent.getItemAtPosition(pos).toString());
        } else if (parent.getId() == R.id.filter2){
           Save("filter2", parent.getItemAtPosition(pos).toString());
        } else if (parent.getId() == R.id.filter3){
            Save("filter3", parent.getItemAtPosition(pos).toString());
        } else if (parent.getId() == R.id.filter4){
            Save("filter4", parent.getItemAtPosition(pos).toString());
        }
        Save("order", getOrder());
        sharedpreferences = getSharedPreferences(PREFS,
                Context.MODE_PRIVATE);
        Log.d(TAG, sharedpreferences.getAll().toString());
        final Intent data = new Intent();
        data.putExtra("changed", 1);
        setResult(RESULT_OK, data);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private String getOrder(){
        String pos1, pos2, pos3, pos4;

        DragLinearLayout dragLinearLayout = findViewById(R.id.filtersContainer);
        pos1 = "filter" + dragLinearLayout.getChildAt(0).getId();
        pos2 = "filter" + dragLinearLayout.getChildAt(1).getId();
        pos3 = "filter" + dragLinearLayout.getChildAt(2).getId();
        pos4 = "filter" + dragLinearLayout.getChildAt(3).getId();
        return pos1 + "," + pos2 + "," + pos3 + "," + pos4;
    }

    private List<String> buildSpinOptions(String firstOption, String ... options){
        List<String> optionsList = new ArrayList<>();
        for (String option:options){
            if(option.equals(firstOption)){
                optionsList.add(firstOption);
            }
        }
        for(String option:options){
            if(!option.equals(firstOption)){
                optionsList.add(option);
            }
        }

        return optionsList;
    }

    private void changeWeight(View view, float weight){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, weight);
        view.setLayoutParams(params);
    }
}

