package main.java.net.ju.unibook.dao;

import main.java.net.ju.unibook.entities.*;
import main.java.net.ju.unibook.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalInfoDaoImp implements PersonalInfoDao {

    private final static Database UNIBOOK_DB = new Database("unibook");
    private final static Database RESULT_DB = new Database("result");

    private final String USER_INFO_QUERY = "SELECT * FROM user_info WHERE userId=?";

    public UserInfo getPersonalInfo(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection(RESULT_DB);
            preparedStatement = connection.prepareStatement(USER_INFO_QUERY);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserInfo userInfo = new UserInfo(userId);
                userInfo.setName(new Name(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
                userInfo.setFatherName(new Name(resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)));
                userInfo.setMotherName(new Name(resultSet.getString(8), resultSet.getString(9), resultSet.getString(10)));
                userInfo.setSex(resultSet.getString(11));
                userInfo.setAddress(new Address(resultSet.getString(12), resultSet.getString(13), resultSet.getString(14), resultSet.getString(15), resultSet.getString(16), resultSet.getString(17), resultSet.getString(18)));
                userInfo.setBirthOfDate(new java.util.Date(resultSet.getDate(19).getTime()));
                userInfo.setAge(new Age(resultSet.getInt(20)));
                userInfo.setReligion(resultSet.getString(21));
                userInfo.setNationality(resultSet.getString(22));
                return userInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
        return null;
    }
}
