package com.cityscholar.cs465.simplefood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class SummaryViewActivity extends Activity {
    private ImageButton buttonDetail;
    private ImageButton buttonCheck;

    SharedPreferences sharedpreferences;

    int minteger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_view);

        sharedpreferences=getSharedPreferences("com.example.myapp.PREFERENCE_FILE_KEY",Context.MODE_PRIVATE);

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

//        buttonCheck = findViewById(R.id.buttonCheck);
//        buttonCheck.setOnClickListener(v -> {
//            Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California");
//            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//            mapIntent.setPackage("com.google.android.apps.maps");
//            startActivity(mapIntent);
//        });
    }
    public List<SummaryListData> fill_with_data() {

        List<SummaryListData> data = new ArrayList<>();
        minteger= sharedpreferences.getInt("limitNum", 10);

        data.add(new SummaryListData("The Purple Pig", "The Bannos' Magnificent Mile Mediterranean restaurant is a constantly-bustling small plate bonanza downtown.", R.drawable.restaurant1_detail_img1));
        if(minteger==1){ return data; }
        data.add(new SummaryListData("Frontera Grill", "The Mexican restaurant that started it all for Rick Bayless continues to endure after nearly three decades in River North.", R.drawable.restaurant2_detail_img1));
        if(minteger==2){ return data; }
        data.add(new SummaryListData("Gilt Bar", "Brendan Sodikoff's first River North restaurant set the sultry standard for his string of smash hits.", R.drawable.restaurant3_detail_img1));
        if(minteger==3){ return data; }
        data.add(new SummaryListData("Sabri Nihari", "An Indian-Pakistani stalwart on Devon Avenue.", R.drawable.restaurant4_detail_img1));
        if(minteger==4){ return data; }
        data.add(new SummaryListData("Mango Pickle", "Edgewater's creative Indian destination gets Michelin status.", R.drawable.restaurant5_detail_img1));
        if(minteger==5){ return data; }
        data.add(new SummaryListData("The Angry Crab", "The Angry Crab, with locations in Wicker Park and West Rogers Park, started the explosion of bagged Cajun seafood in Chicago.", R.drawable.restaurant6_detail_img1));
        if(minteger==6){ return data; }
        data.add(new SummaryListData("Jin Thai Cuisine", "This North Side Thai restaurant gets another accolade from the Michelin Man.", R.drawable.restaurant7_detail_img1));
        if(minteger==7){ return data; }
        data.add(new SummaryListData("Herb", "The fancy Thai restaurant up north is a Bib Gourmand for the third year.", R.drawable.restaurant8_detail_img1));
        if(minteger==8){ return data; }
        data.add(new SummaryListData("Passerotto", "Chef Jennifer Kim (Snaggletooth) has wowed fans in Andersonville. A suburban Chicago native, she celebrates her Korean heritage using Western kitchen techniques and good wine.", R.drawable.restaurant9_detail_img1));
        if(minteger==9){ return data; }
        data.add(new SummaryListData("San Soo Gab San", "San Soo Gab San is a carnivores dream with Korean tabletop grills in a no-frills atmosphere. The restaurant is also well past midnight, and runs a suburban location in Morton Grove. There’s also a location in River West.", R.drawable.restaurant10_detail_img1));
        if(minteger==10){ return data; }
        data.add(new SummaryListData("Hopleaf Bar", "The gold standard for craft beer bars in Chicago, Hopleaf's menu that includes oysters and Montreal-style brisket has something for everyone.", R.drawable.restaurant11_detail_img1));
        if(minteger==11){ return data; }
        data.add(new SummaryListData("Smoque BBQ", "Perhaps the city's best barbecue, eaters venture from far and wide for the acclaimed ribs, pulled pork, brisket, and much more.", R.drawable.restaurant12_detail_img1));
        if(minteger==12){ return data; }
        data.add(new SummaryListData("Wood", "This Boystown restaurant has fine-dining pedigree and outstanding cocktails.", R.drawable.restaurant13_detail_img1));
        if(minteger==13){ return data; }
        data.add(new SummaryListData("Ceres' Table", "The East Lakeview Italian restaurant hasn't lost a step since relocating from further north.", R.drawable.restaurant14_detail_img1));
        if(minteger==14){ return data; }
        data.add(new SummaryListData("Chilam Balam", "The creative Mexican restaurant in East Lakeview gets more accolades from the Michelin Guide.", R.drawable.restaurant15_detail_img1));

        return data;
    }

}
