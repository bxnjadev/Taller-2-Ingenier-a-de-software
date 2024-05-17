package cl.ucn.ingsoftware.taller2.taller2.authenticate;

public interface AuthenticatorFactory {

    Authenticator get(AuthenticatorType type);

}
