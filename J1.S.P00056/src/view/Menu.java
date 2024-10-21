/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.Validation;
import model.Worker;
import service.Manager;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Menu {
    
    private Validation v = new Validation();
    private Manager m = new Manager();
    
    String op[] = {
        "1, Add Worker",
        "2. Up salary",
        "3. Down salary",
        "4. Display",
        "5. Exit"
    };
    
    public void Choice() {
        for (String x : op) {
            System.out.println(x);
        }
    }
    
    public void Menu() {
        int choice;
        do {
            System.out.println("======== Worker Management =========");
            Choice();
            choice = v.getInt("Please your choice: ", 1, 5);
            String id, name, local, status; int age, salary;
            switch(choice) {
                case 1:
                    System.out.println("--------- Add Worker ----------");
                    id = getCode(1, "Code exist");
                    System.out.print("Name: ");
                    name = v.checkInputString();
                    age = v.getInt("Age: ", 18, 60);
                    salary = v.getInt("Enter salary: ", 500, 10000);
                    System.out.print("Local: ");
                    local = v.checkInputString();
                    m.addWorker(new Worker(id, name, age, salary, local, null));
                    break;
                case 2:
                    System.out.println("------- Up Salary --------");
                    id = getCode(2,"Code don't exist");
                    salary = v.getInt("Enter salary: ", 500, 10000);
                    status = "UP";
                    m.upSalary(salary, id, status);
                    break;
                case 3:
                    System.out.println("-------- DOWN Salary --------");
                    id = getCode(2, "Code don't exist.");
                    salary = v.getInt("Enter salary: ", 500, 10000);
                    status = "DOWN";
                    m.downSalary(salary, id, status);
                    break;
                case 4:
                    System.out.println("--------------------Display Information Salary-----------------------");
                    System.out.printf("Code Name    Age    Salary    Status    Date\n");
                    System.out.println(m.toString());
                    break;
            }
        } while (choice != 5);
    }
    
    public String getCode(int mode, String err) {
        String code;
        while (true) {
            code = v.getCode("Enter code: ", "Please dont enter space");
            if ((mode == 1 && m.getWorker(code) == null)
                    || (mode == 2 && m.getWorker(code) != null)) {
                return code;
            }
            System.err.println(err);
        }
    }
}
