package asg1;

import java.util.Scanner;
import java.util.Iterator;
/*
  Facade Pattern 
*/

public class Action{
  private College college;
  private static Scanner sc = new Scanner(System.in);
  
  public Action(){
    this.college = new College();
    this.populate();
    
  } 
  //populate Students and courses...
  public void populate(  ){
    
    Student s1 = new Student("milo", "123a" );
    Student s2 = new Student("mojo", "234b" );
    Student s3 = new Student("miji", "345c" );
    Student s4 = new Student("maka", "456d" );
    Student s5 = new Student("mimi", "567e");

    this.college.addStudent(s1);
    this.college.addStudent(s2);
    this.college.addStudent(s3);
    this.college.addStudent(s4);
    this.college.addStudent(s5);

    
    Course c1 = new Course("SADI", "c3333", "sem1");
    Course c2 = new Course("SEPM", "c4444", "sem1");
    Course c3 = new Course("ML", "c5555", "sem2" );
    Course c4 = new Course("BIZ", "c6666", "sem2"  );

    this.college.addCourse(c1);
    this.college.addCourse(c2);
    this.college.addCourse(c3);
    this.college.addCourse(c4);
  }
  //Use Cases
  
  //Add Student Enrolment Semester
  public void enrolStudent(Role affiliated){
    Student s1 = null;
    Course c1 = null;
    String semester = "";
    if (affiliated.getRole().equals("Assistant")){
      //find student to enrol
     
      System.out.println("enter ID of student>>>");
      String ID = sc.nextLine();
      //contingency   
      if (this.college.getStudent(ID) == null ){
	System.out.println("Student with ID does not exist. "
             + "Creating new student...");
	System.out.println("Enter Name of Student>>>");
	String name =  sc.nextLine();
	s1 =new Student(name, ID);
	this.college.addStudent(s1);
      }
      else {
	  s1 =  this.college.getStudent(ID);
      }
	  
      
      //find course
      String done = "";
      do{
	//and courses that students need to enroll 
	c1 = this.courseMenu("enrol for student: " + ID);
	System.out.println(
	 "Enter to add another course to enrolment? 'q' to quit.");
        done = sc.nextLine();
      }while (!done.equals("q") || c1 == null);
      //Course c1 = this.college.getCourse(CID);
      
      //Choose semester
      System.out.println("enter Semester to enrol>>>");
      semester = sc.nextLine();

      //      System.out.println("DEBUG:   " + s1.getID());
      // System.out.println("DEBUG:   " + c1.getCID());
      // System.out.println("DEBUG:   " + semester);
      
      
      //StudentEnrolment SE = new StudentEnrolment(s1, c1, semester);
      String nullpointer = sc.nextLine();
      //register enrolment
      this.college.add(s1.getID(), c1.getCID(), semester);
      this.college.displayAll(s1.getID(), college.getAll(), semester);
    }
    
    else { //not assistant
      System.out.println("Invalid credentials... ");
    } 
  }
  
  //display courses for enrolment.
  public Course courseMenu(String operation){
    Course course = null;
    System.out.println("Here are available courses:" );
    this.college.displayAll();
    String choice = "";
    System.out.println("Enter ID of course to "
		       + operation + ">>>");
    choice  = sc.nextLine();
    
    course = this.college.getOne(choice);
    System.out.println(course.getCName());
    return course;
  }
  
  //Show All Enrollments
  public void displayEnrolments(){
    
    Iterator iter = this.college.getAll();
  }

  //Update an enrolment of a students for 1 semester
  public void updateEnrolment(){
    String stuID = "";
    String semester = "";
    String choice = "";
    String CID = "";
    System.out.println("enter student ID to update enrolment>>>");

    stuID = sc.nextLine();
    
    // The system should list all courses of a student in a semester
    System.out.println("enter semester to review>>>");
    semester = sc.nextLine();
    this.college.displayAll(stuID, this.college.getAll(), semester);

    //ask whether delete or add new courses from the list   
    System.out.println(
	   "Enter 'R' remove a course. Or enter 'A' Add a course 'X' to exit>>>");
    choice = sc.nextLine();
    if (choice.equals('R')){
      System.out.println("Enter ID of course to remove");
      CID = sc.nextLine();
      this.college.delete(stuID, CID, semester);
    }
    if (choice.equals('A')){
      
      this.college.displayAll();
      System.out.println(
	  "Please enter Course ID from list above to add to enrolment>>>");
      CID = sc.nextLine();
      this.college.add(stuID, CID, semester);
    }
    else{
      System.out.println("invalid selection...");
    }
  }

  public void printMenu(){
    String choice = "";
    String SID  = "";
    String CID = "";
    String semester = "";
    
    System.out.println("1. Print student courses \n"
             + "2. Print course students, \n3. Print all available courses");
    choice = sc.nextLine();

 //  a)  Print all courses for 1 student in 1 semester. 
 //     this.college.displayAll(stuID, this.college.getAll(), semester);

    if (choice.equals("1")){
       System.out.println("ID of student>>>");
       SID = sc.nextLine();
       
       System.out.println("semester to report for student>>>");
       semester = sc.nextLine();

       Iterator courses = this.college.getStudentsCourses(SID, semester);
       this.college.saveAll("students name", courses, "new file");
    }
    
   
    // Print all students of 1 course in 1 semester. 

    if (choice.equals("2")){
       System.out.println("ID of COURSE>>>");
       CID = sc.nextLine();
       
       System.out.println("semester to report for student>>>");
       semester = sc.nextLine();

       Iterator students = this.college.getAllStudents(CID, semester);
       this.college.saveAll("course name", students, "new file");
    }
    

    

    
    // Prints all courses offered in 1 semester.


     
    //b) Allow to save these reports to CSV files.

  }
  //...
  /*
 +This functionality will basically add/update/delete into StudentEnrolment list. 
  There will be an academic assistant who will use this functionality to 
  enroll students in courses. 
  *//*
  public static void main(String[] args){
    Action instance = new Action();

    instance.printMenu();
    //print all students courses without first enrolling.
    //no exception thrown.
    
    Role assistant = new Assistant();
    instance.enrolStudent(assistant); 
       }   */ 
}
