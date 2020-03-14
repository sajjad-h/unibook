package main.java.net.ju.unibook.dao;

import main.java.net.ju.unibook.entities.*;
import main.java.net.ju.unibook.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDaoImp {
    private final static Database UNIBOOK_DB = new Database("unibook");
    private final static Database RESULT_DB = new Database("result");

    private final static String GET_SSC_RESULT = "SELECT * FROM ssc WHERE userId=?";
    private final static String GET_HSC_RESULT = "SELECT * FROM hsc WHERE userId=?";

    public Result getResultInfo(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Exam ssc = new Exam(userId, "SSC");
        Exam hsc = new Exam(userId, "HSC");
        try {
            connection = ConnectionManager.getConnection(RESULT_DB);
            preparedStatement = connection.prepareStatement(GET_SSC_RESULT);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ssc.setRoll(resultSet.getString(2));
                ssc.setReg(resultSet.getString(3));
                ssc.setBoard(resultSet.getString(4));
                ssc.setPassingYear(resultSet.getInt(5));
                ssc.setGpa(resultSet.getDouble(6));
                ssc.setStatus(resultSet.getString(7));
                ssc.setGroup(resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }

        try {
            connection = ConnectionManager.getConnection(RESULT_DB);
            preparedStatement = connection.prepareStatement(GET_HSC_RESULT);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                hsc.setRoll(resultSet.getString(2));
                hsc.setReg(resultSet.getString(3));
                hsc.setBoard(resultSet.getString(4));
                hsc.setPassingYear(resultSet.getInt(5));
                hsc.setGpa(resultSet.getDouble(6));
                hsc.setStatus(resultSet.getString(7));
                hsc.setGroup(resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return (new Result(ssc, hsc));
    }
}
