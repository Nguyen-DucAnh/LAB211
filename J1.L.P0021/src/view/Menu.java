/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import enums.Course;
import enums.Option;
import enums.YesNo;
import model.Student;
import services.StudentManager;
import utils.Validation;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Menu {

    Validation v = new Validation();
    StudentManager m = new StudentManager();

    String op[] = {
        "1. Create",
        "2. Find and sort by name",
        "3. Update/Delete",
        "4. Report",
        "5. Exit"
    };

    public void getChoice() {
        System.out.println("======== Welcome Program ========");
        for (String x : op) {
            System.out.println(x);
        }
    }

    public String getCode(int mode, String err) {
        String s;
        while (true) {
            s = v.getCode("Enter ID: ", "No Empty");
            if (mode == 1 && m.getStudent(s) == null
                    || mode == 2 && m.getStudent(s) != null) {
                return s;
            }
        }
    }

    public void Io() {
        int choice;
        do {
            getChoice();
            choice = v.checkLimit("Enter choice: ", 1, 5);
            String studentId, studentName, semester;
            Course course;
            switch (choice) {
                case 1:
                    while (true) {
                        int n = 1;
                        while (n++ <= 1) {
                            System.out.println("-------- Create --------");
                            studentId = getCode(1, "ID is exist");
                            studentName = v.checkString("Name:", "No Empty");
                            course = v.getCourse("Course:", "JAVA | DOT_NET | C_CPP");
                            semester = v.checkString("Semester:", "No Empty");
                            m.addStudent(new Student(studentId, studentName, course, semester));
                            System.out.println("Create successfull!");
                        }
                        YesNo yn = v.getYN("Do you want continue(Y/N):", "Please input (Y/N)");
                        if (yn.equals(YesNo.N)) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("-------- Find and sort by Name ---------");
                    studentName = v.checkString("Name: ", "Don't exist");
                    String result = m.findAndSortByName(studentName);
                    if (result != null) {
                        System.out.println(result);
                    } else {
                        System.out.println("Not Found");
                    }
                    break;
                case 3:
                    System.out.println("-------- Update/Delete --------");
                    studentId = getCode(2, "ID don't exist");
                    Option op = v.getOption("Enter option to Update or Delete (U/D):", "Please enter U or D:");
                    if (op.equals(Option.U)) {
                        studentName = v.checkString("New Name:", "Re-input");
                        course = v.getCourse("New Course: ", "JAVA | DOT_NET | C_CPP");
                        semester = v.checkString("New Semester:", "No Empty");
                        m.updateStudent(new Student(studentId, studentName, course, semester));
                        System.out.println("Update successfull!");
                    } else {
                        m.deleteStudent(studentId);
                        System.out.println("Delete successfull!");
                    }
                    break;
                case 4:
                    System.out.println("-------- Report --------");
                    System.out.println(m.toString());
                    break;
            }
        } while (choice != 5);
    }

}
