/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.Check;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import services.StudentManager;

/**
 *
 * @author Nguyen Duc Anh
 */
public class io {
    Check ck = new Check();
    StudentManager mg = new StudentManager();
    
    public void menu() {
        String name, className;
        double math, chemistry, physical, avg;
        
        System.out.println("====== Management Student Program ======");
        while(true) {
            System.out.println("Name: ");
            name = ck.checkInputString();
            System.out.println("Class: ");
            className = ck.checkInputString();
            System.out.println("Math: ");
            math = ck.checkInputMark("Math");
            System.out.println("Chemistry: ");
            chemistry = ck.checkInputMark("Chemistry");
            System.out.println("Physical: ");
            physical = ck.checkInputMark("Physical");
            avg = (math + chemistry + physical) / 3;
            
            char type;
            if (avg > 7.5) {
                type = 'A';
            } else if (avg >= 6 && avg <= 7.5) {
                type = 'B';
            } else if (avg >= 4 && avg < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            // Thêm sinh viên vào StudentManager
            mg.addStudent(new Student(name, className, math, physical, chemistry, avg, type));
            System.out.print("Do you want to enter more student information? (Y/N): ");
            if (!ck.checkYN()) {
                display();             
                return;
            }
        }  
    }
    
    public void display() {
        System.out.println(mg.displayInformationStudent());
                List<Double> percentType = mg.getPercentTypeStudent();
                System.out.println("-------- Classification Info --------");
                System.out.printf("A: %.2f%%\n", percentType.get(0));
                System.out.printf("B: %.2f%%\n", percentType.get(1));
                System.out.printf("C: %.2f%%\n", percentType.get(2));
                System.out.printf("D: %.2f%%\n", percentType.get(3)); 
    }
}
