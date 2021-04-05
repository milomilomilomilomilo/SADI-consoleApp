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

    
    Course c1 = new Course("SADI", "c3333", "sem1_2021");
    Course c2 = new Course("SEPM", "c4444", "sem1_2021");
    Course c3 = new Course("MACHINE LEARNING", "c5555", "sem1_2021");
    Course c4 = new Course("BUSINESS", "c6666", "sem1_2021");

    Course c5 = new Course("ART AND COMPUTERS", "c7777", "sem2_2021");
    Course c6 = new Course("MUSIC TECHNOLOGY", "c8888", "sem2_2021");
    Course c7 = new Course("ROBTS CANT DANCE", "c9999", "sem2_2021");
    Course c8 = new Course("AI", "c1010", "sem2_2021");
     
    this.college.addCourse(c1);
    this.college.addCourse(c2);
    this.college.addCourse(c3);
    this.college.addCourse(c4);
    this.college.addCourse(c5);
    this.college.addCourse(c6);
    this.college.addCourse(c7);
    this.college.addCourse(c8);
    
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
        this.courseMenu("enrol for student: " + ID);

	System.out.println("enter Course ID>>>" );
	done = sc.nextLine();

	//register enrolment      
	if(!this.college.add(s1.getID(),done)){System.out.println(
						 "error enrolling...");}
	System.out.println(
		  "Enter to add another course to enrolment? 'q' to quit.");
        done = sc.nextLine();

      }while (!done.equals("q"));
      

      //      String pause = sc.nextLine();      
    }    
    else { //not assistant
      System.out.println("Invalid credentials... ");
    } 
  }
  
  //display courses for enrolment.
  public void courseMenu(String operation){
    Course course = null;
    String sem = "";
    String choice = "";

    System.out.println("***welcome to the course menu***");
    System.out.println("Please choose semester to view>>>");

    sem =chooseSemester();

    System.out.println("Here are available courses: " );
    this.college.displayAll(sem);
  }

  public String chooseSemester(){
    String sem =""; 
    do {
      System.out.println("enter '1' for semsester 1 or' 2' for semester 2.");
      sem = sc.nextLine();
      System.out.println(sem);

    } while (!(sem.equals("1") || sem.equals("2")));
    if (sem.equals("1")){   sem = "sem1_2021"; } else {sem = "sem2_2021" ; }
    return sem;
    
  }
  
  public Course getCourse(){
    String choice = "";
    Course course = null;
    System.out.println("Enter ID of course to operate on + >>>");
		       
    choice  = sc.nextLine();
    
    course = this.college.getOne(choice);
    System.out.println(course.getCName());
    return course;

  }
  //Show All Enrollments
  public void displayEnrolments(){
    System.out.println( "Enter Student ID>>>" );
    String ID =          sc.nextLine();
    String semester = chooseSemester();
    this.college.displayAll(ID, semester);
    //Iterator iter = this.college.getAll();
  }

  //Update an enrolment of a students for 1 semester
  public void update(){
    String stuID = "";
    String semester = "";
    String choice = "";
    String CID = "";
    System.out.println("enter student ID to update enrolment>>>");

    stuID = sc.nextLine();
    
    // The system should list all courses of a student in a semester
    System.out.println("enter semester to review>>>");
    semester = chooseSemester();
    this.college.displayAll(stuID, semester);

    //ask whether delete or add new courses from the list   
    System.out.println(
	   "Enter 'R' remove a course. Or enter 'A' Add a course 'X' to exit>>>");
    choice = sc.nextLine();
    if (choice.equals("R")){
      System.out.println("Enter ID of course to remove");
      CID = sc.nextLine();
      this.college.delete(stuID, CID, semester);
    }
    else if (choice.equals("A")){
      
      this.college.displayAll(semester);
      System.out.println(
	  "Please enter Course ID from list above to add to enrolment>>>");
      CID = sc.nextLine();
      this.college.add(stuID, CID);
    }
    else{
      System.out.println("invalid selection...");
    }
  }

  public void allStudents(){
    
    System.out.println("ID of COURSE>>>");
    String CID = sc.nextLine();
    
    System.out.println("semester to report for student>>>");
    String semester = chooseSemester();
    
    Iterator students = this.college.getAllStudents(
					 CID, semester);
    while (students.hasNext()){
      Student stu = (Student) students.next();
      System.out.println(stu.toString());
    }
    //    this.college.saveAll("course name", students, "new file");
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
      semester =chooseSemester();
      this.college.setPrinter(new PrintCourses());
      Iterator courses = this.college.getStudentsCourses(SID);
      this.college.savePrint("students name", courses, "new file");
    }    
   
    // Print all students of 1 course in 1 semester. 
    if (choice.equals("2")){
       System.out.println("ID of COURSE>>>");
       CID = sc.nextLine();
       
       System.out.println("semester to report for student>>>");
       semester = chooseSemester();
       this.college.setPrinter(new PrintStudents());
       Iterator students = this.college.getAllStudents(CID, semester);
       this.college.savePrint("course name", students, "new file");
    }
    
    // Prints all courses offered in 1 semester.
    if (choice.equals("3")){
      
       System.out.println("semester to report for Courses>>>");
       semester = chooseSemester();
       
       this.college.setPrinter(new PrintCourses());
       Iterator courses = this.college.getAllCoursesSemester(semester);
       this.college.savePrint("course name", courses, "new file");
    }
     
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
