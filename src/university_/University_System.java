/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package university_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import static javafx.scene.control.ButtonBar.ButtonData.NO;
import static javafx.scene.control.ButtonBar.ButtonData.YES;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author utd
 */
public class University_System extends Application {
    ArrayList<Assistance> Assistants=new ArrayList();
    ArrayList<Doctor> Doctors=new ArrayList();
    ArrayList<Course> Courses=new ArrayList();   
    ArrayList<Student> Students=new ArrayList();

    
      
   public void parsLineA(String str){
     Scanner sc=new Scanner(str);
     String name,id,Age,Email;
     sc.useDelimiter(" , ");
     while(sc.hasNext()){
        name=sc.next();
        id=sc.next();
        Age=sc.next();
        Email=sc.next();
        Assistance a=new Assistance(name, Email, Integer.parseInt(id), Integer.parseInt(Age));
         System.out.println(a.toString());
        Assistants.add(a);
     }
     sc.close();
   } 
   public void parsLineC(String str){
     Scanner sc=new Scanner(str);
     String name,Code,size,Credits;
     sc.useDelimiter(" , ");
     while(sc.hasNext()){
        name=sc.next();
        Code=sc.next();
        size=sc.next();
        Credits =sc.next();
        Course c=new Course(name, Integer.parseInt(Code), Integer.parseInt(size), Integer.parseInt(Credits));
        Courses.add(c);
     }
        sc.close();
        
   }
   
   
   public void parsLineD(String str){
     Scanner sc=new Scanner(str);
     String name,Email,ID,Age,course;
     sc.useDelimiter(" , ");
     while(sc.hasNext()){
        name=sc.next();
        ID=sc.next();
        Age=sc.next();
        Email =sc.next();
        course=sc.next();
        
         for (Course Course1 : Courses) {
             if(Course1.getName().equalsIgnoreCase(course)){
            Doctor d=new Doctor(Course1, name, Email, Integer.parseInt(ID), Integer.parseInt(Age));     
            Doctors.add(d);
             }
             
         }
     }
     sc.close();
   }
   
   
   
   public void parsLineS(String str){
     Scanner sc=new Scanner(str);
     // getName()+" , "+getEmail()+" , "+getID()+" , "+getAge()+ " , " + totalCredits 
     String name,Email,ID,Age,totalCredits;
     sc.useDelimiter(" , ");
     while(sc.hasNext()){
        name=sc.next();
        Email=sc.next();
        ID=sc.next();
        Age =sc.next();
        totalCredits=sc.next();
                
           Student s=new Student(name, Email, Integer.parseInt(ID), Integer.parseInt(Age), Integer.parseInt(totalCredits));
            Students.add(s);
     
     }
     sc.close();
   }
   
   
      
    @Override
        
