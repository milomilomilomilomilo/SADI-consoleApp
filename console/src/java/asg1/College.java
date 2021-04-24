package asg1;

/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
  
*/
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/* 
   This class contains methods to populate students and courses and also 
   to make StudentEnrolments and store and manipulate these. Further, it 
   uses a delegate to access Printable Interface for making CSV reports of
   Student Enrolments.
*/
public class College implements StudentEnrolmentManager{
  private List<Course> courses = new ArrayList();
  private List<Student> students = new ArrayList();    
  private List<StudentEnrolment> SE = new ArrayList();
  public Scanner pause = new Scanner(System.in);
  private Printable printerDelegate;

  
  public College(){}

  public void addStudent(Student student){
    this.students.add(student);
    System.out.println("student added to records");
   }

  //Set the Printer Delagate to choose between course or student record  
  public void setPrinter(Printable printer){
    this.printerDelegate = printer;
  }
  
  public void addCourse(Course course){
    this.courses.add(course);
    
  }
  
  //display all courses for semester
  public void displayAll(String semester){
    Iterator iter = getAllCoursesSemester(semester);
    
    while (iter.hasNext()){
      
      Course course = (Course) iter.next();
      
      System.out.println(course.toString());
    }
  }
  //find a student by ID
  public Student getStudent(String studentID ){
    Iterator iter = this.students.iterator();
    while (iter.hasNext()){
      Student st1 = (Student) iter.next();
      if (st1.getID().equals(studentID)){
	return st1;
      }
	   
    }
    System.out.println("student not found");
    
    return  null;
  }
  
  //get one Course 
  public Course getCourse(String courseID, String sem ){
    Course co2 = new Course("void", courseID, sem); 
    Iterator iter = this.courses.iterator();
    while (iter.hasNext()){
      Course cs1 = (Course) iter.next();
      if (co2.equals(cs1)){
	return cs1;
      }  
    }
      System.out.println("course not found");
      
      return null; 
  }
  
  //adds an enrolment to student and course.
  public boolean add(String studID, String courseID, String sem){
    
    Student s1 = getStudent(studID);
    Course c1 = getCourse(courseID,  sem);
    
    if (s1 != null && (c1 != null)){
      if (this.SE.add(new StudentEnrolment(s1, c1))){
	
	System.out.println("Student: " + s1.getID()
			   + "successfully enroled in course:"
			   + c1.getCID());
	return true;   }   
    }
    return false;  
  }
  
  //returns an iterator of all Student Enrolment Objects
  public Iterator getAll(){
    return this.SE.iterator();
  }
  
  //returns one StudentEnrolment for one student in one course
  public StudentEnrolment getOne(
		String studentID, String courseID, String semester){
    Iterator iter =  this.getAll();
    StudentEnrolment oneSE = null;
    //provide dummy data for respective equals method comparison.
    Course mockcourse = new Course("dummy", courseID, semester);
    Student mockstudent = new Student("none", studentID);
    StudentEnrolment testSE = new StudentEnrolment(mockstudent,mockcourse);  
    while (iter.hasNext()){
      oneSE = (StudentEnrolment) iter.next();
      if   (oneSE.equals(testSE)
	    ){
	  
	return oneSE; 
      }
    }
    return oneSE;
  }
    
  // display all (Course) enrolments for a student in semester
  public void displayAll(String stuID, String semester){
    System.out.println(semester);  
    Iterator allCourses = this.getStudentsCourses(stuID);
    Iterator semCourses = this.getStudentCoursesSemester(
					   allCourses, semester);
    System.out.println("Courses for " + stuID + "semester:" + semester);
    while (semCourses.hasNext()){
      Course enrolled = (Course) semCourses.next();
      
      System.out.println(enrolled.toString());
   
    }
  }
  
  //Get all courses for a student
  public Iterator getStudentsCourses(String SID){
    ArrayList courses = new ArrayList();
    Iterator enrolments = this.SE.iterator();
    
    while (enrolments.hasNext()){
      StudentEnrolment SE = (StudentEnrolment) enrolments.next();
      
      if (
	  SE.getStudent().getID().equals(SID)){
	
	courses.add(SE.getCourse());
      }
    }  
    return courses.iterator();
  }
  
    //all students courses for a semester 
  public Iterator getStudentCoursesSemester(
		   Iterator courses, String semester){
    
    ArrayList coursesArray = new ArrayList();

    while (courses.hasNext()){
      Course  co = (Course) courses.next();
      if (co.getSemester().equals(semester)){
	coursesArray.add(co); 
       }
    }
    return coursesArray.iterator();
  }
  
    //get one course
    public Course getOne(String CID, String sem){
      Iterator iter = this.courses.iterator();
      Course compare = new Course("none",CID, sem);
      //return compare;
      while (iter.hasNext()){
      Course cs1 = (Course) iter.next();
      if (cs1.equals(compare)){
	return cs1;
      }
      }
 
      System.out.println("course not found");
      return null;
      
  }
  
  //get all courses
  public Iterator getAllCourses(){
    return this.courses.iterator();	
  }

  //get all courses filtered by semester  
  public Iterator getAllCoursesSemester(String semester ){
    Iterator iter = this.getAllCourses();
    ArrayList coursesArray = new ArrayList();
    
    while (iter.hasNext()){      
      Course  co = (Course) iter.next();
      if (co.getSemester().equals(semester)){
	coursesArray.add(co); 	
      }
    }
    return coursesArray.iterator(); 
  }
  
  //get all Students for course  
  public Iterator getAllStudents(String CID, String semester){
    ArrayList students = new ArrayList();
    Iterator iter =  this.getAll();
    StudentEnrolment oneSE = null;    
    Course dummy = new Course("null",CID, semester);
    
    while (iter.hasNext()){
      oneSE = (StudentEnrolment) iter.next();
      if(oneSE.getCourse().equals(dummy)
	 )
	{	  
	  students.add(oneSE.getStudent());; 
	}
    }   
    return students.iterator();
  }

  //delete an enrolment.
  public void delete(String StuID, String courseID, String semester ){
    
    StudentEnrolment delete = this.getOne(StuID, courseID, semester);
    
    Iterator iter = SE.iterator();
    
    while (iter.hasNext()){
      StudentEnrolment enrol = (StudentEnrolment) iter.next();
      if (delete.equals(enrol)){
	iter.remove();	   
      }
    }
  }
  
  //not implemented at this layer.  
  public void update(){
    
  }
  
  public void savePrint(String subject, Iterator SE, String filename){
    this.printerDelegate.saveAll(subject, SE, filename);
  }
}
