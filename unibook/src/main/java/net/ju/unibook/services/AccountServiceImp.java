package main.java.net.ju.unibook.services;


import main.java.net.ju.unibook.dao.AccountDaoImp;

public class AccountServiceImp implements AccountService {
    private AccountDaoImp accountDaoImp;

    public AccountServiceImp() {
        accountDaoImp = new AccountDaoImp();
    }

    @Override
    public boolean isUsedEmail(String email) {
        return accountDaoImp.isUsedEmail(email);
    }

    @Override
    public boolean addNewAccount(String email, String password) {
        return false;
    }

    @Override
    public int login(String email, String password) {
        return accountDaoImp.login(email, password);
    }
}
