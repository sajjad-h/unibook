package main.java.net.ju.unibook.dao;

import main.java.net.ju.unibook.entities.Database;
import main.java.net.ju.unibook.entities.Exam;
import main.java.net.ju.unibook.main.Account;
import main.java.net.ju.unibook.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImp implements AccountDao {
    private final static Database UNIBOOK_DB = new Database("unibook");
    private final static Database RESULT_DB = new Database("result");

    private final String EMAIL_QUERY = "SELECT * FROM account WHERE email=?";
    private final String USER_ID_QUERY = "SELECT * FROM account WHERE userId=?";
    private final String LOGIN_QUERY = "SELECT * FROM account WHERE email=? AND password=?";
    private final String UPDATE_QUERY = "UPDATE account SET password=? WHERE email=?";
    private final String VALID_STUDENT_QUERY = "SELECT userId FROM hsc WHERE roll=? AND reg=? AND board=?";
    private final String ADD_ACC_QUERY = "INSERT INTO account (userId, email, password, phone_no) VALUES (?, ?, ?, ?)";

    @Override
    public boolean isUsedEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(UNIBOOK_DB);
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
    public boolean addNewAccount(int userId, String email, String password, String phoneNo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(UNIBOOK_DB);
            preparedStatement = connection.prepareStatement(ADD_ACC_QUERY);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, phoneNo);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return false;
    }

    @Override
    public Account login(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(UNIBOOK_DB);
            preparedStatement = connection.prepareStatement(LOGIN_QUERY);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (new Account(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return null;
    }

    public boolean updatePassword(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getConnection(UNIBOOK_DB);
            preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return false;
    }

    @Override
    public int isValidStudent(Exam exam) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(RESULT_DB);
            preparedStatement = connection.prepareStatement(VALID_STUDENT_QUERY);
            preparedStatement.setString(1, exam.getRoll());
            preparedStatement.setString(2, exam.getReg());
            preparedStatement.setString(3, exam.getBoard());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return -1;
    }

    @Override
    public boolean isRegistered(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(UNIBOOK_DB);
            preparedStatement = connection.prepareStatement(USER_ID_QUERY);
            preparedStatement.setInt(1, userId);
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
}
