package main.java.net.ju.unibook.services;

import main.java.net.ju.unibook.entities.Exam;
import main.java.net.ju.unibook.main.Account;

public interface AccountService {
    boolean isUsedEmail(String email);
    int isValidStudent(Exam exam);
    boolean isRegistered(int userId);
    boolean addNewAccount(int userId, String email, String password, String phoneNo);
    boolean forgotPassword(String email, String password);
    void sendEmail(String email, String code) throws Exception;
    Account login(String email, String password);
}
