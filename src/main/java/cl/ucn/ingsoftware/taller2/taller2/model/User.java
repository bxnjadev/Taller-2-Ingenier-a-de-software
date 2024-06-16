package cl.ucn.ingsoftware.taller2.taller2.model;

import java.util.Objects;

/**
 * This is a value class that represent a user of service
 */

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

    /**
     * Return a representation the name as string
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * Return the age user, this value cannot be zero or a negative number
     * @return the age
     */

    public int getAge() {
        return age;
    }

    /**
     * Return the user mail, this mail can be followed the next format
     * ["name@domain"]
     * @return the mail
     */

    public String getMail() {
        return mail;
    }

    /**
     * Return the password user, this password cannot be empty
     * @return the password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Return the rol type user
     * @return the rol
     */

    public RolType getRolType() {
        return rolType;
    }

    /**
     * Return the quantity accumulate points, this points cannot be zero or negative
     * @return the quantity points
     */

    public int getPoints() {
        return points;
    }

    /**
     * Add points
     * @param points the points for add
     */

    public void addPoints(int points) {
        setPoints(this.points + points);
    }

    /**
     * Remove points
     * @param points the points for remove
     */

    public void removePoints(int points) {
        setPoints(this.points - points);
    }

    private void setPoints(int points) {
        if (points < 0) {
            return;
        }

        this.points = points;
    }

    /**
     * Calculate the hash code
     * @return the hash code
     */

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(age);
        result = 31 * result + mail.hashCode();
        result = 31 * result + Objects.hashCode(rolType);
        result = 31 * result + Integer.hashCode(points);

        return result;
    }

    /**
     * Compare if two services are equals
     * @param obj the object service
     * @return true if is equals
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof User user)) {
            return false;
        }

        return user.name.equals(name) &&
                user.password.equals(password) &&
                user.points == points &&
                user.age == age &&
                user.rolType == rolType;
    }


    /**
     * Return a brief description of this credit card, the exact details
     * of the representation are unspecified and subjects change,
     * but the following be regarded as typical:
     * "[ = 5652354345 mouth = 3, code = 56532345, year = 3]"
     */

    @Override
    public String toString() {
        return String.format(
                "[name = %s, age = %d, mail = %s, password = %s, rolType = %s, points = %d]",
                name,
                age,
                mail,
                password,
                rolType.toString(),
                points
        );
    }

}
