package asg1;
/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)  
*/

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class PrintCourses extends Printer{

  //save Courses to file implementation.
  public void saveAll(String subject, Iterator objs, String
				 fileName){
    System.out.println("Printing report for: " + subject +
		       "to file: " + fileName);  
    
    
    String CSVreport = subject.replace('\n', ' ' );
    String details = "";
    
    //provide course details to string to be used by CSV function.
    while (objs.hasNext() ){
      Course course = (Course) objs.next();
      System.out.println(course.toString());
      details   += course.toString() + " ";      
    }
    
    CSVreport += details.replace('\n', ' ');
    prepareCSV(CSVreport, fileName);
  }
}


