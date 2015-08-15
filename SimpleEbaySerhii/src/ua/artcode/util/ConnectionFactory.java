package ua.artcode.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by serhii on 15.08.15.
 */
public class ConnectionFactory {

    private static String HOST;
    private static int PORT;
    private static String DB_NAME;
    private static String LOGIN;
    private static String PASS;

    // magic
    static {
        Properties properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("/home/serhii/dev/IdeaProjects/ACP7/SimpleEbaySerhii/resources/db.properties"));
            HOST = properties.getProperty("db.host");
            PORT = Integer.parseInt(properties.getProperty("db.port"));
            DB_NAME = properties.getProperty("db.name");
            LOGIN = properties.getProperty("db.user");
            PASS = properties.getProperty("db.pass");
            Class.forName(properties.getProperty("db.driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, LOGIN, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
