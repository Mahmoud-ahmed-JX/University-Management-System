/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university_;

import java.io.Serializable;
import javafx.scene.control.TextField;

/**
 *
 * @author sanaa
 */
public class Assistance extends Person implements Serializable{

    public Assistance(String name, String Email, int ID, int Age) {
        super(name, Email, ID, Age);
    }

    

    @Override
    public void determineRule() {
        System.out.print("Assistant : ");
    }
    @Override
    public String toString() {
        return  getName()+" , "+getID()+" , "+getAge()+
                " , "+getEmail(); 
                }

    

    
    

    

   
   

}
 