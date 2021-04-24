package asg1;
/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
  
*/

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;;
import java.io.IOException;

/* Provides concrete string-parsing and file-printing methods to reduce 
code re-use */

public abstract class Printer implements Printable{
    
  public abstract void saveAll(String subject, Iterator objs, String
			       filename);
  
  //splits string into tokens
  public String[] getDelimited(String phrase ){
    String delims = "[ ]+";
    String[] tokens = phrase.split(delims);
    return tokens;
  }
  
  //This method COPIED VERBATIM FROM SOURCE. Forget where.
  //writes CSV file.
  public void writeToCsvFile(List<String[]> thingsToWrite, String separator,
			     String fileName){
    try (FileWriter writer = new FileWriter(fileName)){
      for (String[] strings : thingsToWrite) {
	for (int i = 0; i < strings.length; i++) {
	  writer.append(strings[i]);
	  if(i < (strings.length-1))
	    writer.append(separator);
	}
	//	writer.append(System.lineSeparator());
      }
	    writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }    
  
  //wrapper method
  public void prepareCSV(String CSVreport, String fileName){
    
    String[] CSV = getDelimited(CSVreport);
    for (int i = 0; i < CSV.length; i++){
      System.out.println(CSV[i]);}
	
    String separator = ",";
    List<String[]> CSVlist = new ArrayList<String[]>();
    CSVlist.add(CSV);
    writeToCsvFile(CSVlist, separator, fileName);
    
  }
}
