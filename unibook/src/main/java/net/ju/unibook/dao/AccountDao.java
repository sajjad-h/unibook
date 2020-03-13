package main.java.net.ju.unibook.dao;

public interface AccountDao {
    boolean isUsedEmail(String email);
    boolean addNewAccount(String email, String password);
    boolean updatePassword(String email, String password);
    int login(String email, String password);
}
