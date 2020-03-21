package main.java.net.ju.unibook.utils;

public class UserInterface {
    private static final int SCREEN_WIDTH = 67;
    public static final String COMMON = "+-|";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showHeader(String msg) {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        showMessage(msg, 0);
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

    }

    public static void showMessage(String message) {
        showMessage(message, 0);
    }

    public static void showMessage(String message, String design, int justification) {
        int messageLen = message.length() + 2;
        if (justification == 0) {
            int need = (SCREEN_WIDTH - messageLen - 2) / 2;
            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.print(design.charAt(0));
            for (int i = 0; i < messageLen; i++) {
                System.out.print(design.charAt(1));
            }
            System.out.println(design.charAt(0));

            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.println(design.charAt(2) + " " + message + " " + design.charAt(2));

            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.print(design.charAt(0));
            for (int i = 0; i < messageLen; i++) {
                System.out.print(design.charAt(1));
            }
            System.out.println(design.charAt(0));
        }
        else if (justification == 1) {
            int need = (SCREEN_WIDTH - messageLen - 2);
            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.print(design.charAt(0));
            for (int i = 0; i < messageLen; i++) {
                System.out.print(design.charAt(1));
            }
            System.out.println(design.charAt(0));

            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.println(design.charAt(2) + " " + message + " " + design.charAt(2));

            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.print(design.charAt(0));
            for (int i = 0; i < messageLen; i++) {
                System.out.print(design.charAt(1));
            }
            System.out.println(design.charAt(0));
        }
        else {
            System.out.print(design.charAt(0));
            for (int i = 0; i < messageLen; i++) {
                System.out.print(design.charAt(1));
            }
            System.out.println(design.charAt(0));
            System.out.println(design.charAt(2) + " " + message + " " + design.charAt(2));
            System.out.print(design.charAt(0));
            for (int i = 0; i < messageLen; i++) {
                System.out.print(design.charAt(1));
            }
            System.out.println(design.charAt(0));
        }
    }


    public static void showMessage(String message, int justification) {
        int messageLen = message.length();
        if (justification == 0) {
            int need = (SCREEN_WIDTH - messageLen) / 2;
            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.println(message);
        }
        else if (justification == 1) {
            int need = (SCREEN_WIDTH - messageLen);
            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.println(message);
        }
        else {
            System.out.println(message);
        }
    }

    public static void showStartMenu() {
        System.out.println("Which one you want to do? ...");
        System.out.println("\t1. Login");
        System.out.println("\t2. Register");
        System.out.println("\t3. Forgot Password");
        System.out.println("\t4. Quit");
    }

    public static void showUserStartMenu() {
        System.out.println("Which one you want to do? ...");
        System.out.println("\t1. See profile");
        System.out.println("\t2. Show University");
        System.out.println("\t3. Apply for University");
        System.out.println("\t4. See Applications");
        System.out.println("\t5. See Exam Schedule");
        System.out.println("\t6. See Result");
        System.out.println("\t7. Logout");
    }

    public static void showLoginMenu() {
        System.out.println("Which one you want to do? ...");
        System.out.println("\t1. Login again");
        System.out.println("\t2. Forgot Password");
        System.out.println("\t3. Back");
    }

    public static void showSignUpMenu() {
        System.out.println("Which one you want to do? ...");
        System.out.println("\t1. SignUp again");
        System.out.println("\t2. Back");
    }

    public static void showProfileMenu() {
        System.out.println("Which one you want to do? ...");
        System.out.println("\t1. Back");
    }
}
