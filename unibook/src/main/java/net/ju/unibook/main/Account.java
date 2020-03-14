package main.java.net.ju.unibook.main;

import main.java.net.ju.unibook.entities.Result;
import main.java.net.ju.unibook.entities.UserInfo;
import main.java.net.ju.unibook.utils.UserInput;
import main.java.net.ju.unibook.utils.UserInterface;

public class Account {
    private int userId;
    private String email;
    private String phoneNo;
    private UserInfo userInfo;
    private Result result;

    public Account(int userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public void run() {
        UserInterface.showHeader("Welcome to University Admission System");
        UserInterface.showMsg("Logged in with", 1);
        UserInterface.showMsg( "(" + email + ")", 1);
        System.out.println("Ha ha hi hi\n");
        int option = UserInput.getInstance().inputInteger();
    }

}
