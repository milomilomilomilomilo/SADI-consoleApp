/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 24/04/21 (Special Consideration)  
*/

package asg1;
import java.util.Scanner;

//Main Class

public class App{

  private Action action;
  
  public void run(){
    this.action = new Action();
    this.cases();
  }
  
  public String displayMenu(){
    Scanner sc = new Scanner(System.in);
    String choice = "";
    do{
      
      System.out.println("***Student Enrolment System***");
      System.out.println("1. Enrol Student into Course");
      System.out.println("2. Display All Courses");
      System.out.println("3. Display All Enrolments for Student in Semester");
      System.out.println("4. Display All Enrolments in Courses for Semester");
      System.out.println("5. Print out CSV reports");
      System.out.println("6. Edit Enrolment");
      
      choice = sc.nextLine();
      return choice;
      
    }while(!choice.equals("q"));
    
  }
  //use cases as per adapter/facade design
  public void cases(){
    String choice ="";
    do{
      
      choice =  this.displayMenu();
      //enrol student into course
      if (choice.equals("1")){
	//delegates Assistant to give enrol permission.
	Role assistant = new Assistant();
	this.action.enrolStudent(assistant); 
	
      }
      //show all courses for semester
      else if (choice.equals("2")){
	String semester = this.action.chooseSemester(); 
	this.action.courseMenu("view", semester);
      }
      //show all enrolments for student in semester
      else if (choice.equals("3")){
	this.action.displayEnrolments();
      }
      //show course enrolments
      else if (choice.equals("4")){
	this.action.allStudents();
      }
      //Print CSV reports
      else if (choice.equals("5")){
	this.action.printMenu();
	
      }
      //update enrolments
      else if (choice.equals("6")){
	this.action.update();
      }
    }while (!choice.equals("q"));
  }
  public static void main(String[] args_){
    App apptest = new App();
    apptest.run();
    
  }
}
