package model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends IdEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondtName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column
    private String email;
    @Column(nullable = false)
    private String driverLicenseNumber;

    public Client() {
    }


    public Client(String firstName, String secondtName,
                  String phoneNumber, String email, String driverLicenseNumber) {

        this.firstName = firstName;
        this.secondtName = secondtName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.driverLicenseNumber = driverLicenseNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", secondtName='" + secondtName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                '}';
    }
}
