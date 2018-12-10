package com.cityscholar.cs465.simplefood.options;

public class Option {
    private final String[] options;
    private final String[] description;

    Option(String[] options, String[] description) {
        this.options = options;
        this.description = description;
    }

    public static int getIndex(String filter, String option) {
        Option queried = getOptionInstance(filter);
        return queried.getIndex(option);
    }

    public static String getDefault(String filter) {
        return getOptionInstance(filter).getDefault();
    }

    private static Option getOptionInstance(String filter) {
        switch (filter) {
            case "filter1":
                return PriceOption.getInstance();
            case "filter2":
                return DistanceOption.getInstance();
            case "filter3":
                return CuisineOption.getInstance();
            case "filter4":
                return FamiliarityOption.getInstance();
            default:
                throw new IllegalArgumentException("No such filter");
        }
    }

    public String[] getAll() {
        return options;
    }

    public int getIndex(String option) {
        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(option)) {
                return i;
            }
        }
        throw new IllegalArgumentException("No such option!");
    }

    public String getDescription(String option) {
        return description[getIndex(option)];
    }

    public String getDefault() {
        return options[0];
    }
}
