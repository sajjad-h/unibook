package main.java.net.ju.unibook.dao;

import main.java.net.ju.unibook.entities.UserInfo;

public interface PersonalInfoDao {
    UserInfo getPersonalInfo(int userId);
}
