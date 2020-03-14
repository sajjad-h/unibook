package main.java.net.ju.unibook.entities;

public class Name {
    private String firstName;
    private String lastName;
    private String nickName;
    private String fullName;

    public Name(String firstName, String lastName, String nickName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.fullName = this.firstName + " " + this.lastName + " (" + this.nickName + ")";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
