/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Account;
import services.AccountManager;
import utils.Md5;
import utils.Validation;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Menu {

    Validation v = new Validation();
    AccountManager a = new AccountManager();
    Md5 d = new Md5();
    
    String op[] = {
        "1. Add User",
        "2. Login",
        "3. Exit"
    };

    public void getChoice() {
        System.out.println("======== Login Program ========");
        for (String x : op) {
            System.out.println(x);
        }
    }

    public void Io() {
        int choice;
        do {
            getChoice();
            choice = v.checkLimit("Your choice(1, 3): ", 1, 3);
            String username, password, name, phone, email, address, dob;
            switch (choice) {
                case 1:
                    System.out.println("-------- Add User --------");
                    username = getUsername(1, "Username exist.");
                    password = v.checkString("Password: ");
                    password = d.MD5Encryption(password);
                    name = v.checkString("Name: ");
                    phone = v.checkPhone("Phone: ");
                    email = v.checkEmail("Email: ");
                    address = v.checkString("Address: ");
                    dob = v.getDate("DOB: ");
                    a.addAccount(new Account(username, password, name, phone, email, address, dob));
                    System.out.println("Add successfull.");
                    break;
                case 2:
                    System.out.println("-------- Login --------");
                    username = getUsername(2, "Account doesn't exist.");
                    password = v.checkString("Password: ");
                    Account acclogin = a.findAccount(username, d.MD5Encryption(password));
                    if (acclogin == null) {
                        System.out.println("Login failed. Account doesn't exist.");
                    } else {
                        if (v.checkYN("Hi " + acclogin.getUsername() + ", do you want to change your password now? Y/N: ")) {
                            String oldPassword = password;
                            oldPassword = v.checkString("Old Password: ");
                            String newPassword = v.checkString("New Password: ");
                            String renewPassword = v.checkString("Re-enter New Password: ");
                            if (!newPassword.equals(renewPassword)) {
                                System.out.println("Password do not match. Please try again.");
                            } else {
                                acclogin.changePassword(d.MD5Encryption(oldPassword), d.MD5Encryption(newPassword), d.MD5Encryption(renewPassword));
                                System.out.println("Password changed successfully.");
                            }
                        }
                    }
                    break;
            }
        } while (choice != 3);
    }

    public String getUsername(int mode, String err) {
        String username;
        while (true) {
            username = v.getUsername("Account: ", "Please don't enter space");
            if ((mode == 1 && a.getUsername(username) == null)
                    || (mode == 2 && a.getUsername(username) != null)) {
                return username;
            }
            System.err.println(err);
        }
    }
    
}
