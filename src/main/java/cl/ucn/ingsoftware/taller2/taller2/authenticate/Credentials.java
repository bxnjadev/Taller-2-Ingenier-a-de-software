package cl.ucn.ingsoftware.taller2.taller2.authenticate;

public class Credentials {

    private final String identifier;
    private final String password;

    public Credentials(String identifier,
                       String password) {
        this.identifier = identifier;
        this.password = password;

    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }

}
