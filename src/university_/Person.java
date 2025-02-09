/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university_;

/**
 *
 * @author ragab
 */
abstract public class Person {
    private String name;
    private String Email;
    private int ID;
    private int Age;

    public Person(String name, String Email, int ID, int Age) {
        this.name = name;
        this.Email = Email;
        this.ID = ID;
        this.Age = Age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public abstract void determineRule();

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", Email=" + Email + ", ID=" + ID + ", Age=" + Age + '}';
    }

        
    
    
    
    
    
}
