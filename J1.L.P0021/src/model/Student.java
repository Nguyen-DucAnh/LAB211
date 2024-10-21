/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.Course;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Student implements Comparable<Student>{
    
    private String studentId;
    private String studentName;
    private Course course;
    private String semester;

    public Student() {
    }

    public Student(String studentId, String studentName, Course course, String semester) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.semester = semester;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    @Override
    public int compareTo(Student o) {
        return this.studentName.compareTo(o.studentName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " +getStudentId() + "\n");
        sb.append("Name: " +getStudentName() + "\n");
        sb.append("Course:  " + getCourse() + "\n");
        sb.append("Semester: " + getSemester() + "\n");
        sb.append("\n");
        return sb.toString();
    }

}
