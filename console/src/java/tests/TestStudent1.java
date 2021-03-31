package tests;
import asg1.Student;
import junit.framework.TestCase;

//import asg1.Student;
//import static org.junit.Assert.assertEquals;

public class TestStudent1 extends TestCase {
    
   public void testAdd() {
      String str = "Junit is working fine";
      assertEquals("Junit is not working fine",str);
      }
   public void testStudentName(){
      Student s1 = new Student("name", "id1");
      assertEquals("name",s1.getName());
   }
    public void testStudentID(){
       Student s1 = new Student("name", "id1");
       assertEquals("id1",s1.getID());	
    }

    
}
