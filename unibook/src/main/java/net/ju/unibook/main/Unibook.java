package main.java.net.ju.unibook.main;

import main.java.net.ju.unibook.entities.Exam;
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
                UserInterface.showMessage("Login please!");
            }
            UserInterface.showStartMenu();
            option = UserInput.getInstance().inputOption();

            switch (option) {
                case 1:
                    this.login();
                    break;
                case 2:
                    this.signUp();
                    break;
                case 3:
                    this.forgotPassword();
                    break;
            }


            tryAgain = true;
        }
        while (option != 4);
        UserInterface.showMessage("Thank you!");
    }

    public void signUp() {
        int option = 0;
        boolean tryAgain = false;
        boolean goBack = false;
        do {
            if (tryAgain == true) {
                boolean wrongChoice = false;
                do {
                    //UserInterface.showHeader("Welcome to University Admission System");
                    UserInterface.showSignUpMenu();
                    if (wrongChoice == true) {
                        UserInterface.showMessage("Wrong Choice! Try again...");
                    }
                    option = UserInput.getInstance().inputOption();
                    if (option == 1) {
                        break;
                    }
                    else if (option == 2) {
                        goBack = true;
                        break;
                    }
                    else if (option > 2) {
                        wrongChoice = true;
                    }
                }
                while (true);
            }
            if (goBack == true) {
                break;
            }
            UserInterface.showHeader("Welcome to University Admission System");
            UserInterface.showMessage("Sign-up please!");
            String roll;
            String reg;
            String board;
            roll = UserInput.getInstance().getRoll();
            reg = UserInput.getInstance().getReg();
            board = UserInput.getInstance().getBoard();
            int userId = accountServiceImp.isValidStudent(new Exam(roll, reg, board));
            if (userId == -1) {
                UserInterface.showMessage("Wrong Information! Try again!", 0);
                tryAgain = true;
                continue;
            }
            if (accountServiceImp.isRegistered(userId)) {
                UserInterface.showMessage("Uffu! You are already registered!", 0);
                tryAgain = true;
                continue;
            }
            String email;
            String password;
            String confirmPassword;
            String phoneNo;
            do {
                email = UserInput.getInstance().getEmail();
                if (accountServiceImp.isUsedEmail(email)) {
                    UserInterface.showMessage("Uffu! Already used email! Try Again!", 0);
                    continue;
                }
                break;
            }
            while (true);

            do {
                password = UserInput.getInstance().getPassword(0);
                confirmPassword = UserInput.getInstance().getPassword(1);
                if (!password.equals(confirmPassword)) {
                    UserInterface.showMessage("Uffu! Password didn't match! Try Again!", 0);
                    continue;
                }
                break;
            }
            while (true);
            phoneNo = UserInput.getInstance().getPhoneNo();
            if (accountServiceImp.addNewAccount(userId, email, password, phoneNo)) {
                UserInterface.showMessage("Successfully Signed up!", 0);
                break;
            }
            else {
                UserInterface.showMessage("Uffu! Something naughty happens!", 0);
                tryAgain = true;
            }
        }
        while (true);
    }

    public void forgotPassword() throws Exception {
        UserInterface.showHeader("Welcome to University Admission System");
        UserInterface.showMessage("Forgot Password!", 0);
        String email = UserInput.getInstance().getEmail();
        if (accountServiceImp.isUsedEmail(email)) {

            String code = RandomThing.getAlphaNumericString(6);
            accountServiceImp.sendEmail(email, code);
            UserInterface.showMessage("We sent an email to you with a security code. Type it here!");
            //UserInterface.showMessage("Generated Code: " + code, 1);
            String typedCode = UserInput.getInstance().getCode();
            if (code.equals(typedCode)) {
                UserInterface.showMessage("Code matched!", 0);
                do {
                    String password = UserInput.getInstance().getPassword(0);
                    String confirmPassword = UserInput.getInstance().getPassword(1);
                    if (!password.equals(confirmPassword)) {
                        UserInterface.showMessage("Uffu! Password didn't match! Try Again!", 0);
                        continue;
                    }
                    accountServiceImp.forgotPassword(email, password);
                    UserInterface.showMessage("Password Changed Successfully!", 0);
                    break;
                }
                while (true);

            }
            else {
                UserInterface.showMessage("Wrong Code!", 0);
            }
        }
        else {
            UserInterface.showMessage("Wrong email!", 0);
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
                        UserInterface.showMessage("Wrong Choice! Try again...");
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
            UserInterface.showMessage("Login please!");
            String email;
            String password;
            email = UserInput.getInstance().getEmail();
            password = UserInput.getInstance().getPassword(0);
            Account account = accountServiceImp.login(email, password);
            if (account != null) {
                UserInterface.showMessage("Successfully Logged in, Welcome!");
                account.run();
                loggedIn = true;
            }
            else {
                UserInterface.showMessage("Uffu! Invalid Username or password!", 0);
                tryAgain = true;
            }
            if (loggedIn == true) {
                //UserInterface.showMessage("Successfully Logged Out!");
                break;
            }
        }
        while (true);
    }

}
