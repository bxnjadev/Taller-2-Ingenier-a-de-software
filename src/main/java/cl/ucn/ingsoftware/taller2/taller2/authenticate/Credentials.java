package cl.ucn.ingsoftware.taller2.taller2.authenticate;

/**
 * This class are credentials for manage a authentication system
 */

public class Credentials {

    private final String identifier;
    private final String password;

    public Credentials(String identifier,
                       String password) {
        this.identifier = identifier;
        this.password = password;

    }

    /**
     * Get the identifier, the identifier can be a user, a mail or other data type
     *
     * @return the identifier
     */

    public String getIdentifier() {
        return identifier;
    }

    /**
     * Get the password
     *
     * @return the password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Return a brief description of this credit card, the exact details
     * of the representation are unspecified and subjects change,
     * but the following be regarded as typical:
     * "[number = 5652354345, mouth = 3, code = 56532345, year = 2027]"
     */

    @Override
    public String toString() {
        return String.format(
                "[identifier = %s, password = %s]",
                identifier,
                password
        );
    }

}
