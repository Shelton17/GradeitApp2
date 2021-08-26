package com.example.makeupapplication;

public class DatabaseClass {
    String teacherName, teacherPassword, teacherRank, teacherSubject;

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public String getTeacherName(){
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherRank(String teacherRankt) {
        this.teacherRank = teacherRankt;
    }


    public DatabaseClass( String teacherName, String teacherPassword, String teacherRank, String teacherSubject){
        this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
        this.teacherRank = teacherRank;
        this.teacherSubject = teacherSubject;

    }
}
