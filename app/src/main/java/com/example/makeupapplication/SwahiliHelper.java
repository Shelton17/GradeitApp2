package com.example.makeupapplication;

public class SwahiliHelper {

    private String studName, studID;
    private int studSwa;

    public SwahiliHelper() {
    }

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public SwahiliHelper(String studName, int studSwa, String studID) {
        this.studID = studID;
        this.studName = studName;
        this.studSwa = studSwa;
    }

    public int getStudSwa() {
        return studSwa;
    }

    public void setStudSwa(int studSwa) {
        this.studSwa = studSwa;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }
}