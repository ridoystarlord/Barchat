package com.ridoy.barchat;

public class BarchatItems {
    private String semesterName;
    private float semesterCGPA;

    public BarchatItems(String semesterName, float semesterCGPA) {
        this.semesterName = semesterName;
        this.semesterCGPA = semesterCGPA;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public float getSemesterCGPA() {
        return semesterCGPA;
    }

    public void setSemesterCGPA(float semesterCGPA) {
        this.semesterCGPA = semesterCGPA;
    }
}
