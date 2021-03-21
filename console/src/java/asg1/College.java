package asg1;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/*
   */
public class College implements StudentEnrolmentManager{
   private List<Course> courses = new ArrayList();
   private List<Student> students = new ArrayList();    
   private List<StudentEnrolment> SE = new ArrayList();

    /*Functions to prepopualte students and courses and to access them  */
   public void addStudent(Student student){
      this.students.add(student);
      System.out.println("student added to records");
   }

   public void addCourse(Course course){
       this.courses.add(course);
       
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

    
    //needs to check for mult enrolments.. etc.
   public void add(String studID, String courseID,
			   String semester){

     //TODO: check that the student is not already enrolled in course....
       
     Student s1 = getStudent(studID);
     Course c1 = getOne(courseID);
     
     this.SE.add(new StudentEnrolment(s1, c1, semester));
     //this.SE.add(new StudentEnrolment(new Student(name, ID),
     //				      new Course(),
     //				      semester));
      
     System.out.println("Student: " + s1.getID() + "successfully enroled in course:"
			    + c1.getCID());
   }

   public Iterator getAll(){
      return this.SE.iterator();
   }

    
    public StudentEnrolment getOne(String studentID, String courseID, String semester){

      Iterator iter =  this.getAll();
      StudentEnrolment oneSE = null;
      
      while (iter.hasNext()){
	 oneSE = (StudentEnrolment) iter.next();
	 if   (oneSE.getCourse().getCID().equals(courseID)
	       && oneSE.getStudent().getID().equals(studentID)
	       && oneSE.getSemester().equals(semester))
	   {
	   
	     return oneSE; 
	 }
      }
      
      return oneSE;
   }

    //display all enrolments 
   public void displayAll(String stuID, Iterator enrolments, String semester){

      System.out.println("Courses for " + stuID + "semester:" + semester);
      while (enrolments.hasNext()){
	 StudentEnrolment SE = (StudentEnrolment) enrolments.next();
	  
	 if (SE.getSemester().equals(semester) &&
	      SE.getStudent().getID().equals(stuID)){
	      System.out.println(SE.toString());
         }
       }
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
    //display all courses 
    public void displayAll(){
       Iterator iter = this.getAllCourses();
       while (iter.hasNext()){
          Course course = (Course) iter.next();
	  System.out.println(course.toString());
       }
    }
    
    public void delete(String StuID, String courseID, String semester ){

	StudentEnrolment delete = this.getOne(StuID, courseID, semester);
		
	Iterator iter = SE.iterator();
        /*StudentEnrolment delete = new StudentEnrolment(StuID,courseID, semester,
						      semester);  
	*/
       while (iter.hasNext()){
	   StudentEnrolment enrol = (StudentEnrolment) iter.next();
	   if (delete.equals(enrol)){
	       iter.remove();	   
	   }
    } 
}
}