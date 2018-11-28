package com.cityscholar.cs465.simplefood;

import java.util.Arrays;
import java.util.List;

public class ExampleRestaurants {
    private static final List<String> highlights = Arrays.asList("", "This restaurants has low price",
            "This restaurants is very close",
            "This is a Chinese restaurants",
            "This restaurants is similar to what you've been to");
    public static final List<Restaurant> RESTAURANTS = Arrays.asList(
            new Restaurant.Builder()
                    .setName("The Purple Pig")
                    .setCover(R.drawable.restaurant1_img)
                    .putHighlight(FilterType.PRICE, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The Bannos' Magnificent Mile Mediterranean restaurant is a constantly-bustling small plate bonanza downtown.")
                    .appendDetail(R.drawable.restaurant1_detail_img1, "Calamari Salad")
                    .appendDetail(R.drawable.restaurant1_detail_img2, "Crispy Pig’s Ears")
                    .build(),
            new Restaurant.Builder()
                    .setName("Frontera Grill")
                    .setCover(R.drawable.restaurant2_img)
                    .putHighlight(FilterType.PRICE, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The Mexican restaurant that started it all for Rick Bayless continues to endure after nearly three decades in River North.")
                    .appendDetail(R.drawable.restaurant2_detail_img1, "Elote")
                    .appendDetail(R.drawable.restaurant2_detail_img2, "Frontera Ceviche")
                    .build()


            );

}
