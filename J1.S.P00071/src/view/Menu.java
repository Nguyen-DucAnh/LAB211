/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Task;
import services.TaskManager;
import utils.Validation;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Menu {
    
    Validation v = new Validation();
    TaskManager t = new TaskManager();
    
    String op[] =
    {
        "1. Add Task",
        "2. Delete Task",
        "3. Display Task",
        "4. Exit"
    };
    
    public void getChoice() {
        System.out.println("======== Task Manager ========");
        for (String x : op) {
            System.out.println(x);
        }
    }
    
    public void io() {
        int choice;
        do {
            getChoice();
            choice = v.checkInt("Choice (1 - 4): ", 1, 4);
            String name, taskType, date, assign, reviewer;
            double from, to; int id;
            switch(choice) {
                case 1:
                    id = t.getID();
                    System.out.println("-------- Add Task --------");
                    name = v.checkString("Requirement Name: ");
                    taskType = v.getTask("Task: ", 1, 4);
                    date = v.getDate("Date: ");
                    from = v.checkDouble("From: ", 8.0, 17.5);
                    to = v.checkDouble("To: ", from + 1, 17.5);
                    assign = v.checkString("Assign: ");
                    reviewer = v.checkString("Reviewer: ");
                    t.addTask(new Task(id, name, taskType, date, from, to, assign, reviewer));
                    break;
                case 2:
                    id = v.checkInt("ID: ", 1, t.getID() - 1) - 1;
                    t.deleteTask(id);
                    break;
                case 3:
                    System.out.println(t.toString());
            }
        } while(choice != 4);
    }
}
