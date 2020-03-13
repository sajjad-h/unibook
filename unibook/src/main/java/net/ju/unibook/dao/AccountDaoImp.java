package main.java.net.ju.unibook.dao;

import main.java.net.ju.unibook.entities.Database;
import main.java.net.ju.unibook.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImp implements AccountDao {
    private final static Database unibookDB = new Database("unibook");
    private final static Database resultDB = new Database("result");

    private final String EMAIL_QUERY = "SELECT * FROM account WHERE email=?";
    private final String LOGIN_QUERY = "SELECT * FROM account WHERE email=? AND password=?";

    @Override
    public boolean isUsedEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(unibookDB);
            preparedStatement = connection.prepareStatement(EMAIL_QUERY);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return false;
    }

    @Override
    public boolean addNewAccount(String email, String password) {
        return false;
    }

    @Override
    public int login(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(unibookDB);
            preparedStatement = connection.prepareStatement(LOGIN_QUERY);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return -1;
    }
}
