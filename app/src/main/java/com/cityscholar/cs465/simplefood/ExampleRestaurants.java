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
                    .setName("Name")
                    .setCover(R.drawable.restaurant_img1)
                    .putHighlight(FilterType.PRICE, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("Restaurant detail content...Restaurant detail content...Restaurant detail content...Restaurant detail content...Restaurant detail content...")
                    .appendDetail(R.drawable.restaurant_detail_img1, "IMG1")
                    .appendDetail(R.drawable.restaurant_detail_img2, "IMG2")
                    .build(),
            new Restaurant.Builder()
                    .setName("Name")
                    .setCover(R.drawable.restaurant_img1)
                    .putHighlight(FilterType.PRICE, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail(R.drawable.restaurant_detail_img1, "IMG1")
                    .appendDetail("Restaurant detail content...Restaurant detail content...Restaurant detail content...Restaurant detail content...Restaurant detail content...")
                    .appendDetail("Restaurant detail content...Restaurant detail content...Restaurant detail content...Restaurant detail content...Restaurant detail content...")
                    .appendDetail(R.drawable.restaurant_detail_img2, "IMG2")
                    .build()
            );
}
