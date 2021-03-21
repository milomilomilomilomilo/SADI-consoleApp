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

    
    Course c1 = new Course("SADI", "c3333");
    Course c2 = new Course("SEPM", "c4444");
    Course c3 = new Course("ML", "c5555" );
    Course c4 = new Course("BIZ", "c6666"  );

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
     
     // String name = sc.nextLine(); 
     System.out.println("enter ID of student>>>");
     String ID = sc.nextLine();
     //contingency   
     if (this.college.getStudent(ID) == null ){
	System.out.println("Student with ID does not exist. Creating new student...");
        System.out.println("Enter Name of Student>>>");
	String name =  sc.nextLine();
        s1 =new Student(name, ID);
	this.college.addStudent(s1);
       } 
     //find course
     do{
       c1 = this.courseMenu("enrol for student: " + ID);

     }while (c1== null);
     //Course c1 = this.college.getCourse(CID);
      
     //Choose semester
     System.out.println("enter Semester to enrol>>>");
     semester = sc.nextLine();
     //StudentEnrolment SE = new StudentEnrolment(s1, c1, semester);

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
     System.out.println("Enter ID of course to " + operation + ">>>");
     choice  = sc.nextLine();

     course = this.college.getOne(choice);
     System.out.println(course.getCName());

     //while (choice.equals("q"));
     return course;
  }
    
  //Show All Enrollments
  public void displayEnrolments(){

    Iterator iter = this.college.getAll();
  }
  //...
  /*
 +This functionality will basically add/update/delete into StudentEnrolment list. 
  There will be an academic assistant who will use this functionality to enroll 
  students in courses. 
  
  +Enroll a students for 1 semester

  The system should ask id of students, semester, and courses that students need
  to enroll (use Scanner(System.in))
  
  Update an enrolment of a students for 1 semester

  The system should list all courses of a student in a semester and ask whether 
  delete or add new courses from the list.
  
  5. a) Print all courses for 1 student in 1 semester. Print all students of 1 
  course in 1 semester. Prints all courses offered in 1 semester.
    
     b) Allow to save these reports to CSV files.
    
*/

}
