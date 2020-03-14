package main.java.net.ju.unibook.services;

public interface AccountService {
    boolean isUsedEmail(String email);
    boolean addNewAccount(String email, String password);
    boolean forgotPassword(String email, String password);
    void sendEmail(String email, String code) throws Exception;
    int login(String email, String password);
}
