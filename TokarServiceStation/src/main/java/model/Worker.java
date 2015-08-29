package model;

import java.math.BigInteger;

public class Worker {

    private long id;

    private String firstName;

    private String secondtName;

    private long salary;

    private boolean workStatusBusy = true;

    public Worker() {
    }

    public Worker(String firstName, String secondtName,
                  long salary, boolean workStatusBusy) {
        this.firstName = firstName;
        this.secondtName = secondtName;
        this.salary = salary;
        this.workStatusBusy = workStatusBusy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondtName() {
        return secondtName;
    }

    public void setSecondtName(String secondtName) {
        this.secondtName = secondtName;
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondtName='" + secondtName + '\'' +
                ", salary=" + salary +
                ", workStatusBusy=" + workStatusBusy +
                '}';
    }
}
