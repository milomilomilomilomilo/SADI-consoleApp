package asg1;
import java.util.Iterator;
public class PrintCourses implements Printable{
    
  public void saveAll(String subject, Iterator objs, String
				 filename){
    System.out.println("Printing report for: " + subject +
         "to file: " + filename);   //for semester??

    
    while (objs.hasNext() ){
      Course course = (Course) objs.next();
      System.out.println(course.toString()); 
    }    
  }
}
