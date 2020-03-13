package main.java.net.ju.unibook.services;

public interface AccountService {
    boolean isUsedEmail(String email);
    boolean addNewAccount(String email, String password);
    int login(String email, String password);
}
