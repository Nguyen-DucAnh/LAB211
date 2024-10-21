/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author Nguyen Duc Anh
 */
public class AccountManager {

    List<Account> listAcc;

    public AccountManager() {
        listAcc = new ArrayList<>();
    }

    public void addAccount(Account acc) {
        listAcc.add(acc);
    }

    public Account getAccount(String username) {
        for (Account x : listAcc) {
            if (x.getUsername().equals(username)) {
                return x;
            }
        }
        return null;
    }

    public String getUsername(String username) {
        for (int i = 0; i < listAcc.size(); i++) {
            if (listAcc.get(i).getUsername().equals(username)) {
                return listAcc.get(i).getUsername();
            }
        }
        return null;
    }

    public Account findAccount(String username, String password) {
        for (int i = 0; i < listAcc.size(); i++) {
            if (username.equalsIgnoreCase(listAcc.get(i).getUsername())) {
                if (password.equalsIgnoreCase(listAcc.get(i).getPassword())) {
                    return listAcc.get(i);
                }
            }
        }
        return null;
    }
}
