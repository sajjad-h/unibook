package main.java.net.ju.unibook.dao;

import main.java.net.ju.unibook.entities.Exam;
import main.java.net.ju.unibook.main.Account;

public interface AccountDao {
    boolean isUsedEmail(String email);
    boolean addNewAccount(int userId, String email, String password, String phoneNo);
    boolean updatePassword(String email, String password);
    int login(String email, String password);
    int isValidStudent(Exam exam);
    boolean isRegistered(int userId);
}
