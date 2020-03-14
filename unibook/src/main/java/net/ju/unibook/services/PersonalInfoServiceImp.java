package main.java.net.ju.unibook.services;

import main.java.net.ju.unibook.dao.PersonalInfoDaoImp;
import main.java.net.ju.unibook.entities.UserInfo;

public class PersonalInfoServiceImp implements PersonalInfoService {
    private PersonalInfoDaoImp personalInfoDaoImp;

    public PersonalInfoServiceImp() {
        personalInfoDaoImp = new PersonalInfoDaoImp();
    }

    @Override
    public UserInfo getPersonalInfo(int userId) {
        return personalInfoDaoImp.getPersonalInfo(userId);
    }
}
