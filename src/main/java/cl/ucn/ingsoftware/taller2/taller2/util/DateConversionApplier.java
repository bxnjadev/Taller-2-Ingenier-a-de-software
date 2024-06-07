package cl.ucn.ingsoftware.taller2.taller2.util;

public class DateConversionApplier {

    private static final long MOUTH_TO_MILLISECONDS = 2629746000L;

    private DateConversionApplier() {

    }

    public static long mouthToMilliseconds(int mouths) {
        return MOUTH_TO_MILLISECONDS * mouths;
    }

}
