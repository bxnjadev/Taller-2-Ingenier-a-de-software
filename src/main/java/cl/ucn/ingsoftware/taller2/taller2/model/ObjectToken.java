package cl.ucn.ingsoftware.taller2.taller2.model;

/**
 * This class is a wrapper class that contains a authorization token
 */

public class ObjectToken {

    private final String token;

    public ObjectToken(String token) {
        this.token = token;
    }

    /**
     * Return a string that represent a authorization token
     * @return the token
     */

    public String getToken() {
        return token;
    }

    /**
     *
     * "[ token = aaa3f ]"
     */

    @Override
    public String toString() {
        return String.format(
                "[ token = %s ]",
                token
        );
    }
}

