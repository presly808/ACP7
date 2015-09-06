package model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor extends IdEntity{

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;*/

    @Column(unique=true, nullable=false)
    private String fullName;
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

    public Doctor() {
    }

    public Doctor(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Doctor(String fullName, String rank, String email, String phone, String login, String pass) {
        this.fullName = fullName;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.pass = pass;
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    /*public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    @Override
    public String toString() {
        return "Doctor{" +
                "fullName='" + fullName + '\'' +
                ", rank='" + rank + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
