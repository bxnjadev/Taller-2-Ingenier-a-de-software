package cl.ucn.ingsoftware.taller2.taller2.model;

public class User {

    private final String name;
    private final int age;
    private final String mail;
    private final String password;

    public User(String name,
                int age,
                String mail,
                String password) {
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

}
