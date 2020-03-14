package main.java.net.ju.unibook.entities;

import java.util.Date;

public class UserInfo {
    private int userId;
    private Name name;
    private Name fatherName;
    private Name motherName;
    private String sex;
    private Address address;
    private Date birthOfDate;
    private Age age;
    private String religion;
    private String nationality;

    public UserInfo(int userId) {
        this.userId = userId;
        this.birthOfDate = new Date();
    }

    public UserInfo(int userId, Name name, Name fatherName, Name motherName, String sex, Address address, Date birthOfDate, Age age, String religion, String nationality) {
        this.userId = userId;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.sex = sex;
        this.address = address;
        this.birthOfDate = birthOfDate;
        this.age = age;
        this.religion = religion;
        this.nationality = nationality;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Name getFatherName() {
        return fatherName;
    }

    public void setFatherName(Name fatherName) {
        this.fatherName = fatherName;
    }

    public Name getMotherName() {
        return motherName;
    }

    public void setMotherName(Name motherName) {
        this.motherName = motherName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
