package asg1;
import asg1.Course;
import asg1.Student;

import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;;
import java.io.IOException;

public class PrintStudents extends Printer{
    
   public void saveAll(String subject, Iterator objs, String
				 fileName){

   System.out.println("Printing report for: " + subject +
        "to file: " + fileName);   //for semester??
   
    
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
    
    public static void main(String[] args){

	Student S1 = new Student("milk", "1234");
	Course c1 = new Course("robots", "dfd3434", "sem_21" );
        Printer print = new PrintStudents();
	String phrase = "";
	//  String[]
	// print.getDelimited(S1.toString());
	String courseName = "RobotsAndLazers", CID = "c9898", semester = "sem1_2021"; 
    
	String subject =  " " + courseName + "  " + CID + "  " + semester +"\n";
	subject = subject.replace('\n', ' ' );
	String str = S1.toString();
	str = str.replace('\n', ' ' );
	String[] tokens =print.getDelimited(str + subject) ;

	
	for (int i = 0; i < tokens.length; i++)
	    System.out.println(tokens[i]);
	
      
	//print.getDelimited(c1.toString());
		
	//	writeToCsvFile(List<String[]> thingsToWrite, String separator,
	//		       String fileName){
	
    }
}


  

    

