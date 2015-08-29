package ua.artcode.ArtemProject.Model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by HOME on 21.08.2015.
 */
public class User {

    private String name;
    private String pasword;
    private String email;
    private long id;
    private List <Prod> list = new LinkedList<Prod>();


    public User(String name, String pasword, String email) {
        this.name = name;
        this.pasword = pasword;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Prod> getList() {
        return list;
    }

    public void setList(List<Prod> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pasword='" + pasword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
