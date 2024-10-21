/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dataEnum.TaskEnum;
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
    private TaskEnum num;
    
    public String checkString(String msg) {
        String s;
        while(true) {
            System.out.print(msg);
            s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
        }
    }
    
    public double checkDouble(String msg, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Enter number in rage[" + min + ", " + max + "]");
            }
        }
    }
    
    public int checkInt(String msg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Enter number in rage[" + min + ", " + max + "]");
            }
        }
    }
    
    public String getDate(String msg) {
        String s;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine().trim();
                LocalDate date = LocalDate.parse(s, format);
                if (s.equals(format.format(date))) {
                    return s;
                } else {
                    System.out.println("Input date invalid");
                }
            } catch (DateTimeException e) {
                System.out.println("Please follow format dd-MM-yyyy");
            }
        }
    }
    
    public String getTask(String msg, int min, int max) {
        int type;
        while (true) {
            try {
                System.out.print(msg);
                type = Integer.parseInt(sc.nextLine().trim());
                if (type == 1) {
                    return num.one.toString();
                } else if (type == 2) {
                    return num.two.toString();
                } else if (type == 3) {
                    return num.three.toString();
                } else if(type == 4) {
                    return num.four.toString();
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Enter number in rage[" + min + ", " + max + "]");
            }
        }
    }
}
