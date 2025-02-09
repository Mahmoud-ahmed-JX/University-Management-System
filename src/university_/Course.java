/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university_;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Course implements Serializable{
    
      private String CourseName;
    private int code; //id
    private Student[] students;
    private int size;
    private int CreditHours;
    private double grade;
    
    public Course(String Coursename, int code, int size,int CreditHours) {
        this.CourseName = Coursename;
        this.code = code;
        this.size = size;
        this.students = new Student[size];
        this.CreditHours=CreditHours;
         this.grade = 0.0;
       
    }
     public Course(String Coursename, int code,int CreditHours) {
        this.CourseName = Coursename;
        this.code = code;
        this.students = new Student[size];
        this.CreditHours=CreditHours;
         this.grade = 0.0;
       
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
         if (grade >= 0 && grade <= 4.0) { //  grade is between 0 and 4
            this.grade = grade;
        } else {
            System.out.println("Invalid grade.");
        }
    }
     
    public int getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }

    public void getStudents() {
        for (int i = 0; i < numOfStudents(); i++) {
            Student student = students[i];
                System.out.println("Name: "+student.getName()+" ID: "+student.getID()+" Email: "+student.getEmail());
        }
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
    
    public String getName() {
        return CourseName;
    }

    public void setName(String name) {
        this.CourseName = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSize() {
        return size;
    }

    public void addStudent(Student student) {
        int i;
        for (i = 0; i < size; i++) {
            if (students[i] == null) {
                students[i] = student;
                System.out.println("Student added to the course: " );
                return;
            }
        }
        System.out.println("Cannot add more students. Course is full.");
    }

    public int numOfStudents() {
        int count = 0;
        for (Student student : students) {
            if (student != null) {
                count++;
            }
        }
        return count;
    }

    public void display() {
        System.out.println("Course Name: " + CourseName);
        System.out.println("Course Code: " + code);
        System.out.println("Number of Students Enrolled: " + numOfStudents());
        System.out.println("CreditHours="+ CreditHours);
        System.out.println("Maximum Size of Course: " + size);
    }

    @Override
    public String toString() {
        return  getName()+ " , " + getCode() + " , " + getSize()+ " , " + getCreditHours();
    }
    
   }
    

