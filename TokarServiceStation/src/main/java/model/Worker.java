package model;

import javax.persistence.*;

@Entity
@Table(name = "workers")
public class Worker  extends IdEntity{
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    @Column(nullable = false)
    private long salary;
    private boolean workStatusBusy = true;

    public Worker() {
    }

    public Worker(String firstName, String secondtName,
                  long salary, boolean workStatusBusy) {
        this.firstName = firstName;
        this.secondName = secondtName;
        this.salary = salary;
        this.workStatusBusy = workStatusBusy;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondtName(String secondtName) {
        this.secondName = secondtName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public boolean isWorkStatusBusy() {
        return workStatusBusy;
    }

    public void setWorkStatusBusy(boolean workStatusBusy) {
        this.workStatusBusy = workStatusBusy;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", secondtName='" + secondName + '\'' +
                ", salary=" + salary +
                ", workStatusBusy=" + workStatusBusy +
                '}';
    }
}
