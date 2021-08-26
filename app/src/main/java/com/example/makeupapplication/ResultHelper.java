package com.example.makeupapplication;

public class ResultHelper {

    String studID, studName;
    int studMath, studEng, studSwa,studTotal;

    public String getStudID() {
        return studID;
    }

    public String getStudName() {
        return studName;
    }

    public int getStudMath() {
        return studMath;
    }

    public int getStudEng() {
        return studEng;
    }

    public int getStudSwa() {
        return studSwa;
    }

    public int getStudTotal() {
        return studTotal;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public void setStudMath(int studMath) {
        this.studMath = studMath;
    }

    public void setStudEng(int studEng) {
        this.studEng = studEng;
    }

    public void setStudSwa(int studSwa) {
        this.studSwa = studSwa;
    }

    public void setStudTotal(int studTotal) {
        this.studTotal = studTotal;
    }

    public ResultHelper() {
    }

    public ResultHelper(String studID, String studName, int studMath, int studEng, int studSwa, int studTotal) {
        this.studID = studID;
        this.studName = studName;
        this.studMath = studMath;
        this.studEng = studEng;
        this.studSwa = studSwa;
        this.studTotal = studTotal;
    }


}
