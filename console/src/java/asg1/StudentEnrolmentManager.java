package asg1;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
 /* This interface must have the following methods: add, update, delete. getOne,
 getAll.*/  

public interface StudentEnrolmentManager{

   
   public abstract boolean add(String stuID, String CourseID);
    
   public abstract Iterator getAll(); //getAllStudents, getStudentsCourses 
   public abstract StudentEnrolment getOne(String StudentID, String courseID,
					   String semester);
    public abstract void update();
    //deletes a student enrolment by course... 
   public abstract void delete(String studentID, String courseID, String semester);
 

}
    //public abstract void add(String stuID);
    //   public abstract void displayAll(Iterator iter);
