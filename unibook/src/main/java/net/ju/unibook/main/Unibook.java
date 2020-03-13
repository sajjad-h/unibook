package main.java.net.ju.unibook.main;

import main.java.net.ju.unibook.services.AccountServiceImp;
import main.java.net.ju.unibook.utils.UserInput;
import main.java.net.ju.unibook.utils.UserInterface;

public class Unibook {

    private AccountServiceImp accountServiceImp;
    private Account account;

    public Unibook() {
        accountServiceImp = new AccountServiceImp();
    }

    public void run() {
        int option = 0;
        boolean tryAgain = false;
        do {
            UserInterface.showHeader("Welcome to University Admission System");
            if (tryAgain == true) {
                UserInterface.showMsg("Try again please!");
            }
            UserInterface.showStartMenu();
            option = UserInput.getInstance().inputOption();

            switch (option) {
                case 1:
                    this.login();
                    break;
            }


            tryAgain = true;
        }
        while (option != 3);
        UserInterface.showMsg("Thank you!");
    }

    public void login() {
        int option = 0;
        boolean tryAgain = false;
        boolean goBack = false;
        boolean loggedIn = false;
        do {
            if (tryAgain == true) {
                boolean wrongChoice = false;
                do {
                    UserInterface.showHeader("Welcome to University Admission System");
                    UserInterface.showLoginMenu();
                    if (wrongChoice == true) {
                        UserInterface.showMsg("Wrong Choice! Try again...");
                    }
                    option = UserInput.getInstance().inputOption();
                    if (option == 1) {
                        break;
                    }
                    else if (option == 2) {
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
