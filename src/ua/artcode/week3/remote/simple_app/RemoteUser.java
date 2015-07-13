package ua.artcode.week3.remote.simple_app;

/**
 * Created by serhii on 12.07.15.
 */
public class RemoteUser implements Comparable<RemoteUser> {

    private String ip;
    private final String login;
    private String pass;


    public RemoteUser(String ip, String login, String pass) {
        this.ip = ip;
        this.login = login;
        this.pass = pass;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogin() {
        return login;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RemoteUser{");
        sb.append("ip='").append(ip).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", pass='").append(pass).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteUser that = (RemoteUser) o;


        return login != null ? login.equals(that.login) : that.login == null;

    }

    @Override
    public int compareTo(RemoteUser o) {
        return login.compareTo(o.login);
    }
}
