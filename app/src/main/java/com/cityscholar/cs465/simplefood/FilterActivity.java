package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.cityscholar.cs465.simplefood.options.*;
import com.jmedeisis.draglinearlayout.DragLinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = FilterActivity.class.getSimpleName();

    SharedPreferences sharedpreferences;
    public static final String PREFS = "PREFS";

    @Nullable
    private Map<String, ?> settings = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            settings = (Map<String, ?>) savedInstanceState.getSerializable("savedSettings");
        }
        setContentView(R.layout.activity_filters);

        RelativeLayout filt1 = findViewById(R.id.filter1container);
        RelativeLayout filt2 = findViewById(R.id.filter2container);
        RelativeLayout filt3 = findViewById(R.id.filter3container);
        RelativeLayout filt4 = findViewById(R.id.filter4container);

        sharedpreferences = getSharedPreferences(PREFS,
                Context.MODE_PRIVATE);
        if (savedInstanceState != null) {
            savedInstanceState.putSerializable("savedSettings", new HashMap<>(sharedpreferences.getAll()));
            if (!sharedpreferences.getAll().equals(settings)) {
                setResultSettingChanged();
                Log.d(TAG, "setting changed onCreate");
            }
        }
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
        List<String> spinnerArray = buildSpinOptions(sharedpreferences.getString("filter1", PriceOption.getInstance().getDefault()), PriceOption.getInstance().getAll());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = filt2.findViewById(R.id.filter2);
        spinnerArray = buildSpinOptions(sharedpreferences.getString("filter2", DistanceOption.getInstance().getDefault()), DistanceOption.getInstance().getAll());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = filt3.findViewById(R.id.filter3);
        spinnerArray = buildSpinOptions(sharedpreferences.getString("filter3", CuisineOption.getInstance().getDefault()), CuisineOption.getInstance().getAll());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = filt4.findViewById(R.id.filter4);
        spinnerArray = buildSpinOptions(sharedpreferences.getString("filter4", FamiliarityOption.getInstance().getDefault()), FamiliarityOption.getInstance().getAll());
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

    private void setResultSettingChanged() {
        Intent intent = new Intent();
        intent.putExtra("changed", true);
        setResult(RESULT_OK, intent);
    }

    private void Save(String filter, String option){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(filter, option);
        editor.apply();
        if (!sharedpreferences.getAll().equals(settings)) {
            Log.d(TAG, "setting changed Save");
            setResultSettingChanged();
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        String filter = getFilterName(parent);
        Save(filter, parent.getItemAtPosition(pos).toString());
        Save("order", getOrder());
        sharedpreferences = getSharedPreferences(PREFS,
                Context.MODE_PRIVATE);
        Log.d(TAG, sharedpreferences.getAll().toString());
    }

    private String getFilterName(AdapterView<?> parent) {
        switch (parent.getId()) {
            case R.id.filter1:
                return "filter1";
            case R.id.filter2:
                return "filter2";
            case R.id.filter3:
                return "filter3";
            case R.id.filter4:
                return "filter4";
            default:
                throw new IllegalStateException("Error id");
        }
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

