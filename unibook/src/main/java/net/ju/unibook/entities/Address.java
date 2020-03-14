package main.java.net.ju.unibook.entities;

public class Address {
    private String houseNo;
    private String streetNo;
    private String village;
    private String postOffice;
    private String postCode;
    private String subDistrict;
    private String district;

    public Address(String houseNo, String streetNo, String village, String postOffice, String postCode, String subDistrict, String district) {
        this.houseNo = houseNo;
        this.streetNo = streetNo;
        this.village = village;
        this.postOffice = postOffice;
        this.postCode = postCode;
        this.subDistrict = subDistrict;
        this.district = district;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
