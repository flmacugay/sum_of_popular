package com.mac.service;

import java.util.Arrays;

/**
 * A helper class for finding the sum of the most common integer.
 * 
 * @author fmacugay
 */
public class NumberService {

    /**
     * Finds and returns the sum of the most common integer.
     * 
     * @param in
     *            an array of integers
     * @return the sum of the most common integer
     */
    public static int sumOfCommonInteger(int[] in) {

        if (in == null || in.length == 0) {
            return 0;
        } else if (in.length == 1) {
            return in[0];
        }

        Arrays.sort(in);

        int count = 0;
        int maxCount = 0;
        int previous = in[0];
        int popular = 0;

        for (int num : in) {
            if (num != previous) {
                if (count > maxCount) {
                    maxCount = count;
                    popular = previous;
                }

                previous = num;
                count = 0;
            }

            count++;
        }

        // handle last group of elements
        if (count > maxCount) {
            maxCount = count;
            popular = previous;
        }

        return maxCount * popular;
    }

    /**
     * Converts a {@link String} array to a primitive integer array
     * 
     * @param array
     * @return
     * @throws IllegalArgumentException
     */
    public static int[] toPrimitiveInt(String[] array) throws IllegalArgumentException {
        int[] intarray = new int[array.length];
        int i = 0;
        for (String str : array) {
            try {
                intarray[i] = Integer.parseInt(str);
                i++;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Not a number: " + str + " at index " + i, e);
            }
        }
        return intarray;
    }

    public static void main(String[] args) {

        int[] in = null;
        try {
            in = toPrimitiveInt(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        int sum = sumOfCommonInteger(in);

        System.out.println(sum);

    }
}
