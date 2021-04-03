package tests;
import asg1.Student;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

//@RunWith(JUnit4.class)
public class TestStudent1{

   private Student s1;
   private Student s2;
    
   @Before
   public void setup(){
      s1 = new Student("milkman", "1234a");
      s2 = new Student("milkman", "3456a");  	
   }

   @Ignore
   public void testAdd() {
      String str = "Junit is working fine";
      assertEquals("Junit is working fine",str);
      }
    
    @Test
    public void testEquals(){
	assertFalse(s1.equals(s2) == true);

     
    }
    
}
