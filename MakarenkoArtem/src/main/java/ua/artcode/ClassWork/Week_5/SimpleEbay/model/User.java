package ua.artcode.ClassWork.Week_5.SimpleEbay.model;

import java.util.LinkedList;
import java.util.List;

public class User {

    private long id;
    private String fullname;
    private String email;
    private String pass;
    private String phone;
    private List<Product> list = new LinkedList<>();

    public User() {
    }

    public User(String fullname, String pass, String phone) {
        this.fullname = fullname;
        this.pass = pass;
        this.phone = phone;
    }

    public User(String fullname, String email, String pass, String phone) {
        this.fullname = fullname;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public void addProduct(Product product){
        list.add(product);
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", fullname='").append(fullname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
