package com.cityscholar.cs465.simplefood.options;

import java.util.Arrays;

public class PriceOption extends Option {
    public static final String LESS_THAN_$_10 = "Less than $10";
    public static final String $_10_$_20 = "$10-$20";
    public static final String $_20_$_30 = "$20-$30";
    public static final String MORE_THAN_$_30 = "More than $30";

    private static final String[] OPTIONS = {LESS_THAN_$_10, $_10_$_20, $_20_$_30, MORE_THAN_$_30};
    private static final String[] DESCRIPTION = Arrays.stream(OPTIONS)
            .map(s -> "The average price of food here is " + s.substring(0, 1).toLowerCase() + s.substring(1))
            .toArray(String[]::new);
    private static final PriceOption INSTANCE = new PriceOption(OPTIONS, DESCRIPTION);

    public static PriceOption getInstance() {
        return INSTANCE;
    }

    private PriceOption(String[] options, String[] description) {
        super(options, description);
    }
}
