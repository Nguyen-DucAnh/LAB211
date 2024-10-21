/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author Nguyen Duc Anh
 */
public enum Course {
    JAVA("JAVA"),
    DOT_NET(".NET"),
    C_CPP("C/C++");
    
    private String fullName;

    private Course(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
   
}
