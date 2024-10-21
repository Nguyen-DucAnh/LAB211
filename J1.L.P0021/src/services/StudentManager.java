/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.Course;
import java.util.ArrayList;
import java.util.Collections;
import model.Student;

/**
 *
 * @author Nguyen Duc Anh
 */
public class StudentManager {
    
    private ArrayList<Student> listStudent;
    

    public StudentManager() {
        listStudent = new ArrayList<>();
    }

    public Student getStudent(String id) {
        for (Student st : listStudent) {
            if (st.getStudentId().equals(id)) {
                return st;
            }
        }
        return null;
    }

    public int getIndex(String id) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getStudentId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addStudent(Student st) {
        listStudent.add(st);
    }

    public String findAndSortByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student x : listStudent) {
            if (x.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(x);
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        String s = "";
        Collections.sort(result);
        for (Student x : result) {
            s += x.toString();
            s += "\n";
        }
        return s;
    }

    public void updateStudent(Student st) {
        int index = getIndex(st.getStudentId());
        if (index != -1) {
            listStudent.set(index, st);
        }
    }
    
    public void deleteStudent(String id) {
        listStudent.remove(getIndex(id));
    }

    public int getTotalCourse(Student st) {
        Course course = st.getCourse();
        String courseString = course.toString();
        String s[] = courseString.split("\\s+");
        return s.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student x : listStudent) {
            sb.append(x.getStudentName() + " | ");
            sb.append(x.getCourse() + " | ");
            sb.append(getTotalCourse(x));
            sb.append("\n");
        }
        return sb.toString();
    }
    
    
}
