package asg1;


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/*
 */

public class College implements StudentEnrolmentManager{
  private List<Course> courses = new ArrayList();
  private List<Student> students = new ArrayList();    
  private List<StudentEnrolment> SE = new ArrayList();
  public Scanner pause = new Scanner(System.in);
  private Printable printerDelegate;

  
  public College(){}
  /*Functions to prepopualte students and courses and to access them  */
  public void addStudent(Student student){
    this.students.add(student);
    System.out.println("student added to records");
   }

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
  public Course getCourse(String courseID ){
    Iterator iter = this.courses.iterator();
      while (iter.hasNext()){
	Course cs1 = (Course) iter.next();
	if (cs1.getCID().equals(courseID)){
	  return cs1;
	}  
      }
      System.out.println("course not found");
      
       return  null;
  }
  
  //adds an enrolment to student and course.
  public boolean add(String studID, String courseID){
    
    Student s1 = getStudent(studID);
    Course c1 = getOne(courseID);
    
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
    Course mockcourse = new Course("dummy", courseID, semester);
    Student mockstudent = new Student("none", studentID);
      
    while (iter.hasNext()){
      oneSE = (StudentEnrolment) iter.next();
      if   (oneSE.getCourse().equals(mockcourse)
	    && oneSE.getStudent(
				   ).equals(mockstudent)
	    
	    ){
	
	return oneSE; 
      }
    }
    return oneSE;
  }
  
  //display all (Course) enrolments for a student... in semester.. ??
  public void displayAll(String stuID, String semester){
    System.out.println(semester);  
    Iterator allCourses = this.getStudentsCourses(stuID);
    Iterator semCourses = this.getStudentCoursesSemester(
							 allCourses, semester);
    System.out.println("Courses for " + stuID + "semester:" + semester);
    while (semCourses.hasNext()){
      Course enrolled = (Course) semCourses.next();
      System.out.println(
			 "this is one course in array...");
      
      System.out.println(enrolled.toString());
      /* if (//SE.getSemester().equals(semester) &&
	 SE.getStudent().getID().equals(stuID)){	 
	 }*/
    }
  }
  
  //Get all courses for a student
  public Iterator getStudentsCourses(String SID){
    ArrayList courses = new ArrayList();
    Iterator enrolments = this.SE.iterator();
    
    while (enrolments.hasNext()){
      StudentEnrolment SE = (StudentEnrolment) enrolments.next();
      
      //unsure how to reduce...
      if (//SE.getCourse().getSemester().equals(semester) &&
	  SE.getStudent().getID().equals(SID)){
	//System.out.println(SE.toString());
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
      //SE.getCourse().getSemester().equals(semester) &&
      
      Course  co = (Course) courses.next();
      if (co.getSemester().equals(semester)){
	coursesArray.add(co); 
	
      }
    }
    return coursesArray.iterator();
  }
  
  //get one course
  public Course getOne(String CID){
    Iterator iter = this.courses.iterator();
    while (iter.hasNext()){
      Course cs1 = (Course) iter.next();
      if (cs1.getCID().equals(CID)){
	return cs1;
      }
      
    }
    System.out.println("course not found");
    
    return  null;
  }
  
  //get all courses
  public Iterator getAllCourses(){
    return this.courses.iterator();	
  }

  public Iterator getAllCoursesSemester(String semester ){
    Iterator iter = this.getAllCourses();
    ArrayList coursesArray = new ArrayList();
    
    while (iter.hasNext()){
      //SE.getCourse().getSemester().equals(semester) &&
      
      Course  co = (Course) iter.next();
      if (co.getSemester().equals(semester)){
	coursesArray.add(co); 
	
      }
    }
    return coursesArray.iterator();
  
  }
  //get all Students for course  ?? 
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
  
  //
  public void delete(String StuID, String courseID, String semester ){
    
    StudentEnrolment delete = this.getOne(StuID, courseID, semester);
    
    Iterator iter = SE.iterator();
    /*StudentEnrolment delete = new StudentEnrolment(StuID,courseID
     );  
    */
     while (iter.hasNext()){
      StudentEnrolment enrol = (StudentEnrolment) iter.next();
      if (delete.equals(enrol)){
	iter.remove();	   
      }
    }
  }

  public void update(){
      
  }
  
  public void savePrint(String subject, Iterator SE, String filename){
    this.printerDelegate.saveAll(subject, SE, filename);
  }
  /*
  public void saveAll(){
    System.out.println("Printing report for: " + subject +
         "to file: " + filename);   //for semester??
    
    while (SE.hasNext() ){
      Course course = (Course) SE.next();
      System.out.println(course.toString()); 
      //      pause.nextLine();
    }
    
  }
  */
    /*    public static void main(String[] args) {
	College co1 = new College();
	
	
	} */
}
