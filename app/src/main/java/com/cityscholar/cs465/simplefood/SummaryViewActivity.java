package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class SummaryViewActivity extends Activity {
    private ImageButton buttonDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_view);

        List<SummaryListData> data = fill_with_data();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonDetail = findViewById(R.id.buttonDetail);
        buttonDetail.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryViewActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
    public List<SummaryListData> fill_with_data() {

        List<SummaryListData> data = new ArrayList<>();

        data.add(new SummaryListData("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.drawable.restaurant_detail_img1));
        data.add(new SummaryListData("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.drawable.restaurant_detail_img1));
        data.add(new SummaryListData("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.drawable.restaurant_detail_img1));
        data.add(new SummaryListData("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.drawable.restaurant_detail_img1));
        data.add(new SummaryListData("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", R.drawable.restaurant_detail_img1));
        data.add(new SummaryListData("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", R.drawable.restaurant_detail_img1));

        return data;
    }

}
