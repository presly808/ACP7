package ua.artcode.week5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pikolo on 09.08.15.
 */
public class TestSimpleConnection {

    //Connection - holds connection to DB
    //Statement - communicate with DB
    //PreparedStatement - other kind of statement, precompiled
    //ResultSet - store res of certain request(SQL)
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //external lib ()
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/acp7", "root", "root");

        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT * FROM users");

        ResultSet rs = statement.executeQuery("SELECT * FROM users");

    }
}
