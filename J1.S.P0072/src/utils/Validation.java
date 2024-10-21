/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author Nguyen Duc Anh
 */
public class Validation {
    
    Scanner sc = new Scanner(System.in);
    String PHONE_VALID = "^\\d{9,10}$";
    String EMAIL_VALID = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{1,3}$";
    
    
    public String checkString(String msg) {
        String s;
        while(true) {
            System.out.println(msg);
            s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }              
        }
    }
    
    public int checkLimit(String msg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Please input in rage [" + min + ", " + max + "]");
            }
        }
    }
    
    public String checkPhone(String msg) {
        String s;
        while (true) {
            System.out.println(msg);
            s = sc.nextLine().trim();
            if (!s.isEmpty() && s.matches(PHONE_VALID)) {
                return s;
            } else {
                System.out.println("Re-input");
            }
        }
    }
    
    public String checkEmail(String msg) {
        String s;
        while (true) {
            System.out.println(msg);
            s = sc.nextLine().trim();
            if (!s.isEmpty() && s.matches(EMAIL_VALID)) {
                return s;
            } else {
                System.out.println("Re-input");
            }
        }
    }
    
    public String getDate(String msg) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s;
        while(true) {
            try {
                System.out.println(msg);
                s = sc.nextLine().trim();
                LocalDate date = LocalDate.parse(s, format);
                if (s.equals(format.format(date))) {
                    return s;
                } else {
                    System.out.println("Re-input");
                }
            } catch (DateTimeException e) {
                System.out.println("Please date follow format dd/MM/yyyy.");
            }
        }
    }
    
    public String getUsername(String msg, String err) {
        String username;
        while (true) {
            System.out.print(msg);
            username = sc.nextLine().trim();
            if (!username.isEmpty()) {
                return username;
            }
            System.err.println(err);
        }
    }
    
    public boolean checkYN(String msg) {      
        String s;
        while (true) {
            System.out.println(msg);
            s = sc.nextLine().trim();
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
