package ua.artcode.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static boolean isInit = false;
    private static String HOST;
    private static int PORT;
    private static String DB_NAME;
    private static String LOGIN;
    private static String PASS;

    // magic
    private static void init() {
        Properties properties = new Properties();
        try {

            properties.load(
                    new FileInputStream(
                            "/home/serhii/dev/IdeaProjects/ACP7/SimpleEbaySerhii/resources/db.properties"));
            HOST = properties.getProperty("db.host");
            PORT = Integer.parseInt(properties.getProperty("db.port"));
            DB_NAME = properties.getProperty("db.name");
            LOGIN = properties.getProperty("db.user");
            PASS = properties.getProperty("db.pass");
            Class.forName(properties.getProperty("db.driver"));
            isInit = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        if(!isInit){
            synchronized (ConnectionFactory.class){
                if(!isInit){
                    init();
                }
            }
        }

        try {

            return DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, LOGIN, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
