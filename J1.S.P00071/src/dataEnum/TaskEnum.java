/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataEnum;

/**
 *
 * @author Nguyen Duc Anh
 */
public enum TaskEnum {
    one("Code"),
    two("Test"),
    three("Design"),
    four("Review");
    private String display;

    TaskEnum(String display) {
        this.display = display;
    }
    
    public String toString() {
        return display;
    }
    
}
