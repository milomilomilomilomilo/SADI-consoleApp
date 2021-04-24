/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
  
*/

package asg1;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public interface StudentEnrolmentManager{
  
  //creates and adds Enrolment to College
  public abstract boolean add(String stuID, String CourseID, String sem);
  
  //gets all StudentEnrolments
  public abstract Iterator getAll();
  //returns one Student Enrolment
  public abstract StudentEnrolment getOne(String StudentID, String courseID,
					  String semester);
  public abstract void update();

  //deletes a student enrolment by course... 
  public abstract void delete(String studentID, String courseID,
			      String semester); 
}
