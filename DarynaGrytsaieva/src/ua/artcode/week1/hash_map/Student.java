package ua.artcode.week1.hash_map;

/**
 * Created by Daryna on 07-Jul-15.
 */
public class Student {
    String firstName;
    String lastName;


    public Student(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || !(other instanceof Student)) {
            return false;
        }
        Student std = (Student) other;
        if ((firstName.equals(std.getFirstName()) && (lastName.equals(std.getLastName())))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "" + firstName + " " + lastName;
    }
}
