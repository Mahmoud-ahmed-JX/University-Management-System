/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
class Student extends Person implements Serializable{
  
    private List<Course> courses;
    private int numCourses;
 private boolean Fees;
    private double totalFees;
    private int Credits;
    private int totalCredits;
    private int semester;
    
    public Student( String name, String Email, int ID, int Age, int totalCredits) {
        super(name, Email, ID, Age);
        this.courses=new ArrayList<Course>();
        this.numCourses = 0;
        this.totalCredits = totalCredits;
        this.Fees = false ;
    }
 public boolean hasPaidFees() {
        return Fees;
    }

    public boolean getFees(){
     return Fees;
    }
 
 
    public void payFees(int fees) {
        if(level()==1){
            if(fees==2000){
        Fees = true;
            System.out.println("your process done succesfuly");
            }
            else{
                System.out.println("Payment failed,You should pay: $"+2000);
                    }
        }
        if(level()==2){
            if(fees==2500){
             Fees = true;
              System.out.println("your process done succesfuly");
            }
          else
                System.out.println("Payment failed,You should pay: $"+2500);
        
        }
        if(level()==3){
        if(fees==3000){
             Fees = true;
              System.out.println("your process done succesfuly");
        }
          else
                System.out.println("Payment failed,You should pay: $"+3000);
        }
        if(level()==4){
        if(fees==4000){
             Fees = true;
         System.out.println("your process done succesfuly");
        }
          else
                System.out.println("Payment failed,You should pay: $"+4000);
        }
    }
    
    
    public int level(){
      if(totalCredits<33)
          return 1;
       if(totalCredits>32&&totalCredits<67)
    return 2;
       if(totalCredits>66&totalCredits<99)
            return 3;
       else
           return 4;
    }

//    public void calculateFees() {
//        if (Fees) {
//            System.out.println(getName() + " has paid the fees.");
//        } else {
//            System.out.println(getName() + " has not paid the fees. Total fees: $" + totalFees);
//        }
//    }
   

   

    public void addcourse(Course course) {
        //Error in limitation must handle in main
        if (Credits<20) {
            courses.add(course) ;
            numCourses++;
            Credits+=course.getCreditHours();
            System.out.println("Course has been added");
            
        } else {
            System.out.println("Cannot add more courses. Course limit reached.");
        }
        
    }
public int numcourse (){
    return numCourses ;
}
    public int calculateTotalCreditHours() {
        
        for (int i = 0; i < numCourses; i++) {
            totalCredits +=Credits ;
        }
        return totalCredits;
    }

    // Other methods like getter/setter for name, id, and maybe a method to display enrolled courses

    @Override
    public void determineRule() {
        System.out.print(" Student : ");
    }
     public double calculateGPA() {
        double totalGradePoints = 0.0;
        //int totalCreditHours = 0;

         for (Course course : courses) {
             totalGradePoints += course.getGrade() * course.getCreditHours();
            //Credits += course.getCreditHours();
         }
            
        

        if (Credits > 0) {
            return totalGradePoints / Credits;
        } else {
            return 0.0; // To avoid division by zero
        }
    }
     public void endSemester(){
        totalCredits+=Credits;
        Credits=0;
        
       
     }
     
     public void getCourses(){
            for (Course course : courses) {
                 System.out.println(course.getName()+" "+course.getCode());
         }
     }
     
    @Override//public Student( String name, String Email, int ID, int Age, int totalCredits)
    public String toString() {
        return  getName()+" , "+getEmail()+" , "+getID()+" , "+getAge()+ " , " + totalCredits ;
    }
}
















