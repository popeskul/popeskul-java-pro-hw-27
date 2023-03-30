package org.ithillel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SimpleMathLibraryTest {
    @Test
    public void testAdd() {
        SimpleMathLibrary library = new SimpleMathLibrary();
        double result = library.add(2.0, 3.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testMinus() {
        SimpleMathLibrary library = new SimpleMathLibrary();
        double result = library.minus(3.0, 2.0);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void testExtractAfterLastFour() {
        SimpleMathLibrary math = new SimpleMathLibrary();

        int[] input1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected1 = {1, 7};
        assertArrayEquals(expected1, math.extractAfterLastFour(input1));

        int[] input2 = {1, 2, 4, 4, 2, 3, 4, 1, 7, 4};
        int[] expected2 = {};
        assertArrayEquals(expected2, math.extractAfterLastFour(input2));

        int[] input3 = {4, 4, 4};
        int[] expected3 = {};
        assertArrayEquals(expected3, math.extractAfterLastFour(input3));

        int[] input4 = {1, 2, 3};
        assertThrows(RuntimeException.class, () -> math.extractAfterLastFour(input4));
    }

    @Test
    public void testContainsOnlyOnesAndFours() {
        SimpleMathLibrary math = new SimpleMathLibrary();

        int[] input1 = {1, 1, 1, 4, 4, 1, 4, 4};
        assertTrue(math.containsOnlyOnesAndFours(input1));

        int[] input2 = {1, 1, 1, 1, 1, 1};
        assertFalse(math.containsOnlyOnesAndFours(input2));

        int[] input3 = {4, 4, 4, 4};
        assertFalse(math.containsOnlyOnesAndFours(input3));

        int[] input4 = {1, 4, 4, 1, 1, 4, 3};
        assertFalse(math.containsOnlyOnesAndFours(input4));
    }
}
