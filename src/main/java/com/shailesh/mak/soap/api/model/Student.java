package com.shailesh.mak.soap.api.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private long studentId;
    private String name;
    private String grade;
    @Column(name = "class_teacher")
    private String classTeacher;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "school_district")
    private String schoolDistrict;

    public Student() {
    }

    public Student(String name, String grade, String classTeacher, String schoolName, String schoolDistrict) {
        this.name = name;
        this.grade = grade;
        this.classTeacher = classTeacher;
        this.schoolName = schoolName;
        this.schoolDistrict = schoolDistrict;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolDistrict() {
        return schoolDistrict;
    }

    public void setSchoolDistrict(String schoolDistrict) {
        this.schoolDistrict = schoolDistrict;
    }
}
