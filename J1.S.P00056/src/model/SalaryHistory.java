/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nguyen Duc Anh
 */
public class SalaryHistory {
    private String status;
    private int hSalary;
    private LocalDate date;

    public SalaryHistory() {
    }

    public SalaryHistory(String status, int hSalary, LocalDate date) {
        this.status = status;
        this.hSalary = hSalary;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int gethSalary() {
        return hSalary;
    }

    public void sethSalary(int hSalary) {
        this.hSalary = hSalary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%5d %5s %5s", hSalary, status, format.format(date));
    }
    
    
}
