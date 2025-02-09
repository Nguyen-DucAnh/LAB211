/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Duc Anh
 */
public class Account {

    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dob;

    public Account() {
    }

    public Account(String username, String password, String name, String phone, String email, String address, String dob) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void changePassword(String oldPassword, String newPassword, String renewPassword) {
        if (oldPassword != null && !oldPassword.isEmpty()
                && newPassword != null && !newPassword.isEmpty()
                && renewPassword != null && !renewPassword.isEmpty()) {
            if (oldPassword.equals(this.password)) {
                if (newPassword.equals(renewPassword)) {
                    this.password = newPassword;
                }
            }
        }
    }

}
