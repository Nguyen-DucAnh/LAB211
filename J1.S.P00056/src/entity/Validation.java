/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Scanner;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Validation {
    
    Scanner sc = new Scanner(System.in);
    
    public String checkInputString() {
        while(true) {
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("No Empty.");
                System.out.print("Enter again: ");
            } else {
                return s;
            }
        }
    }
    
    public int getInt(String msg, int min, int max) {
        int number;
        while (true) {
            try {
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());
                if (min <= number && number <= max) {
                    return number;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Enter number range " + min + " " + max);
            }
        }
    }
    
    public String getCode(String msg, String err) {
        String code;
        while (true) {
            System.out.print(msg);
            code = sc.nextLine().trim();
            if (!code.isEmpty()) {
                return code;
            }
            System.err.println(err);
        }
    }
}
