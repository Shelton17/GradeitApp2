package com.example.makeupapplication;

public class StudentHelper {
    String studID, studName,studEmail;
    int studMath, studEng, studSwa;

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



    public String getStudEmail() {
        return studEmail;
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


    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public StudentHelper(String studID, String studName, int studMath, int studEng, int studSwa, String studEmail) {
        this.studID = studID;
        this.studName = studName;
        this.studMath = studMath;
        this.studEng = studEng;
        this.studSwa = studSwa;
        this.studEmail = studEmail;
    }
}
