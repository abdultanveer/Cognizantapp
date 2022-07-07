package com.example.cognizantapp;

import android.os.Parcel;
import android.os.Parcelable;

//heap memory
public class Student  implements Parcelable {
    public static String COLLEGE_NAME = "iit"; //class memory
    String studentName;   //partitions -- instance variable
    int studentAge;
    float stipend;

    public Student(String studentName, int studentAge, float stipend) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.stipend = stipend;
    }

    public Student(Parcel parcel){
        this.studentName = parcel.readString();
        this.studentAge = parcel.readInt();
        this.stipend = parcel.readFloat();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(studentName);
        parcel.writeInt(studentAge);
        parcel.writeFloat(stipend);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", stipend=" + stipend +
                '}';
    }
}
