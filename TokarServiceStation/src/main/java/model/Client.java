package model;

public class Client {


    private long id;

    private String firstName;

    private String secondtName;

    private String phoneNumber;

    private String email;

    private String driverLicenseNumber;

    public Client() {
    }


    public Client(long id, String firstName, String secondtName,
                  String phoneNumber, String email, String driverLicenseNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondtName = secondtName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.driverLicenseNumber = driverLicenseNumber;
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondtName='" + secondtName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                '}';
    }
}
