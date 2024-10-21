/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Worker {
    private String id;
    private String name;
    private int age;
    private int salary;
    private String local;
    private ArrayList<SalaryHistory> sh;

    public Worker() {
    }

    public Worker(String id, String name, int age, int salary, String local, ArrayList<SalaryHistory> sh) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.local = local;
        this.sh = sh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ArrayList<SalaryHistory> getSh() {
        return sh;
    }

    public void setSh(ArrayList<SalaryHistory> sh) {
        this.sh = sh;
    }
    
    @Override
    public String toString() {
        return String.format("%5s %5s %5d %5d", id, name, age, salary);
    }
  
}
