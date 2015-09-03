package model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "assistance's")
public class Assistant extends IdEntity{

    @Column(unique=true, nullable=false)
    private String fullName;
    @Column(nullable=false)
    private String rank;
    @OneToMany(mappedBy = "assistant")
    private ArrayList<Patient> patients;

    public Assistant() {
    }

    public Assistant(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

}