    public void start(Stage primaryStage) throws  ClassNotFoundException, FileNotFoundException, IOException {        
           FileWriter as=new FileWriter("Assistants.txt",true);
           FileWriter cr=new FileWriter("Courses.txt",true);
           FileWriter doc=new FileWriter("Doctors.txt",true);
           FileWriter st=new FileWriter("Students.txt",true);
           FileReader asReader=new FileReader("Assistants.txt");
           FileReader crReader=new FileReader("Courses.txt");
           FileReader docReader=new FileReader("Doctors.txt");
           FileReader stReader=new FileReader("Students.txt");
           PrintWriter assis=new PrintWriter(as,true);
           PrintWriter crs=new PrintWriter(cr,true);
           PrintWriter doct=new PrintWriter(doc,true);
           PrintWriter std=new PrintWriter(st,true);
           
           Scanner assRead=new Scanner( asReader);
           Scanner crsRead=new Scanner( crReader);
           Scanner doctRead=new Scanner( docReader);
           Scanner stdRead=new Scanner( stReader);
           
            
           
             Label Welcome=new Label("Welcome !");
             Welcome.setStyle( "-fx-font: normal bold 27px 'serif' ");
             
             Button buttonAssistant=new Button("Insert Assistant");
             Button ButtonDoctor=new Button("  Insert Doctor  ");  
              Button ButtonCourse=new Button("      Courses     ");
              Button ButtonStudent=new Button(" Insert Student ");
               Button exit=new Button("         Exit         ");
              
              
         GridPane Grid=new GridPane();
          Grid.add(Welcome, 0,0,2,1);
          Grid.add(buttonAssistant, 0,1);
          Grid.add(ButtonStudent, 0, 2);
          Grid.add(ButtonDoctor, 0, 3);
          Grid.add(ButtonCourse, 0, 4);
          Grid.add(exit, 0,5);
          Grid.setAlignment(Pos.CENTER);
          Grid.setVgap(30);
          Grid.setHgap(30);
         
          Grid.setPadding(new Insets(20,20,20,50));
        Scene scene=new Scene(Grid,400,500);
        scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
         
        //parsLineA("ali , 111 , 12 , fdgfd@");
        buttonAssistant.setOnAction((ActionEvent event) -> {
               
        Label Name=new Label("name");
        Label id=new Label("id");
        Label Email=new Label("Email");
        Label Age=new Label("age");
        TextField textFieldname=new TextField();
        TextField textFieldid=new TextField();
        TextField textFieldEmail=new TextField();
        TextField textFieldAge=new TextField();
        
        Button b=new Button("insert Assistant");
        Button back=new Button("back");
        Button databack=new Button("return data");
        Button search=new Button("Search");
        
        GridPane gridPane=new GridPane();
        gridPane.add(Name, 0, 0);
        gridPane.add(textFieldname,1,0);
        gridPane.add(id, 0, 1);
        gridPane.add(textFieldid, 1, 1);
        gridPane.add(Email, 0, 2);
        gridPane.add(textFieldEmail, 1, 2);
        gridPane.add(Age, 0, 3);
        gridPane.add(textFieldAge, 1, 3);
        gridPane.add(b, 0, 4);
        gridPane.add(back, 1, 4);
        gridPane.add(search, 0, 5);
        gridPane.add(databack, 1, 5);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        b.setOnAction((ActionEvent event1) -> {
            try{
            Assistance a=  new Assistance(textFieldname.getText(), textFieldEmail.getText(), Integer.parseInt(textFieldid.getText()), Integer.parseInt(textFieldAge.getText()));
             a.determineRule(); 
            System.out.println(a.toString());
            
            Assistants.add(a);
              

            assis.println(a.toString());
            }
            catch(Exception ex){
                Alert a1=new Alert(Alert.AlertType.ERROR,ex.toString());
                                 a1.setTitle("Error");
                           a1.show();
            }
            
        });
        
        back.setOnAction((f) -> {
            
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
       
        
    
        databack.setOnAction((ActionEvent f) -> {
            while(assRead.hasNextLine()){ 
             parsLineA(assRead.nextLine());
             }
            
        });
        
        search.setOnAction((e) -> {
            Label idLabel=new Label("id");
            TextField textFieldId=new TextField();
            Button searchbtn=new Button("search");
            
            GridPane g=new GridPane();
            g.add(id, 0, 0);
            g.add(textFieldId, 1, 0);
            g.add(searchbtn, 0, 1);
            g.add(back, 1, 1);
           g.setPadding(new Insets(20));

            
            searchbtn.setOnAction((f) -> {
                for (Assistance Assistant : Assistants) {
                    if(Assistant.getID()==Integer.parseInt(textFieldId.getText())){
                      Assistant.determineRule();    
                    System.out.println(Assistant.toString());}
                }
            });
            
            g.setVgap(10);
        g.setHgap(10);
        g.setAlignment(Pos.CENTER);
        Scene Scene=new Scene(g);
          Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);        
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
        });

        
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.TOP_LEFT);
        Scene Scene=new Scene(gridPane);
        Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);       
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
        
          });
        
        
        
        
        
       
        ButtonDoctor.setOnAction((ActionEvent event) -> {
            Label Name=new Label("name");
        Label id=new Label("id");
        Label Email=new Label("Email");
        Label Age=new Label("age");
        Label Labelcourse=new Label("course");
        TextField textFieldname=new TextField();
        TextField textFieldid=new TextField();
        TextField textFieldEmail=new TextField();
        TextField textFieldAge=new TextField();
        TextField textFieldCourse=new TextField();
       
        
        Button b=new Button("insert Doctor");
         Button backButton=new Button("back");
         Button databack=new Button("return data");
         Button search=new Button("search");
        GridPane gridPane=new GridPane();
        gridPane.add(Name, 0, 0);
        gridPane.add(textFieldname,1,0);
        gridPane.add(id, 0, 1);
        gridPane.add(textFieldid, 1, 1);
        gridPane.add(Email, 0, 2);
        gridPane.add(textFieldEmail, 1, 2);
        gridPane.add(Age, 0, 3);
        gridPane.add(textFieldAge, 1, 3);
        gridPane.add(Labelcourse, 0, 4);
        gridPane.add(textFieldCourse, 1, 4);
        
        
        gridPane.add(b, 0, 5);
        gridPane.add(backButton, 1, 5);
        gridPane.add(search, 0, 6);
        gridPane.add(databack,1, 6);
        gridPane.setPadding(new Insets(20));  
        b.setOnAction(new EventHandler<ActionEvent>() {
          
             
                    @Override
            public void handle(ActionEvent event) {
                
                       try{
                for (Course course:Courses) {
                                
                                if(course.getName().equals(textFieldCourse.getText())){
                                   
                                    Doctor d=new Doctor(course,textFieldname.getText(), textFieldEmail.getText(), Integer.parseInt(textFieldid.getText()), Integer.parseInt(textFieldAge.getText()));
                                    Doctors.add(d);
                                    doct.println(d);
                                     System.out.println(course.toString());
                                      d.determineRule(); 
                                     System.out.println(d.toString());
                                
                                    }
                            } 
                       }
                       catch(Exception ex){
                            Alert a1=new Alert(Alert.AlertType.ERROR,ex.toString());
                                 a1.setTitle("Error");
                           a1.show();
            }
                
                    }
                   
                       
                    

                
                        
        });
        backButton.setOnAction((e) -> {
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        
         search.setOnAction((e) -> {
            Label idLabel=new Label("id");
            TextField textFieldId=new TextField();
            Button searchbtn=new Button("search");
            
            GridPane g=new GridPane();
            g.add(idLabel, 0, 0);
            g.add(textFieldId, 1, 0);
            g.add(searchbtn, 0, 1);
            g.add(backButton, 1, 1);
            g.setPadding(new Insets(20));

            
            searchbtn.setOnAction((f) -> {
                for (Doctor Doctor1 : Doctors) {
                    if(Doctor1.getID()==Integer.parseInt(textFieldId.getText())){
                         Doctor1.determineRule(); 
                         System.out.println(Doctor1.toString());
                        return;
                    }}
                });
            
         g.setVgap(10);
        g.setHgap(10);
        g.setAlignment(Pos.CENTER_LEFT);
        Scene SceneD=new Scene(g);
        SceneD.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(SceneD);        
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
            });
        
      
        databack.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        while(doctRead.hasNextLine()){
                        parsLineD(doctRead.nextLine());
                        }
                        for (Doctor Doctor1 : Doctors) {
                            System.out.println(Doctor1);
                    }
                }
            });
        
  
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER_LEFT);
        Scene SceneD=new Scene(gridPane);
          SceneD.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(SceneD);        
        primaryStage.setMaxHeight(500);
        primaryStage.setTitle("University System");
        primaryStage.setWidth(400);
        primaryStage.show();
        });
        
        
        
        
        
        
       //Course
        ButtonCourse.setOnAction((event) -> {
            Label Name=new Label("name");
        Label code=new Label("code");
        Label size=new Label("size");
        Label creditHourse=new Label("creditHours");
        
        
        
        TextField textFieldname=new TextField();
        TextField textFieldcode=new TextField();
        TextField textFieldsize=new TextField();
        TextField textFieldcreditHours=new TextField();
       
        
        
        
        Button b=new Button("insert Course");
        Button back=new Button("back");
        Button dataBack=new Button("return data");
        Button search=new Button("search Course");
        
        
        
        Button addStudents=new Button("add Students");
        Button show=new Button("show Students");
        GridPane gridPane=new GridPane();
        
        gridPane.add(Name, 0, 0);
        gridPane.add(textFieldname,1,0);
        gridPane.add(code, 0, 1);
        gridPane.add(textFieldcode, 1, 1);
        gridPane.add(size, 0, 2);
        gridPane.add(textFieldsize, 1, 2);
        gridPane.add(creditHourse, 0, 3);
        gridPane.add(textFieldcreditHours, 1, 3);
        
        
        
        
        gridPane.add(b, 0, 5);
        gridPane.add( back,1, 5);
        gridPane.add( show,0, 6);
        
        gridPane.add( dataBack,1, 6);
        gridPane.add(addStudents, 0, 7);
        gridPane.add(search, 1, 7);
        gridPane.setPadding(new Insets(20));
        
        
        b.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
            public void handle(ActionEvent event) {
                
                    try{
                    Course c=  new Course(textFieldname.getText(), Integer.parseInt(textFieldcode.getText()), Integer.parseInt(textFieldsize.getText()), Integer.parseInt(textFieldcreditHours.getText()));
                  
                System.out.println(c.toString());
                Courses.add(c);
                crs.println(c);
                    }
                    catch(Exception ex ){
                    Alert a1=new Alert(Alert.AlertType.ERROR,ex.toString());
                                 a1.setTitle("Error");
                           a1.show();
                    }
                
                
             }
        
                        
        });
        
        back.setOnAction((c) -> {
            
            primaryStage.setScene(scene);
            primaryStage.show();
        });
       
        
        dataBack.setOnAction((x) -> {
                    while(crsRead.hasNextLine()){
                    parsLineC(crsRead.nextLine());
                    }
                        for (Course Course1 : Courses) {
                            System.out.println(Course1);
            }
        });
        
        
        search.setOnAction((e) -> {
            Label name=new Label("Course Name");
            TextField textFieldName=new TextField();
            Button searchbtn=new Button("search");
            GridPane grid=new GridPane();
            grid.add(name, 0, 0);
            grid.add(textFieldName, 1, 0);
            grid.add(searchbtn, 0, 1);
            grid.add(back, 1, 1);
            grid.setPadding(new Insets(20));

            searchbtn.setOnAction((eventc) -> {
                for (Course Course1 : Courses) {
                    if(Course1.getName().equalsIgnoreCase(textFieldName.getText())){
                           System.out.println(Course1.toString());
                           System.out.println(Course1.numOfStudents());
                           
                    }
                }
                
            });
            
            grid.setVgap(10);
            grid.setHgap(10);
        Scene Scene=new Scene(grid);
        Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
           });
        
        
        
        show.setOnAction((f) -> {
           Label crsName=new Label("Course Name :");
           TextField textfieldcrsname=new TextField();
           
           Button showbtn=new Button("show");
           Button backbtn=new Button("back");
           GridPane gp=new GridPane();
            gp.add(crsName, 0, 0);
            gp.add(textfieldcrsname, 1, 0);
            
            gp.add(showbtn, 0, 1);
            gp.add(backbtn, 1, 1);
           gp.setAlignment(Pos.CENTER);
            gp.setPadding(new Insets(20));
            
            showbtn.setOnAction((g) -> {
                for (Course Course1 : Courses) {
                      if(Course1.getName().equals(textfieldcrsname.getText())){
                          System.out.println("Number of Students: "+Course1.numOfStudents());
                          Course1.getStudents();
                              
                          
                      }
                }
            });
          
           
            
            backbtn.setOnAction((c) -> {
            
            primaryStage.setScene(scene);
            primaryStage.show();
        });
            
            gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER_LEFT);
        Scene Scene=new Scene(gp);
          Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
        });
        
        
        addStudents.setOnAction((e) -> {
            
            Label crsName=new Label("Course Name");
            Label studentId=new  Label("Student ID");
            TextField TextFieldcrsName=new TextField();
            TextField TextFieldID=new TextField();
           
            Button addbtn=new Button("add");
            Button backbtn=new Button("back");
          GridPane G=new GridPane();
            G.add(crsName, 0, 0);
            G.add(TextFieldcrsName, 1, 0);
            G.add(studentId, 0, 1);
            G.add(TextFieldID, 1, 1);
            G.add(addbtn, 0, 2);
            G.add(backbtn, 1, 2);
            G.setPadding(new Insets(20));
            G.setAlignment(Pos.CENTER);
            G.setHgap(10);
            G.setVgap(10);
            addbtn.setOnAction((g) -> {
                try{
                for (Course Course1 : Courses) {
                    for (Student Student1 : Students) {
                        
                    
                      if(TextFieldcrsName.getText().equals(Course1.getName())&&Integer.parseInt(TextFieldID.getText())==Student1.getID()){
                           Course1.addStudent(Student1);
                           
                           System.out.println(Student1.getName()+" has been added");
                      }
                          }
                }
                }
                catch (Exception ex ){
                Alert a1=new Alert(Alert.AlertType.ERROR,ex.toString());
                                 a1.setTitle("Error");
                           a1.show();
                }
            });
          backbtn.setOnAction((c) -> {
              primaryStage.setScene(scene);
              primaryStage.show();
          });
          Scene c=new  Scene(G);
           c.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
          primaryStage.setScene(c);
          primaryStage.show();
        });
        
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER_LEFT);
        Scene Scene=new Scene(gridPane);
        Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
        });
        
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    System.exit(0);
                }
            });
        
        
        
        
        
        
        //Student 
        ButtonStudent.setOnAction((event) -> {
            Label Name=new Label("name");
        Label id=new Label("id");
        Label Email=new Label("Email");
        Label Age=new Label("age");
        Label totalcredits=new Label("total Credits");
        TextField textFieldname=new TextField();
        TextField textFieldid=new TextField();
        TextField textFieldEmail=new TextField();
        TextField textFieldAge=new TextField();
        TextField textFieldCredits=new TextField();
        
        
        
        
        
        Button b=new Button("insert Student");
        Button back=new Button("back");
        Button Pay=new Button("Pay fees");
        Button addCourse=new Button("Add Course");
        Button search=new Button("search Student");
        Button databack=new Button("return data");
        GridPane gridPane=new GridPane();
        gridPane.add(Name, 0, 0);
        gridPane.add(textFieldname,1,0);
        gridPane.add(id, 0, 1);
        gridPane.add(textFieldid, 1, 1);
        gridPane.add(Email, 0, 2);
        gridPane.add(textFieldEmail, 1, 2);
        gridPane.add(Age, 0, 3);
        gridPane.add(textFieldAge, 1, 3);  
        gridPane.add(totalcredits, 0, 4);
        gridPane.add(textFieldCredits, 1, 4);
       
        
        gridPane.add(b, 0, 5);  
        gridPane.add(back, 1, 5);       
        gridPane.add(databack, 0, 6);
        gridPane.add(Pay, 1, 6);
        gridPane.add(addCourse, 0, 7);
        gridPane.add(search, 1, 7);
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        
        b.setOnAction(new EventHandler<ActionEvent>() {
       
                    @Override
            public void handle(ActionEvent event) {
                    
                    
                try{
                    Student s=new Student(textFieldname.getText(), textFieldEmail.getText(), Integer.parseInt(textFieldid.getText()), Integer.parseInt(textFieldAge.getText()), Integer.parseInt(textFieldCredits.getText()));
                    Students.add(s);
                    std.println(s);
                     s.determineRule(); 
                        System.out.println(s.toString());
                       
            }
            
            catch (Exception ex ){
        Alert a1=new Alert(Alert.AlertType.ERROR,ex.toString());
                                 a1.setTitle("Error");
                           a1.show();
            }
            }
        });
        
        
         back.setOnAction((f) -> {
            
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
       
     
    
        databack.setOnAction((f) -> {
                    while( stdRead.hasNextLine()){
                  parsLineS(stdRead.nextLine());
                         }
                    for (Student Student1 : Students) {
                        System.out.println(Student1);
            }
                    
        });
        
        addCourse.setOnAction((e) -> {
            Label crsName=new Label("Course Name");
            Label stdID=new Label("Student ID");
            TextField textFieldcrsName=new TextField();
            TextField textFieldstdID=new TextField();
            
            Button add=new Button("add Course");
            
            
            GridPane G=new GridPane();
            G.add(crsName, 0, 0);
            G.add(textFieldcrsName, 1, 0);
            G.add(stdID, 0, 1);
            G.add(textFieldstdID, 1, 1);
            G.add(add, 0, 2);
            G.add(back, 1, 2);
            G.setPadding(new Insets(20));
           
            add.setOnAction((c) -> {
                  for (Course Course1 : Courses) {
                    for (Student Student1 : Students) {
                      if(Course1.getName().equalsIgnoreCase(textFieldcrsName.getText())&&Integer.parseInt(textFieldstdID.getText())==Student1.getID()){
                           Student1.addcourse(Course1);
                         
                      }
                        
                      }
                    
                }
                
            });
            
        
            G.setVgap(10);
            G.setHgap(10);
            Scene Scene=new Scene(G);
            Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);        
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
        });
        
        
        search.setOnAction((f) -> {
            Label ID=new Label("Student ID");
            TextField textFieldID=new TextField();
            Button searchbtn=new Button("search");
            GridPane grid=new GridPane();
            grid.add(ID, 0, 0);
            grid.add(textFieldID, 1, 0);
            grid.add(searchbtn, 0, 1);
            grid.add(back, 1, 1);
            grid.setPadding(new Insets(20));
            searchbtn.setOnAction((eventc) -> {
                for (Student Student1 : Students) {
                    if(Student1.getID()==Integer.parseInt(textFieldID.getText())){
                         Student1.determineRule(); 
                        System.out.println(Student1.toString());
                        System.out.println(Student1.numcourse()); 
                        Student1.getCourses();
                        System.out.print("Fees: ");
                        System.out.print(Student1.getFees()? YES:NO);
                        System.out.println("");
                    }
                }
                
                
            });
            
            grid.setVgap(10);
            grid.setHgap(10);
        Scene Scene=new Scene(grid);
        Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);
        primaryStage.setTitle("University System");
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
           });
        
        
        Pay.setOnAction((e) -> {
            Label stdID=new Label("student id");
            Label fees=new Label("fees");
            TextField textFieldstdID=new TextField();
            TextField textFieldfees=new TextField();
            
            Button pay=new Button("pay");
                       
            GridPane g=new GridPane();
            g.add(stdID, 0, 0);
            g.add(textFieldstdID, 1, 0);
            g.add(fees, 0, 1);
            g.add(textFieldfees, 1, 1);
            g.add(pay, 0, 2);
            g.add(back, 1, 2);
            g.setPadding(new Insets(20));
            pay.setOnAction((c) -> {
                for (Student Student1 : Students) {
                    if(Integer.parseInt(textFieldstdID.getText())==Student1.getID()){
                        Student1.payFees(Integer.parseInt(textFieldfees.getText()));
                    }
                }
            });
            
            g.setVgap(10);
            g.setHgap(10);
            Scene Scene=new Scene(g);
              Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);        
        primaryStage.setMaxHeight(500);
        primaryStage.setWidth(400);
        primaryStage.show();
        });

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER_LEFT);
        Scene Scene=new Scene(gridPane);
          Scene.getStylesheets().add((new File("src/university_/sheet.css")).toURI().toString());
        primaryStage.setScene(Scene);        
        primaryStage.setMaxHeight(500);
        primaryStage.setTitle("University System");
        primaryStage.setWidth(400);
        primaryStage.show();
        });
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        launch(args);
        
        
    }
    
}
