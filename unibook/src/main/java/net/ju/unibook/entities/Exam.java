package main.java.net.ju.unibook.entities;

public class Exam {
    private int userId;
    private String examName;
    private String roll;
    private String reg;
    private String board;
    private int passingYear;
    private double gpa;
    private String status;
    private String group;

    public Exam(String roll, String reg, String board) {
        this.roll = roll;
        this.reg = reg;
        this.board = board;
    }

    public int getUserId() {
        return userId;
    }

    public String getExamName() {
        return examName;
    }

    public String getRoll() {
        return roll;
    }

    public String getReg() {
        return reg;
    }

    public String getBoard() {
        return board;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public double getGpa() {
        return gpa;
    }

    public String getStatus() {
        return status;
    }

    public String getGroup() {
        return group;
    }
}
