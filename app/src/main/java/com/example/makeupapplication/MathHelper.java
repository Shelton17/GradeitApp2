package com.example.makeupapplication;

public class MathHelper {

    private String studName;

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    private String studID;
    private int studMath;

    public MathHelper() {
    }
    public MathHelper(String studName, int studMath, String studID) {
        this.studID = studID;
        this.studName = studName;
        this.studMath = studMath;

    }
    public int getStudMath() {
        return studMath;
    }

    public void setStudMath(int studMath) {
        this.studMath = studMath;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }
}
