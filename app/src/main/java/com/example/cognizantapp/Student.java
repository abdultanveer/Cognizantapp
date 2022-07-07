package com.example.cognizantapp;
//heap memory
public class Student {
    public static String COLLEGE_NAME = "iit"; //class memory
    String studentName;   //partitions -- instance variable
    int studentAge;
    float stipend;

    public Student(String studentName, int studentAge, float stipend) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.stipend = stipend;
    }

    public String getStudentName() {
        int c = 10 + 20; // c is a local variable
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        String studentAge; //local variable
        return this.studentAge; //partition
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public float getStipend() {
        return stipend;
    }

    public void setStipend(float stipend) {
        this.stipend = stipend;
    }
}
