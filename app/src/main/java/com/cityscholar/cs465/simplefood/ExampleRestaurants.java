package com.cityscholar.cs465.simplefood;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.cityscholar.cs465.simplefood.options.CuisineOption;
import com.cityscholar.cs465.simplefood.options.DistanceOption;
import com.cityscholar.cs465.simplefood.options.FamiliarityOption;
import com.cityscholar.cs465.simplefood.options.PriceOption;

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
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.MORE_THAN_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.MORE_THAN_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("The Bannos' Magnificent Mile Mediterranean restaurant is a constantly-bustling small plate bonanza downtown.")
                    .appendDetail(R.drawable.restaurant1_detail_img1, "Calamari Salad")
                    .appendDetail(R.drawable.restaurant1_detail_img2, "Crispy Pig’s Ears")
                    .setLocation("500 N Michigan Ave, Chicago, IL 60611")
                    .build(),
            new Restaurant.Builder()
                    .setName("Frontera Grill")
                    .setCover(R.drawable.restaurant2_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.LESS_THAN_$_10),
                            PriceOption.getInstance().getDescription(PriceOption.LESS_THAN_$_10))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.MEXICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.MEXICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.FAMILIAR))
                    .appendDetail("The Mexican restaurant that started it all for Rick Bayless continues to endure after nearly three decades in River North.")
                    .appendDetail(R.drawable.restaurant2_detail_img1, "Elote")
                    .appendDetail(R.drawable.restaurant2_detail_img2, "Frontera Ceviche")
                    .setLocation("445 N Clark St, Chicago, IL 60654")
                    .build(),
            new Restaurant.Builder()
                    .setName("Gilt Bar")
                    .setCover(R.drawable.restaurant3_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_20_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.$_20_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES1),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES1))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("Brendan Sodikoff's first River North restaurant set the sultry standard for his string of smash hits.")
                    .appendDetail(R.drawable.restaurant3_detail_img1, "Cocktail")
                    .appendDetail(R.drawable.restaurant3_detail_img2, "Short rib bacon ragu pasta")
                    .setLocation("230 W Kinzie St, Chicago, IL 60654")
                    .build(),
            new Restaurant.Builder()
                    .setName("Sabri Nihari")
                    .setCover(R.drawable.restaurant4_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_20_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.$_20_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.LESS_THAN_1_MILE),
                            DistanceOption.getInstance().getDescription(DistanceOption.LESS_THAN_1_MILE))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.INDIAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.INDIAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("An Indian-Pakistani stalwart on Devon Avenue.")
                    .appendDetail(R.drawable.restaurant4_detail_img1, "Garlic naan")
                    .appendDetail(R.drawable.restaurant4_detail_img2, "Saki fry")
                    .setLocation("1970, 2502 W Devon Ave, Chicago, IL 60659")
                    .build(),
            new Restaurant.Builder()
                    .setName("Mango Pickle")
                    .setCover(R.drawable.restaurant5_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.LESS_THAN_$_10),
                            PriceOption.getInstance().getDescription(PriceOption.LESS_THAN_$_10))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MORE_THAN_10_MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MORE_THAN_10_MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.INDIAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.INDIAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("Edgewater's creative Indian destination gets Michelin status.")
                    .appendDetail(R.drawable.restaurant5_detail_img1, "Carrot halwa and French toast")
                    .appendDetail(R.drawable.restaurant5_detail_img2, "Smoky negroni")
                    .setLocation("5842 N Broadway, Chicago, IL 60660")
                    .build(),
            new Restaurant.Builder()
                    .setName("The Angry Crab")
                    .setCover(R.drawable.restaurant6_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.MORE_THAN_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.MORE_THAN_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES1),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES1))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("The Angry Crab, with locations in Wicker Park and West Rogers Park, started the explosion of bagged Cajun seafood in Chicago.")
                    .appendDetail(R.drawable.restaurant6_detail_img1, "Garlic noodle")
                    .appendDetail(R.drawable.restaurant6_detail_img2, "Louisiana char grilled oysters")
                    .setLocation("5665 N Lincoln Ave, Chicago, IL 60659")
                    .build(),
            new Restaurant.Builder()
                    .setName("Jin Thai Cuisine")
                    .setCover(R.drawable.restaurant7_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_10_$_20),
                            PriceOption.getInstance().getDescription(PriceOption.$_10_$_20))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.LESS_THAN_1_MILE),
                            DistanceOption.getInstance().getDescription(DistanceOption.LESS_THAN_1_MILE))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.THAI),
                            CuisineOption.getInstance().getDescription(CuisineOption.THAI))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.FAMILIAR))
                    .appendDetail("This North Side Thai restaurant gets another accolade from the Michelin Man.")
                    .appendDetail(R.drawable.restaurant7_detail_img1, "Thai iced tea")
                    .appendDetail(R.drawable.restaurant7_detail_img2, "Roti ice cream")
                    .setLocation("5458 N Broadway, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("Herb")
                    .setCover(R.drawable.restaurant8_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.LESS_THAN_$_10),
                            PriceOption.getInstance().getDescription(PriceOption.LESS_THAN_$_10))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.THAI),
                            CuisineOption.getInstance().getDescription(CuisineOption.THAI))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.FAMILIAR))
                    .appendDetail("The fancy Thai restaurant up north is a Bib Gourmand for the third year.")
                    .appendDetail(R.drawable.restaurant8_detail_img1, "Curry Chicken")
                    .appendDetail(R.drawable.restaurant8_detail_img2, "Betal Leaf")
                    .setLocation("5424 N Broadway St, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("Passerotto")
                    .setCover(R.drawable.restaurant9_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.MORE_THAN_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.MORE_THAN_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("Chef Jennifer Kim (Snaggletooth) has wowed fans in Andersonville. A suburban Chicago native, she celebrates her Korean heritage using Western kitchen techniques and good wine.")
                    .appendDetail(R.drawable.restaurant9_detail_img1, "Bay Scallops with homemade XO, soy onion puree, citron")
                    .appendDetail(R.drawable.restaurant9_detail_img2, "Hwe dup bap with farro, tuna, salmon, and pickled ginger")
                    .setLocation("5420 N Clark St, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("San Soo Gab San")
                    .setCover(R.drawable.restaurant10_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_20_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.$_20_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MORE_THAN_10_MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MORE_THAN_10_MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.CHINESE),
                            CuisineOption.getInstance().getDescription(CuisineOption.CHINESE))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("San Soo Gab San is a carnivores dream with Korean tabletop grills in a no-frills atmosphere. The restaurant is also well past midnight, and runs a suburban location in Morton Grove. There’s also a location in River West.")
                    .appendDetail(R.drawable.restaurant10_detail_img1, "Seafood stew")
                    .appendDetail(R.drawable.restaurant10_detail_img2, "Dol-sot bibimbap")
                    .setLocation("5247 N Western Ave, Chicago, IL 60625")
                    .build(),
            new Restaurant.Builder()
                    .setName("Hopleaf Bar")
                    .setCover(R.drawable.restaurant11_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_10_$_20),
                            PriceOption.getInstance().getDescription(PriceOption.$_10_$_20))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("The gold standard for craft beer bars in Chicago, Hopleaf's menu that includes oysters and Montreal-style brisket has something for everyone.")
                    .appendDetail(R.drawable.restaurant11_detail_img1, "Mac and Stilton Cheese")
                    .appendDetail(R.drawable.restaurant11_detail_img2, "So many options!")
                    .setLocation("5148 N Clark St, Chicago, IL 60640")
                    .build(),
            new Restaurant.Builder()
                    .setName("Smoque BBQ")
                    .setCover(R.drawable.restaurant12_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.MORE_THAN_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.MORE_THAN_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("Perhaps the city's best barbecue, eaters venture from far and wide for the acclaimed ribs, pulled pork, brisket, and much more.")
                    .appendDetail(R.drawable.restaurant12_detail_img1, "St. Louis Style Ribs")
                    .appendDetail(R.drawable.restaurant12_detail_img2, "Sliced Brisket w coleslaw and 2 sides")
                    .setLocation("3800 N Pulaski Rd, Chicago, IL 60641")
                    .build(),
            new Restaurant.Builder()
                    .setName("Wood")
                    .setCover(R.drawable.restaurant13_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.LESS_THAN_$_10),
                            PriceOption.getInstance().getDescription(PriceOption.LESS_THAN_$_10))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES1),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES1))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("This Boystown restaurant has fine-dining pedigree and outstanding cocktails.")
                    .appendDetail(R.drawable.restaurant13_detail_img1, "cinnamon roll")
                    .appendDetail(R.drawable.restaurant13_detail_img2, "Spinach Walleye with Risotto")
                    .setLocation("3335 N Halsted St, Chicago, IL 60657")
                    .build(),
            new Restaurant.Builder()
                    .setName("Ceres' Table")
                    .setCover(R.drawable.restaurant14_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.MORE_THAN_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.MORE_THAN_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("The East Lakeview Italian restaurant hasn't lost a step since relocating from further north.")
                    .appendDetail(R.drawable.restaurant14_detail_img1, "Whole Grilled Brazino")
                    .appendDetail(R.drawable.restaurant14_detail_img2, "Flannery")
                    .setLocation("3124 N Broadway, Chicago, IL 60657")
                    .build(),
            new Restaurant.Builder()
                    .setName("Chilam Balam")
                    .setCover(R.drawable.restaurant15_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_10_$_20),
                            PriceOption.getInstance().getDescription(PriceOption.$_10_$_20))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MORE_THAN_10_MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MORE_THAN_10_MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.FAMILIAR))
                    .appendDetail("The creative Mexican restaurant in East Lakeview gets more accolades from the Michelin Guide.")
                    .appendDetail(R.drawable.restaurant15_detail_img1, "Desserts")
                    .appendDetail(R.drawable.restaurant15_detail_img2, "Fried Avocadoes with Lobster Sauce")
                    .setLocation("3023 N Broadway, Chicago, IL 60657")
                    .build(),
            new Restaurant.Builder()
                    .setName("Oriole")
                    .setCover(R.drawable.restaurant16_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.MORE_THAN_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.MORE_THAN_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.LESS_THAN_1_MILE),
                            DistanceOption.getInstance().getDescription(DistanceOption.LESS_THAN_1_MILE))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("2016 saw a slew of great restaurant openings but Noah Sandoval’s West Loop stunner perhaps shined the brightest. He, along with his wife Cara, are leading the way for a new generation of fine dining that’s coupling refined, upscale dishes on its tasting menu, from its caviar starter staple to a Japanese A5 Wagyu, all in a laid-back experience. Critics and diners alike have been impressed, with the Michelin Guide awarding the restaurant two stars in its first year.")
                    .appendDetail(R.drawable.restaurant16_detail_img1, "Malpeque Oyster")
                    .appendDetail(R.drawable.restaurant16_detail_img2, "Dessert")
                    .setLocation("661 W Walnut St, Chicago, IL 60661")
                    .build(),
            new Restaurant.Builder()
                    .setName("Smyth + The Loyalist")
                    .setCover(R.drawable.restaurant17_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_10_$_20),
                            PriceOption.getInstance().getDescription(PriceOption.$_10_$_20))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES1),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES1))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.NEW),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.NEW))
                    .appendDetail("It’s not often that one finds two-Michelin-starred fine dining and one of the country’s best burgers in one place. But that and more are what draw eaters to Smyth and The Loyalist — John and Karen Urie Shields’ bi-level destination in the West Loop where diners are awed by the rural-inspired farm-fueled tasting menus upstairs at the upscale Smyth and the burgers, cocktails, and creative bar food downstairs at The Loyalist. Prepare to make reservations well in advance and open the wallet upstairs ($95-205 depending on the number of courses splurged for), but walk-ins are taken downstairs and one can even sit at the bar.")
                    .appendDetail(R.drawable.restaurant17_detail_img1, "Squab River Mouse")
                    .appendDetail(R.drawable.restaurant17_detail_img2, "Dry Aged Squab")
                    .setLocation("177 N Ada St #101, Chicago, IL 60607")
                    .build(),
            new Restaurant.Builder()
                    .setName("Monteverde")
                    .setCover(R.drawable.restaurant18_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_20_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.$_20_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("The first restaurant from former Top Chef and Spiaggia chef Sarah Grueneberg has quickly cemented itself as one of Chicago’s top Italian destinations and its tough-to-get reservations are a prime example. The pastas are the stars at the West Loop hotspot, such as cannelloni saltimbocca with merguez lamb sausage, manchego cheese, peas, harissa, and balsamico, many of which are made on a small demonstration stage of sorts behind the bar. Also try non-pasta dishes such as the skate wing schnitzel and ‘nduja arancini, as well as a standout wine list.")
                    .appendDetail(R.drawable.restaurant18_detail_img1, "Arrabbiata")
                    .appendDetail(R.drawable.restaurant18_detail_img2, "Spaghetti alla chitarra")
                    .setLocation("1020 W Madison St, Chicago, IL 60607")
                    .build(),
            new Restaurant.Builder()
                    .setName("Manny’s Cafeteria & Delicatessen")
                    .setCover(R.drawable.restaurant19_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_20_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.$_20_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("The torchbearer for a dying breed of Jewish delis and diners in Chicago, Manny’s has endured for more than a half-century in the South Loop thanks to massive and delicious pastrami sandwiches, an array of hot homestyle dishes on steam tables, and family service cultivated over generations in a cafeteria-style setting plastered with decades-old newspaper clippings and letters from Chicago luminaries. The space also now houses a new deli expansion for bagels, sweets, coffee, and food to go.")
                    .appendDetail(R.drawable.restaurant19_detail_img1, "Sandwiches")
                    .appendDetail(R.drawable.restaurant19_detail_img2, "Cookies")
                    .setLocation("1141 S Jefferson St, Chicago, IL 60607")
                    .build(),
            new Restaurant.Builder()
                    .setName("Acadia")
                    .setCover(R.drawable.restaurant20_img)
                    .putHighlight(FilterType.PRICE,
                            PriceOption.getInstance().getIndex(PriceOption.$_20_$_30),
                            PriceOption.getInstance().getDescription(PriceOption.$_20_$_30))
                    .putHighlight(FilterType.DISTANCE,
                            DistanceOption.getInstance().getIndex(DistanceOption.MILES),
                            DistanceOption.getInstance().getDescription(DistanceOption.MILES))
                    .putHighlight(FilterType.CUISINE,
                            CuisineOption.getInstance().getIndex(CuisineOption.AMERICAN),
                            CuisineOption.getInstance().getDescription(CuisineOption.AMERICAN))
                    .putHighlight(FilterType.FAMILIARITY,
                            FamiliarityOption.getInstance().getIndex(FamiliarityOption.KINDA_FAMILIAR),
                            FamiliarityOption.getInstance().getDescription(FamiliarityOption.KINDA_FAMILIAR))
                    .appendDetail("Whether tackling one of the best burgers in town paired with standout cocktails at the bar, indulging in a decadent tasting menu, or satisfying a sweets craving with a creative dessert tasting menu, chef Ryan McCaskey and team are doing it all at Acadia, a destination-worthy experience on an otherwise quiet stretch of the near South Side.")
                    .appendDetail(R.drawable.restaurant20_detail_img1, "Lobster Roll")
                    .appendDetail(R.drawable.restaurant20_detail_img2, "Stoning Lobster")
                    .setLocation("11639 S Wabash Ave, Chicago, IL 60616")
                    .build()

    ));
    private static List<Restaurant> TAKEN = new ArrayList<>();

    public static int reserve(int number) {
        while (TAKEN.size() < number && !RESTAURANTS.isEmpty()) {
            TAKEN.add(RESTAURANTS.remove(RESTAURANTS.size() - 1));
        }
        return TAKEN.size();
    }

    public static void sort(int[] order, SparseIntArray levels) {
        RESTAURANTS.addAll(TAKEN);
        TAKEN.clear();
        RESTAURANTS.sort(Comparator.comparingDouble(r -> {
            final SparseArray<Highlight> highlights = r.getHighlights();
            int weight = 1 << order.length;
            double res = 0;
            for (int type : order) {
                if (type == FilterType.CUISINE) {
                    if (highlights.get(type).level == levels.get(type)) {
                        res += weight;
                    }
                } else {
                    double relativeDiff = Math.abs(highlights.get(type).level - levels.get(type));
                    relativeDiff /= 4;
                    res += weight * (1 - relativeDiff);
                }
                weight >>= 1;
            }
            return res;
        }));
    }

    public static void remove(int i) {
        TAKEN.remove(i);
    }

    public static void removeUntil(int i) {
        if (i >= TAKEN.size()) {
            TAKEN.clear();
        } else {
            TAKEN = new ArrayList<>(TAKEN.subList(i, TAKEN.size()));
        }
    }

    public static Restaurant get(int i) {
        return TAKEN.get(i);
    }

    public static List<Restaurant> getAll() {
        return TAKEN;
    }
}
