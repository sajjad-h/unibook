package main.java.net.ju.unibook.main;

import main.java.net.ju.unibook.services.AccountServiceImp;
import main.java.net.ju.unibook.utils.RandomThing;
import main.java.net.ju.unibook.utils.UserInput;
import main.java.net.ju.unibook.utils.UserInterface;

public class Unibook {

    private AccountServiceImp accountServiceImp;
    private Account account;

    public Unibook() {
        accountServiceImp = new AccountServiceImp();
    }

    public void run() throws Exception {
        int option = 0;
        boolean tryAgain = false;
        do {
            UserInterface.showHeader("Welcome to University Admission System");
            if (tryAgain == true) {
                UserInterface.showMsg("Login please!");
            }
            UserInterface.showStartMenu();
            option = UserInput.getInstance().inputOption();

            switch (option) {
                case 1:
                    this.login();
                    break;
                case 2:
                    break;
                case 3:
                    this.forgotPassword();
                    break;
            }


            tryAgain = true;
        }
        while (option != 4);
        UserInterface.showMsg("Thank you!");
    }

    public void forgotPassword() throws Exception {
        UserInterface.showHeader("Welcome to University Admission System");
        UserInterface.showMsg("Forgot Password!", 0);
        String email = UserInput.getInstance().getEmail();
        if (accountServiceImp.isUsedEmail(email)) {

            String code = RandomThing.getAlphaNumericString(6);
            accountServiceImp.sendEmail(email, code);
            UserInterface.showMsg("We sent an email to you with a security code. Type it here!");
            //UserInterface.showMsg("Generated Code: " + code, 1);
            String typedCode = UserInput.getInstance().getCode();
            if (code.equals(typedCode)) {
                UserInterface.showMsg("Code matched!", 0);
                String password = UserInput.getInstance().getPassword(0);
                String confirmPassword = UserInput.getInstance().getPassword(1);
                if (password.equals(confirmPassword)) {
                    accountServiceImp.forgotPassword(email, password);
                    UserInterface.showMsg("Password Changed Successfully!", 0);
                }
            }
            else {
                UserInterface.showMsg("Wrong Code!", 0);
            }
        }
        else {
            UserInterface.showMsg("Wrong email!", 0);
        }
    }

    public void login() throws Exception {
        int option = 0;
        boolean tryAgain = false;
        boolean goBack = false;
        boolean loggedIn = false;
        do {
            if (tryAgain == true) {
                boolean wrongChoice = false;
                do {
                    //UserInterface.showHeader("Welcome to University Admission System");
                    UserInterface.showLoginMenu();
                    if (wrongChoice == true) {
                        UserInterface.showMsg("Wrong Choice! Try again...");
                    }
                    option = UserInput.getInstance().inputOption();
                    if (option == 1) {
                        break;
                    }
                    else if (option == 2) {
                        this.forgotPassword();
                        goBack = true;
                        break;
                    }
                    else if (option == 3) {
                        goBack = true;
                        break;
                    }
                    else if (option > 3) {
                        wrongChoice = true;
                    }
                }
                while (true);
            }
            if (goBack == true) {
                break;
            }
            UserInterface.showHeader("Welcome to University Admission System");
            UserInterface.showMsg("Login please!");
            String email;
            String password;
            int userId = -1;
            email = UserInput.getInstance().getEmail();
            password = UserInput.getInstance().getPassword(0);
            userId = accountServiceImp.login(email, password);
            if (userId != -1) {
                account = new Account(userId, email);
                UserInterface.showMsg("Successfully Logged in, Welcome!");
                account.run();
                loggedIn = true;
            }
            else {
                UserInterface.showMsg("Uffu! Invalid Username or password!", 0);
                tryAgain = true;
            }
            if (loggedIn == true) {
                UserInterface.showMsg("Successfully Logged Out!");
                break;
            }
        }
        while (true);
    }

}
