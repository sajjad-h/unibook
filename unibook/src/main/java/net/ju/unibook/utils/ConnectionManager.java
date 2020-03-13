package main.java.net.ju.unibook.utils;

import main.java.net.ju.unibook.entities.Database;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionManager {
    public static Connection getConnection(Database db)
    {
        Connection connection = null;
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(db.getDbProperties());
            properties.load(fileInputStream);

            String driverClass = properties.getProperty("DB_DRIVER_CLASS");
            String dbUrl = properties.getProperty("DB_URL");
            String dbUser = properties.getProperty("DB_USERNAME");
            String dbPass = properties.getProperty("DB_PASS");

            Class.forName(driverClass);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println(db.getDbName() + " Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        ConnectionManager.getConnection(new Database("result"));
//        ConnectionManager.getConnection(new Database("unibook"));
//    }
}
