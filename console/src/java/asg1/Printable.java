package asg1;

import java.util.Iterator;

public interface Printable {

   //  public abstract void printAll(Iterator objs);
   //takes subject e.g. Course or student description its reporting for and
   //iterator for that collection to save to file.
    public abstract void saveAll(String subject, Iterator objs, String
				 filename);
  

 


}
