package model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true, nullable=false)
    private String fullname;
    @Column(unique=true, nullable=false)
    private String email;
    @Column(nullable=false)
    private String pass;
    @Column(unique=true, nullable=false)
    private String phone;
    @Column(nullable=false)
    private String rank;
    @Column(unique=true, nullable=false)
    private String login;
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients = new ArrayList<Patient>();

    public User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public User(String fullname, String rank, String email, String phone, String login, String pass) {
        this.fullname = fullname;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.pass = pass;
    }

    public void addPatient(Patient patient){
        patients.add(patient);
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "fullname='" + fullname + '\'' +
                ", rank='" + rank + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
