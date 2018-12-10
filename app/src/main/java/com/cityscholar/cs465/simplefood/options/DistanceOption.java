package com.cityscholar.cs465.simplefood.options;

import java.util.Arrays;

public class DistanceOption extends Option {
    public static final String LESS_THAN_1_MILE = "Less than 1 mile";
    public static final String MILES = "1-5 miles";
    public static final String MILES1 = "5-10 miles";
    public static final String MORE_THAN_10_MILES = "More than 10 miles";

    private static final String[] OPTIONS = {LESS_THAN_1_MILE, MILES, MILES1, MORE_THAN_10_MILES};
    private static final String[] DESCRIPTION = Arrays.stream(OPTIONS)
            .map(s -> "This restaurants is " + s.substring(0, 1).toLowerCase() + s.substring(1))
            .toArray(String[]::new);
    private static final DistanceOption INSTANCE = new DistanceOption(OPTIONS, DESCRIPTION);

    public static DistanceOption getInstance() {
        return INSTANCE;
    }

    private DistanceOption(String[] options, String[] description) {
        super(options, description);
    }
}
