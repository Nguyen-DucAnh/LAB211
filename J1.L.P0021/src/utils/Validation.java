/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import enums.Course;
import enums.Option;
import enums.YesNo;
import java.util.Scanner;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Validation {
    
    Scanner sc = new Scanner(System.in);
    
    public String checkString(String msg, String err) {
        String s;
        while(true) {
            System.out.println(msg);
            s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println(err);
        }
    }
    
    public int checkLimit(String msg, int min, int max) {
        int n;
        while(true) {
            try {
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Re-input");
            }
        }
    }
    
    public String getCode(String msg, String err) {
        String code;
        while(true) {
            System.out.println(msg);
            code = sc.nextLine().trim();
            if (!code.isEmpty()) {
                return code;
            }
            System.out.println(err);
        }
    }
    
    public YesNo getYN(String msg, String err) {
        while(true) {
            try {
                System.out.println(msg);
                YesNo s = YesNo.valueOf(sc.nextLine().toUpperCase().trim());
                return s;               
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
    
    public Option getOption(String msg, String err) {
        while (true) {
            try {
                System.out.println(msg);
                Option s = Option.valueOf(sc.nextLine().toUpperCase().trim());
                return s;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
    
    public Course getCourse(String msg, String err) {
        while (true) {
            try {
                System.out.println(msg);
                Course s = Course.valueOf(sc.nextLine().toUpperCase().trim());
                return s;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
    
    
}
