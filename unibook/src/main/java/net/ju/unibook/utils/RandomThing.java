package main.java.net.ju.unibook.utils;

public class RandomThing {
    public static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE = "abcdefghijklmnopqrstuvxyz";
    public static final String NUMERIC = "0123456789";
    public static final String ALPHA_NUMERIC = UPPER_CASE + NUMERIC + LOWER_CASE;

    public static String getAlphaNumericString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = (int) (ALPHA_NUMERIC.length() * Math.random());
            sb.append(ALPHA_NUMERIC.charAt(index));
        }
        return sb.toString();
    }
}
