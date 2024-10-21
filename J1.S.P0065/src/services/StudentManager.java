/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.util.ArrayList;
import java.util.List;
import model.Student;
/**
 *
 * @author Nguyen Duc Anh
 */
public class StudentManager {
    
    private List<Student> ls;
    
    public StudentManager() {
        ls = new ArrayList<>();
    }
    
    public void addStudent(Student st) {
        ls.add(st);
    }
    
    public String displayInformationStudent() {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (Student st : ls) {
            result.append("------- Student ").append(++i).append(" Info -------\n");
            result.append(st.toString()).append("\n");
        }
        return result.toString();
    }

    public List<Double> getPercentTypeStudent() {
        List<Double> percentTypeStudent = new ArrayList<>();
        int totalStudent = ls.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (Student student : ls) {
            switch (student.getType()) {
                case 'A': typeA++; break;
                case 'B': typeB++; break;
                case 'C': typeC++; break;
                case 'D': typeD++; break;
            }
        }
        percentTypeStudent.add(typeA / totalStudent * 100);
        percentTypeStudent.add(typeB / totalStudent * 100);
        percentTypeStudent.add(typeC / totalStudent * 100);
        percentTypeStudent.add(typeD / totalStudent * 100);

        return percentTypeStudent;
    }
}

