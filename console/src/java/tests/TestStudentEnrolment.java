package tests;

import asg1.StudentEnrolment;
import asg1.Course;
import asg1.Student;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestStudentEnrolment{
   private StudentEnrolment SE_1;
   private StudentEnrolment SE_2;
   private StudentEnrolment SE_3;
   private StudentEnrolment SE_4;
    
   @Before 
   public void setup(){

       Course c1 = new Course("SADI", "CS303", "sem1_2021");
       Student s1 = new Student("milk", "1234abcd");

       Course c2 = new Course("SADI", "CS505", "sem1_2021");
       Course c3 = new Course("SADI", "CS303", "sem1_2024");
       Student s2 = new Student("milk", "1sdfbfdsgcd");
       //       Student s3 = new Student("milk", "1234abcd");
       
       SE_1 = new StudentEnrolment(s1, c1);
       SE_2 = new StudentEnrolment(s1, c2);
       SE_3 = new StudentEnrolment(s1, c3);
       SE_4 = new StudentEnrolment(s2, c1);
       //          SE_2 = new StudentEnrolment(s1, c1);
   }

   @Test
   public void testEquals() {

       //equals returns true as expected
       assertTrue(SE_1.equals(SE_1));
       //assertFalse(SE_1.equals(SE_1));

       //course ID differs.. returns false
       assertFalse(SE_1.equals(SE_2));

       //course Semester differs... returns false
       assertFalse(SE_1.equals(SE_3));

       //Student Id differs... returns false
       assertFalse(SE_1.equals(SE_4));
   }

    

}
