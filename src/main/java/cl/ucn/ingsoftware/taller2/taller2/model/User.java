package cl.ucn.ingsoftware.taller2.taller2.model;

public class User {

    private final String name;
    private final int age;
    private final String mail;
    private final String password;
    private final RolType rolType;
    private int points;

    public User(String name,
                int age,
                String mail,
                String password,
                RolType rolType,
                int points) {
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.password = password;
        this.rolType = rolType;
        this.points = points;
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

    public RolType getRolType() {
        return rolType;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        setPoints(this.points + points);
    }

    public void removePoints(int points) {
        setPoints(this.points - points);
    }

    private void setPoints(int points) {
        if (points < 0) {
            return;
        }

        this.points = points;
    }


}
