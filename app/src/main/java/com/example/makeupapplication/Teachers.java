package com.example.makeupapplication;

public class Teachers {
    private String teacherName;
    private String teacherRank;
    private String teacherSubject;

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public Teachers() {
    }

    public Teachers(String teacherName, String teacherRank, String teacherSubject) {
        this.teacherName = teacherName;
        this.teacherRank = teacherRank;
        this.teacherSubject = teacherSubject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacherRank(String teacherRank) {
        this.teacherRank = teacherRank;
    }
}
