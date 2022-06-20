package com.sheva.util;

import java.util.Random;

public class InfoGeneration {

    public static int generatorID() {

        /* This is an ID number generation from six numbers. */

        int minValue = 100000;
        int maxValue = 999999;

        return new Random().nextInt(minValue, maxValue);
    }

    public static int orderNumberGenerator() {

        /* This is an order number generation from four numbers. */

        int minValue = 1000;
        int maxValue = 9999;

        return new Random().nextInt(minValue, maxValue);
    }

    public static String nameGenerator() {

        return InputInfo.getRandomStringFromFile("names.txt");
    }

    public static String surnameGenerator() {
        return InputInfo.getRandomStringFromFile("surnames.txt");
    }

    public static String orderNameGenerator() {
        return InputInfo.getRandomStringFromFile("products.txt");
    }


}
