package asg1;
/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
  
*/

import java.util.Iterator;

public interface Printable {
  
  /*takes subject (e.g. Course or student description its reporting for) and
    iterator for that collection to save to file. */
  public abstract void saveAll(String subject, Iterator objs, String
			       filename);
  

 


}
