package com.example.makeupapplication;

public class Students {
    private String studID;
    private String studName;

    public Students() {
    }
    public Students(String studID, String studName) {
        this.studID = studID;
        this.studName = studName;
    }
    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }


}
