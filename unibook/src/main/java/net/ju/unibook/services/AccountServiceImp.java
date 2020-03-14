package main.java.net.ju.unibook.services;


import main.java.net.ju.unibook.dao.AccountDaoImp;
import main.java.net.ju.unibook.entities.Exam;
import main.java.net.ju.unibook.main.Account;
import main.java.net.ju.unibook.utils.JavaMailUtil;

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
    public boolean addNewAccount(int userId, String email, String password, String phoneNo) {
        return accountDaoImp.addNewAccount(userId, email, password, phoneNo);
    }

    @Override
    public int login(String email, String password) {
        return accountDaoImp.login(email, password);
    }

    @Override
    public boolean forgotPassword(String email, String password) {
        return accountDaoImp.updatePassword(email, password);
    }

    @Override
    public void sendEmail(String email, String code) throws Exception {
        JavaMailUtil.sendMail(email, code);
    }

    @Override
    public boolean isRegistered(int userId) {
        return false;
    }

    @Override
    public int isValidStudent(Exam exam) {
        return accountDaoImp.isValidStudent(exam);
    }
}
