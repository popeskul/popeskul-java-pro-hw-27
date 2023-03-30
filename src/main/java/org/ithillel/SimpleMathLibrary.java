package org.ithillel;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleMathLibrary {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 4;
    public static final String ARRAY_DOES_NOT_CONTAIN = "Array does not contain %d";

    public double add(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public int[] extractAfterLastFour(int[] arr) {
        int index = IntStream.rangeClosed(LOWER_BOUND, arr.length)
                .map(i -> arr.length - i)
                .filter(i -> arr[i] == UPPER_BOUND)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format(ARRAY_DOES_NOT_CONTAIN, UPPER_BOUND)));

        return Arrays.copyOfRange(arr, index + LOWER_BOUND, arr.length);
    }

    public boolean containsOnlyOnesAndFours(int[] arr) {
        return Arrays.stream(arr).allMatch(n -> n == LOWER_BOUND || n == UPPER_BOUND)
                && Arrays.stream(arr).anyMatch(n -> n == LOWER_BOUND)
                && Arrays.stream(arr).anyMatch(n -> n == UPPER_BOUND);
    }
}
