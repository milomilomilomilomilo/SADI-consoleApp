package asg1;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public interface StudentEnrolmentManager{

  // public List<StudentEnrolment> Senrols = new ArrayList();
   public abstract void add(String name, String ID, String semester);
    //public abstract void add(String stuID);
    //   public abstract void displayAll(Iterator iter);
   public abstract Iterator getAll();
    public abstract StudentEnrolment getOne(String StudentID, String courseID,
					   String semester);
    public abstract void delete(String studentID, String courseID, String semester);
    //   public abstract void 
    /* This interface must have the following methods: add, update, delete. getOne, getAll.*/  
}
