package ua.artcode.ClassWork.Week_5;

import java.sql.*;

/**
 * Created by serhii on 09.08.15.
 */
public class TestSimpleConnection {

    // Connection - holds connection to db
    // Statement - communicate with db
    // PreparedStatement - other kind of statement, precompiled
    // ResultSet - store res of certain request(SQL)
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        // external lib ()
        // 1. Load Driver(Class helps us to make connetion)

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/acp7",
                "root","root");

        Statement statement = connection.createStatement();

        // like an iterator
        ResultSet rs = statement.executeQuery("SELECT name,contact,age,dep_id FROM users");
        /*System.out.printf("%s,%s,%s,%s\n",
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4));*/
        System.out.printf("NAME");
        while(rs.next()){
            System.out.printf("%s,%s,%d,%d\n",
                    rs.getString("name"),
                    rs.getString("contact"),
                    rs.getInt("age"),
                    rs.getInt("dep_id"));
        }


    }

}
