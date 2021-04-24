/*
  Author: Nathan Lankshear (s3529801) Class: SADI
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
 */

package asg1;
import java.util.Iterator;
import asg1.Course;


public class StudentEnrolment{
  
  private  Course course;   
  private Student student;
  
  public StudentEnrolment(Student stu, Course co)   {
    this.course = co;
    this.student = stu;
    
  }
    
  public boolean equals(Object enrolment){
    
    StudentEnrolment enrol = (StudentEnrolment) enrolment;
    
    if (enrol.getCourse().equals(this.getCourse())
	&& enrol.getStudent().equals(this.getStudent()))
      
      {
	return true;
      }
    return false;
  }
  
  public Student getStudent(){
    return this.student;
  }
  
  public Course getCourse(){
    return this.course;
  }
  
  public String toString(){
    String enrolment = "";
    
    enrolment += "NAME: " +  getStudent().getName();
    enrolment +=  "COURSE: " + getCourse().getCName() +  "\n\n";
    
    return enrolment;
  }
  
  
}
