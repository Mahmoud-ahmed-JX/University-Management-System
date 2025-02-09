/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university_;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Doctor extends Person implements Serializable{
    private Course crs; 

    public Doctor(String name, String Email, int ID, int Age) {
        super(name, Email, ID, Age);
    }

    public Doctor(Course crs, String name, String Email, int ID, int Age) {
        super(name, Email, ID, Age);
        this.crs = crs;
    }

    public Course getCrs() {
        return crs;
    }

    public void setCrs(Course crs) {
        this.crs = crs;
    }

  

   

    @Override
    public void determineRule() {
        System.out.print(" Dr: ");
    }

    @Override
    public String toString() {
        return getName()+" , "+getID()+" , "+getAge()+" , "+getEmail()+ " , "+crs.getName();
    }

    
    
    
}
