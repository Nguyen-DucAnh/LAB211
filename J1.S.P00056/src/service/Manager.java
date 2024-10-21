/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.LocalDate;
import java.util.ArrayList;
import model.SalaryHistory;
import model.Worker;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Manager {
    
    private ArrayList<Worker> listWorker;

    public Manager() {
        listWorker = new ArrayList<>();
    }
    
    public Worker getWorker(String code) {
        for (Worker x : listWorker) {
            if (x.getId().equals(code)) {
                return x;
            }
        }
        return null;
    }
    
    public int getIndex(String code) {
        for (int i = 0; i < listWorker.size(); i++) {
            if (listWorker.get(i).getId().equals(code)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addWorker(Worker worker) {
        listWorker.add(worker);
    }
    
    public void upSalary(int salary, String id, String status) {
        
        ArrayList<SalaryHistory> sh = listWorker.get(getIndex(id)).getSh();
        if (sh == null) {
            sh = new ArrayList<>();
        }
        int newSalary = salary;
        LocalDate date = LocalDate.now();
        listWorker.get(getIndex(id)).setSalary(newSalary);
        sh.add(new SalaryHistory(status, newSalary, date));
        listWorker.get(getIndex(id)).setSh(sh);
    }
    
    public void downSalary(int salary, String id, String status) {
        ArrayList<SalaryHistory> sh = listWorker.get(getIndex(id)).getSh();
        if (sh == null) {
            sh = new ArrayList<>();
        }
        int newSalary = salary;
        LocalDate date = LocalDate.now();
        listWorker.get(getIndex(id)).setSalary(newSalary);
        sh.add(new SalaryHistory(status, newSalary, date));
        listWorker.get(getIndex(id)).setSh(sh);
    }
    
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Worker x : listWorker) {
            if (x.getSh() != null) {
                for(int i = 0 ; i < x.getSh().size(); i++){
                    res.append(x.getId() + "     ");
                    res.append(x.getName() + "     ");
                    res.append(x.getAge() + "      ");
                    res.append(x.getSh().get(i));
                    res.append("\n");
                }
            }
        }
        return res.toString();
    }
    
}
