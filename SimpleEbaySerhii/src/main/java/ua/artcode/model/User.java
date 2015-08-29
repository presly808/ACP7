package ua.artcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends IdEntity{

    @Column
    private String fullname;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pass;

    private String phone;

    // relations between classes
    @OneToMany(mappedBy = "owner")
    private List<Product> products = new LinkedList<>();

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
        products.add(product);
    }

    public List<Product> getList() {
        return products;
    }

    public void setList(List<Product> products) {
        this.products = products;
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
        sb.append("id=").append(getId());
        sb.append(", fullname='").append(fullname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
