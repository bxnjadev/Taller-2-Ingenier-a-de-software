package cl.ucn.ingsoftware.taller2.taller2.util;

import java.util.Random;

public class Identifiers {

    private static final int DEFAULT_LENGTH = 8;
    private static final Random RANDOM = new Random();

    private Identifiers() {
        throw new IllegalArgumentException();
    }

    /**
     * Generate numerical id random based in a length
     * This id no start with zero value
     * @param length the length id
     * @return the random id
     */

    public static int newId(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        int stop = 9;

        for (int i = 0; i < length; i++) {
            int start = 0;

            if (i == 0) {
                start = 1;
            }

            int value = RANDOM.nextInt(start, stop);
            stringBuilder.append(
                    value
            );
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    /**
     * Generate numerical id random based
     * This id no start with zero value
     * @return the random id
     */

    public static int newId() {
        return newId(DEFAULT_LENGTH);
    }


}
