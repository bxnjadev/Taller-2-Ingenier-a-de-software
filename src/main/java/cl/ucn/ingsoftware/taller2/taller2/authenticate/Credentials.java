package cl.ucn.ingsoftware.taller2.taller2.authenticate;

public class Credentials {

    private final String mail;
    private final String password;

    public Credentials(String mail,
                       String password) {
        this.mail = mail;
        this.password = password;

    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

}
