package main.java.net.ju.unibook.main;

import main.java.net.ju.unibook.dao.PersonalInfoDao;
import main.java.net.ju.unibook.entities.Age;
import main.java.net.ju.unibook.entities.Result;
import main.java.net.ju.unibook.entities.UserInfo;
import main.java.net.ju.unibook.services.PersonalInfoService;
import main.java.net.ju.unibook.services.PersonalInfoServiceImp;
import main.java.net.ju.unibook.services.ResultServiceImp;
import main.java.net.ju.unibook.utils.UserInput;
import main.java.net.ju.unibook.utils.UserInterface;

public class Account {
    private int userId;
    private String email;
    private String phoneNo;
    private UserInfo userInfo;
    private Result result;

    private PersonalInfoServiceImp personalInfoServiceImp;
    private ResultServiceImp resultServiceImp;

    public Account(int userId, String email, String phoneNo) {
        this.userId = userId;
        this.email = email;
        this.phoneNo = phoneNo;
        this.userInfo = new UserInfo(userId);

        personalInfoServiceImp = new PersonalInfoServiceImp();
        resultServiceImp = new ResultServiceImp();
    }

    public Account(int userId, String email, String phoneNo, UserInfo userInfo, Result result) {
        this.userId = userId;
        this.email = email;
        this.phoneNo = phoneNo;
        this.userInfo = userInfo;
        this.result = result;

        personalInfoServiceImp = new PersonalInfoServiceImp();
        resultServiceImp = new ResultServiceImp();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void loadUserInfo() {
        this.setUserInfo(personalInfoServiceImp.getPersonalInfo(this.userId));
        getAge();
    }

    public void getAge() {
        long now;
        long pre;
        int years;
        int months;
        int days;
        long totalDays;
        long totalSeconds;
        now = System.currentTimeMillis();
        pre = userInfo.getBirthOfDate().getTime();
        totalSeconds = (now - pre) * 1000;
        totalDays = totalSeconds / (24 * 3600);
        years = (int) (totalDays / 365);
        days = (int) (totalDays % 365);
        months = (int) (days / 30);
        days = days % 30;
        userInfo.setAge(new Age(years, months, days, totalDays, totalSeconds));
    }

    public void loadResultInfo() {
        this.setResult(resultServiceImp.getResultInfo(this.userId));
    }

    public void run() {
        loadUserInfo();
        loadResultInfo();
        int option = 0;
        boolean loggedIn = true;
        do {
            UserInterface.showHeader("Welcome to University Admission System");
            UserInterface.showMsg("Logged in with", 1);
            UserInterface.showMsg( "(" + email + ")", 1);

            UserInterface.showUserStartMenu();
            option = UserInput.getInstance().inputOption();

            switch (option) {
                case 7:
                    loggedIn = false;
                    break;
            }
        }
        while (loggedIn);
        UserInterface.showMsg("Successfully Logged Out!");
    }
}
