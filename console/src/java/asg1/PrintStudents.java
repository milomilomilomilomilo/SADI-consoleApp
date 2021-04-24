package asg1;

/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
  
*/


import asg1.Course;
import asg1.Student;
import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;;
import java.io.IOException;

public class PrintStudents extends Printer{

  //Save the Courses students to file implementation.
  public void saveAll(String subject, Iterator objs, String
		      fileName){
    
    System.out.println("Printing report for: " + subject +
		       "to file: " + fileName); 
        
    String CSVreport = subject.replace('\n', ' ' );
    String details = "";
    
    while (objs.hasNext() ){
      Student student = (Student) objs.next();
      System.out.println(student.toString());
      details   += student.toString() + " ";      
    }
    
   CSVreport += details.replace('\n', ' ');
   prepareCSV(CSVreport, fileName);
   
  }
  	
}


  

    

