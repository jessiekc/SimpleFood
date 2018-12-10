package com.cityscholar.cs465.simplefood.options;

import java.util.Arrays;

public class FamiliarityOption extends Option {
    public static final String FAMILIAR = "familiar";
    public static final String KINDA_FAMILIAR = "kinda familiar";
    public static final String NEW = "new";

    private static final String[] OPTIONS = {FAMILIAR, KINDA_FAMILIAR, NEW};
    private static final String[] DESCRIPTION = {"This type of restaurants seems like your go-to choice", "You've been to similar restaurants", "You've not visited a restaurant like this"};
    private static final FamiliarityOption INSTANCE = new FamiliarityOption(OPTIONS, DESCRIPTION);

    public static FamiliarityOption getInstance() {
        return INSTANCE;
    }

    private FamiliarityOption(String[] options, String[] description) {
        super(options, description);
    }
}
