package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date birthYear;
    @Column(nullable=false)
    private boolean isConsultation;
    @Column(nullable=false)
    private String town;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
    @Column(nullable=false)
    private String sex;
    @Column(nullable=false)
    private String diagnosis;
    @Column(nullable=false)
    private String histoType;
    @OneToOne
    private Localization localization;
    @Column(nullable=false)
    private String operation;
    @OneToMany(mappedBy = "diagnose")
    //@JoinColumn(name = "immunohistochemical_research_id", referencedColumnName = "id")
    private List<ImmunohistochemicalResearch> IhcDiagnosis = new ArrayList<>();
    //private ImmunohistochemicalResearch IhcDiagnosis;
    @Column
    private long prepayment;
    @Column(nullable=false)
    private boolean isPayed;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date start;
    @Column
    @Temporal(value = TemporalType.DATE)
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

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
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

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<ImmunohistochemicalResearch> getIhcDiagnosis() {
        return IhcDiagnosis;
    }

    public void setIhcDiagnosis(List<ImmunohistochemicalResearch> ihcDiagnosis) {
        IhcDiagnosis = ihcDiagnosis;
    }
}
