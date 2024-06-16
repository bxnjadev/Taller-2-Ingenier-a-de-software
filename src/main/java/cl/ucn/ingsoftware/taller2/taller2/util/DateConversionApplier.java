package cl.ucn.ingsoftware.taller2.taller2.util;

public class DateConversionApplier {

    private static final long MOUTH_TO_MILLISECONDS = 2629746000L;

    private DateConversionApplier() {
        throw new IllegalArgumentException();
    }

    /**
     * This method is a simple conversion between mouths and seconds
     * @param mouths the quantity mouths
     * @return the quantity seconds
     */

    public static long mouthToMilliseconds(int mouths) {
        return MOUTH_TO_MILLISECONDS * mouths;
    }

}
