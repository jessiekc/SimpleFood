package com.cityscholar.cs465.simplefood;

import android.util.SparseArray;

import java.util.*;

public class ExampleRestaurants {
    private static final List<String> highlights = Arrays.asList("", "This restaurants has low price",
            "This restaurants is very close",
            "This is a Chinese restaurants",
            "This restaurants is similar to what you've been to");
    private static final List<Restaurant> RESTAURANTS = new ArrayList<>(Arrays.asList(
            new Restaurant.Builder()
                    .setName("The Purple Pig")
                    .setCover(R.drawable.restaurant1_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The Bannos' Magnificent Mile Mediterranean restaurant is a constantly-bustling small plate bonanza downtown.")
                    .appendDetail(R.drawable.restaurant1_detail_img1, "Calamari Salad")
                    .appendDetail(R.drawable.restaurant1_detail_img2, "Crispy Pig’s Ears")
                    .setLocation("500 N Michigan Ave, Chicago, IL 60611")
                    .build(),
            new Restaurant.Builder()
                    .setName("Frontera Grill")
                    .setCover(R.drawable.restaurant2_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The Mexican restaurant that started it all for Rick Bayless continues to endure after nearly three decades in River North.")
                    .appendDetail(R.drawable.restaurant2_detail_img1, "Elote")
                    .appendDetail(R.drawable.restaurant2_detail_img2, "Frontera Ceviche")
                    .setLocation("445 N Clark St, Chicago, IL 60654")
                    .build(),
            new Restaurant.Builder()
                    .setName("Gilt Bar")
                    .setCover(R.drawable.restaurant3_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("Brendan Sodikoff's first River North restaurant set the sultry standard for his string of smash hits.")
                    .appendDetail(R.drawable.restaurant3_detail_img1, "Cocktail")
                    .appendDetail(R.drawable.restaurant3_detail_img2, "Short rib bacon ragu pasta")
                    .setLocation("230 W Kinzie St, Chicago, IL 60654")
                    .build(),
            new Restaurant.Builder()
                    .setName("Sabri Nihari")
                    .setCover(R.drawable.restaurant4_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("An Indian-Pakistani stalwart on Devon Avenue.")
                    .appendDetail(R.drawable.restaurant4_detail_img1, "Garlic naan")
                    .appendDetail(R.drawable.restaurant4_detail_img2, "Saki fry")
                    .setLocation("1970, 2502 W Devon Ave, Chicago, IL 60659")
                    .build(),
            new Restaurant.Builder()
                    .setName("Mango Pickle")
                    .setCover(R.drawable.restaurant5_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("Edgewater's creative Indian destination gets Michelin status.")
                    .appendDetail(R.drawable.restaurant5_detail_img1, "Carrot halwa and French toast")
                    .appendDetail(R.drawable.restaurant5_detail_img2, "Smoky negroni")
                    .setLocation("5842 N Broadway, Chicago, IL 60660")
                    .build(),
            new Restaurant.Builder()
                    .setName("The Angry Crab")
                    .setCover(R.drawable.restaurant6_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The Angry Crab, with locations in Wicker Park and West Rogers Park, started the explosion of bagged Cajun seafood in Chicago.")
                    .appendDetail(R.drawable.restaurant6_detail_img1, "Garlic noodle")
                    .appendDetail(R.drawable.restaurant6_detail_img2, "Louisiana char grilled oysters")
                    .setLocation("5665 N Lincoln Ave, Chicago, IL 60659")
                    .build(),
            new Restaurant.Builder()
                    .setName("Jin Thai Cuisine")
                    .setCover(R.drawable.restaurant7_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("This North Side Thai restaurant gets another accolade from the Michelin Man.")
                    .appendDetail(R.drawable.restaurant7_detail_img1, "Thai iced tea")
                    .appendDetail(R.drawable.restaurant7_detail_img2, "Roti ice cream")
                    .setLocation("5458 N Broadway, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("Herb")
                    .setCover(R.drawable.restaurant8_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The fancy Thai restaurant up north is a Bib Gourmand for the third year.")
                    .appendDetail(R.drawable.restaurant8_detail_img1, "Curry Chicken")
                    .appendDetail(R.drawable.restaurant8_detail_img2, "Betal Leaf")
                    .setLocation("5424 N Broadway St, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("Passerotto")
                    .setCover(R.drawable.restaurant9_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("Chef Jennifer Kim (Snaggletooth) has wowed fans in Andersonville. A suburban Chicago native, she celebrates her Korean heritage using Western kitchen techniques and good wine.")
                    .appendDetail(R.drawable.restaurant9_detail_img1, "Bay Scallops with homemade XO, soy onion puree, citron")
                    .appendDetail(R.drawable.restaurant9_detail_img2, "Hwe dup bap with farro, tuna, salmon, and pickled ginger")
                    .setLocation("5420 N Clark St, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("San Soo Gab San")
                    .setCover(R.drawable.restaurant10_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("San Soo Gab San is a carnivores dream with Korean tabletop grills in a no-frills atmosphere. The restaurant is also well past midnight, and runs a suburban location in Morton Grove. There’s also a location in River West.")
                    .appendDetail(R.drawable.restaurant10_detail_img1, "Seafood stew")
                    .appendDetail(R.drawable.restaurant10_detail_img2, "Dol-sot bibimbap")
                    .setLocation("5247 N Western Ave, Chicago, IL 60625")
                    .build(),
            new Restaurant.Builder()
                    .setName("Hopleaf Bar")
                    .setCover(R.drawable.restaurant11_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The gold standard for craft beer bars in Chicago, Hopleaf's menu that includes oysters and Montreal-style brisket has something for everyone.")
                    .appendDetail(R.drawable.restaurant11_detail_img1, "Mac and Stilton Cheese")
                    .appendDetail(R.drawable.restaurant11_detail_img2, "So many options!")
                    .setLocation("5148 N Clark St, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("Smoque BBQ")
                    .setCover(R.drawable.restaurant12_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("Perhaps the city's best barbecue, eaters venture from far and wide for the acclaimed ribs, pulled pork, brisket, and much more.")
                    .appendDetail(R.drawable.restaurant12_detail_img1, "St. Louis Style Ribs")
                    .appendDetail(R.drawable.restaurant12_detail_img2, "Sliced Brisket w coleslaw and 2 sides")
                    .setLocation("3800 N Pulaski Rd, Chicago, IL 60641")
                    .build(),
            new Restaurant.Builder()
                    .setName("Wood")
                    .setCover(R.drawable.restaurant13_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("This Boystown restaurant has fine-dining pedigree and outstanding cocktails.")
                    .appendDetail(R.drawable.restaurant13_detail_img1, "cinnamon roll")
                    .appendDetail(R.drawable.restaurant13_detail_img2, "Spinach Walleye with Risotto")
                    .setLocation("3335 N Halsted St, Chicago, IL 60657")
                    .build(),
            new Restaurant.Builder()
                    .setName("Ceres' Table")
                    .setCover(R.drawable.restaurant14_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The East Lakeview Italian restaurant hasn't lost a step since relocating from further north.")
                    .appendDetail(R.drawable.restaurant14_detail_img1, "Whole Grilled Brazino")
                    .appendDetail(R.drawable.restaurant14_detail_img2, "Flannery")
                    .setLocation("3124 N Broadway, Chicago, IL 60657")
                    .build(),
            new Restaurant.Builder()
                    .setName("Chilam Balam")
                    .setCover(R.drawable.restaurant15_img)
                    .putHighlight(FilterType.PRICE, 0, highlights.get(FilterType.PRICE))
                    .putHighlight(FilterType.DISTANCE, 0, highlights.get(FilterType.DISTANCE))
                    .putHighlight(FilterType.CUISINE, 0, highlights.get(FilterType.CUISINE))
                    .putHighlight(FilterType.FAMILIARITY, 0, highlights.get(FilterType.FAMILIARITY))
                    .appendDetail("The creative Mexican restaurant in East Lakeview gets more accolades from the Michelin Guide.")
                    .appendDetail(R.drawable.restaurant15_detail_img1, "Desserts")
                    .appendDetail(R.drawable.restaurant15_detail_img2, "Fried Avocadoes with Lobster Sauce")
                    .setLocation("3023 N Broadway, Chicago, IL 60657")
                    .build()

    ));
    public static final List<Restaurant> TAKEN = new ArrayList<>();

    public static final int reserve(int number) {
        return number > RESTAURANTS.size() ? RESTAURANTS.size() : number;
    }

    public static List<Restaurant> take(int number) {
        List<Restaurant> newList = new ArrayList<>();
        while (number > 0) {
            number--;
            newList.add(RESTAURANTS.remove(RESTAURANTS.size() - 1));
        }
        TAKEN.addAll(newList);
        return newList;
    }

    public static void sort() {
        RESTAURANTS.addAll(TAKEN);
        TAKEN.clear();
//        RESTAURANTS.sort(Comparator.comparingInt(r -> {
//            final SparseArray<Highlight> highlights = r.getHighlights();
//            int weight = 1 << order.size();
//            int res = 0;
//            for (Integer type : order) {
//                if (highlights.get(type).level == levels.get(type)) {
//                    res += weight;
//                }
//                weight >>= 1;
//            }
//            return res;
//        }));
        Collections.shuffle(RESTAURANTS);
    }

    public static Restaurant take() {
        return take(1).get(0);
    }
}
