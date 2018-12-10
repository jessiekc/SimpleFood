package com.cityscholar.cs465.simplefood.options;

import java.util.Arrays;

public class CuisineOption extends Option {
    public static final String CHINESE = "Chinese";
    public static final String MEXICAN = "Mexican";
    public static final String THAI = "Thai";
    public static final String MEDITERRANEAN = "Mediterranean";
    public static final String AMERICAN = "American";
    public static final String INDIAN = "indian";

    private static final String[] OPTIONS = {CHINESE, MEXICAN, THAI, MEDITERRANEAN, AMERICAN, INDIAN};
    private static final String[] DESCRIPTION = Arrays.stream(OPTIONS)
            .map(s -> "This is a " + s + " restaurants")
            .toArray(String[]::new);
    private static final CuisineOption INSTANCE = new CuisineOption(OPTIONS, DESCRIPTION);

    public static CuisineOption getInstance() {
        return INSTANCE;
    }

    private CuisineOption(String[] options, String[] description) {
        super(options, description);
    }
}
