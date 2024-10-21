package entity;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Duc Anh
 */
public class Check {
   
    Scanner sc = new Scanner(System.in);
    
    public String checkInputString() {
        while (true) {
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return s;
            }
        }
    }
    
    public int checkInputMark(String nameSubject) {
        while (true) {
            try {
                int mark = Integer.parseInt(sc.nextLine());
                if (mark < 0) {
                    System.err.println(nameSubject + " is greater than equal zero");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                if (mark > 10) {
                    System.err.println(nameSubject + " is smaller than equal ten");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                return mark;
            } catch (NumberFormatException e) {
                System.err.println(nameSubject + "is digit.");
                System.out.print(nameSubject + ":");
            }
        }
    }
    
    public boolean checkYN() {      
        while (true) {
            String s = checkInputString(); 
            if (s.length() == 1) {
                char sChar = s.charAt(0);
                if (sChar == 'y' || sChar == 'Y') {
                    return true;
                }
                if (sChar == 'n' || sChar == 'N') {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }
   
}
