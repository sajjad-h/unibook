package main.java.net.ju.unibook.utils;

import java.util.Scanner;

public class UserInput {
    private static final UserInput userInput = new UserInput();
    private Scanner scanner;

    private UserInput() {
        scanner = new Scanner(System.in);
    }

    public static UserInput getInstance() {
        return userInput;
    }

    public int inputInteger() {
        int integer;
        integer = scanner.nextInt();
        scanner.nextLine();
        return integer;
    }

    public String inputString() {
        String string;
        string = scanner.nextLine();
        scanner.nextLine();
        return string;
    }

    public int inputOption() {
        System.out.print("\t--->  ");
        return inputInteger();
    }

    public String getEmail() {
        System.out.print("\tE-mail\t:  ");
        return inputString();
    }

    public String getRoll() {
        System.out.print("\tRoll No \t:  ");
        return inputString();
    }

    public String getReg() {
        System.out.print("\tReg No  \t:  ");
        return inputString();
    }

    public String getBoard() {
        System.out.print("\tBoard   \t:  ");
        return inputString();
    }

    public String getPhoneNo() {
        System.out.print("\tPhone No\t:  ");
        return inputString();
    }

    public String getCode() {
        System.out.print("\tSecurity Code\t:  ");
        return inputString();
    }

    public String getPassword(int attempt) {
        if (attempt == 0) {
            System.out.print("\tPassword\t:  ");
        }
        else if (attempt == 1) {
            System.out.print("\tConfirm Password\t:  ");
        }
        return inputString();
    }

}
