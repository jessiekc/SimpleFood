package com.cityscholar.cs465.simplefood.options;

import java.util.Arrays;

public class FamiliarityOption extends Option {
    public static final String FAMILIAR = "Familiar";
    public static final String KINDA_FAMILIAR = "Been to";
    public static final String HEARD_OF = "Seen before";
    public static final String NEW = "New";

    private static final String[] OPTIONS = {FAMILIAR, KINDA_FAMILIAR, HEARD_OF, NEW};
    private static final String[] DESCRIPTION = {"This type of restaurants seems like your go-to choice", "You've been to similar restaurants", "You've seen this restaurants before but never tried", "You've not visited a restaurant like this"};
    private static final FamiliarityOption INSTANCE = new FamiliarityOption(OPTIONS, DESCRIPTION);

    public static FamiliarityOption getInstance() {
        return INSTANCE;
    }

    private FamiliarityOption(String[] options, String[] description) {
        super(options, description);
    }
}
