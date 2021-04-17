package asg1;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class PrintCourses extends Printer{
    
  public void saveAll(String subject, Iterator objs, String
				 fileName){
    System.out.println("Printing report for: " + subject +
         "to file: " + fileName);   //for semester??

    
   String CSVreport = subject.replace('\n', ' ' );
   String details = "";
   while (objs.hasNext() ){
      Course course = (Course) objs.next();
      System.out.println(course.toString());
      details   += course.toString() + " ";      
   }
   
   CSVreport += details.replace('\n', ' ');
   prepareCSV(CSVreport, fileName);

   //   String[] tokens =print.getDelimited(str + subject) ;

   /*
    String[] CSV = getDelimited(CSVreport);
    for (int i = 0; i < CSV.length; i++){
	System.out.println(CSV[i]);}

        String separator = ",";
	List<String[]> CSVlist = new ArrayList<String[]>();
	CSVlist.add(CSV);
	writeToCsvFile(CSVlist, separator, fileName);
   */
    }
 
   
}

    /*public static void main(String[] args){
	
      } */

