package asg1;
import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;;
import java.io.IOException;

public class PrintStudents implements Printable{
    
   public void saveAll(String subject, Iterator objs, String
				 filename){
    System.out.println("Printing report for: " + subject +
         "to file: " + filename);   //for semester??

    
    while (objs.hasNext() ){
      Student student = (Student) objs.next();
      String[] tokens =getDelimited(student.toString());
      for (int i = 0; i < tokens.length; i++)
	  System.out.println(tokens[i]);
      System.out.println(student.toString());
      
      
    }    
  }
    public String[] getDelimited(String phrase ){
	String delims = "[ ]+";
	String[] tokens = phrase.split(delims);
	return tokens;
    }
    
    //COPIED FROM SOURCE
    public void writeToCsvFile(List<String[]> thingsToWrite, String separator, String fileName){
	try (FileWriter writer = new FileWriter(fileName)){
	    for (String[] strings : thingsToWrite) {
		for (int i = 0; i < strings.length; i++) {
		    writer.append(strings[i]);
		    if(i < (strings.length-1))
			writer.append(separator);
		}
		writer.append(System.lineSeparator());
	    }
	    writer.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }    
}


  

    

