package DBTest;

import com.mysql.jdbc.Connection;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSimpleConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.fabric.jdbc.Driver");

       Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/acp7", "root", "root");
        Statement statement = (Statement) connection.createStatement();
    }
}
