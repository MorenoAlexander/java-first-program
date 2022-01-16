package com.h2;

public class Utilities {
    public static long getLongValue(String in) {
        long out = Long.MIN_VALUE;
        try {
            out = Long.parseLong(in);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException(in, "long");
        }
        return out;
    }

    public static int getIntValue(String in) {
        int out = Integer.MIN_VALUE;
        try {
            out = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException(in, "int");
        }
        return out;
    }

    private static void throwIllegalArgumentException(String in, String type) {
        throw new IllegalArgumentException(in + " cannot be converted into a '" + type + "' value. Exiting program.");
    }

    public static float getFloatValue(String in) {
        float out = Float.MIN_VALUE;
        try {
            out = Float.parseFloat(in);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException(in, "float");
        }
        return out;
    }
}
