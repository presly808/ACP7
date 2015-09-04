package model;


public class Head extends Doctor{

    public Head() {
    }

    public Head(String login, String pass) {
        super(login, pass);
    }

    public Head(String fullname, String position, String email, String phone, String login, String pass) {
        super(fullname, position, email, phone, login, pass);
    }
}
