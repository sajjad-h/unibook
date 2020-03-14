package main.java.net.ju.unibook.utils;

public class UserInterface {
    private static final int SCREEN_WIDTH = 67;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showHeader(String msg) {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        showMsg(msg, 0);
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

    }

    public static void showMsg(String msg) {
        showMsg(msg, 0);
    }

    public static void showMsg(String msg, int justification) {
        if (justification == 0) {
            int msgLen = msg.length();
            int need = (SCREEN_WIDTH - msgLen) / 2;
            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.println(msg);
        }
        else if (justification == 1) {
            int msgLen = msg.length();
            int need = (SCREEN_WIDTH - msgLen);
            for (int i = 0; i < need; i++) {
                System.out.print(' ');
            }
            System.out.println(msg);
        }
        else {
            System.out.println(msg);
        }
    }

    public static void showStartMenu() {
        System.out.println("Which one you want to do? ...");
        System.out.println("\t1. Login");
        System.out.println("\t2. Register");
        System.out.println("\t3. Forgot Password");
        System.out.println("\t4. Quit");
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
}
