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

    public Exam(int userId, String examName) {
        this.userId = userId;
        this.examName = examName;
    }

    public Exam(int userId, String examName, String roll, String reg, String board, int passingYear, double gpa, String status, String group) {
        this.userId = userId;
        this.examName = examName;
        this.roll = roll;
        this.reg = reg;
        this.board = board;
        this.passingYear = passingYear;
        this.gpa = gpa;
        this.status = status;
        this.group = group;
    }

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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }
}
