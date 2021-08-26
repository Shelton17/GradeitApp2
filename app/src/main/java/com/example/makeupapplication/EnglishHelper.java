package com.example.makeupapplication;

public class EnglishHelper {

    private String studName, studID;
    private int studEng;

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public EnglishHelper() {
    }
    public EnglishHelper(String studName, int studEng, String studID) {
        this.studID = studID;
        this.studName = studName;
        this.studEng = studEng;
    }
    public int getStudEng() {
        return studEng;
    }

    public void setStudEng(int studEng) {
        this.studEng = studEng;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }
}
