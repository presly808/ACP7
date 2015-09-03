package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Entity
@Table(name = "patients")
public class Patient extends IdEntity{

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;*/
    @Column(unique=true, nullable=false)
    private String fullName;

    @Column(nullable=false)
    private int age;
    private int birthYear;
    private boolean isConsultation;
    private String town;
    private String sex;
    private String diagnosis;
    private String histoType;
    private String localization;
    private String operation;
    /*@OneToMany(mappedBy = "diagnose")
    private ImmunohistochemicalResearch IhcDiagnosis;*/
    private long prepayment;
    private boolean isPayed;
    @Column
    private Date start;
    private Date finish;

    @ManyToOne
    @JoinColumn(name = "assistant_id", referencedColumnName = "id")
    private Assistant assistant;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    public Patient() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /*public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isConsultation() {
        return isConsultation;
    }

    public void setConsultation(boolean isConsultation) {
        this.isConsultation = isConsultation;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getHistoType() {
        return histoType;
    }

    public void setHistoType(String histoType) {
        this.histoType = histoType;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public long getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(long prepayment) {
        this.prepayment = prepayment;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }
}
