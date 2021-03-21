package asg1;
import java.util.Scanner;
//import Action;
//import Role;

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
	   System.out.println("5. Edit Enrolment");
	   
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

	  Role assistant = new Assistant();
	  this.action.enrolStudent(assistant); 
	  
       }
       //show all courses for semester
       if (choice.equals("2")){
	  this.action.courseMenu("view");
       }
    }while (!choice.equals("q"));
    }
    public static void main(String[] args_){
	App apptest = new App();
	apptest.run();
     	
    }
}
