package week1.myHashMap;

/**
 * Created by Джек on 03.07.2015.
 */
public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null)
            return false;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (age != user.getAge()) return false;
        if (name != null ? !name.equals(user.getName()) : user.getName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
       result = getName() != null ? getName().hashCode() : 0;
        result = PRIME * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}