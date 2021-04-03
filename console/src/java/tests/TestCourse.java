package tests;
import asg1.Course;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCourse extends TestCase{
    
    //tests equality conditions for Course objects
    @Test
    public void  testEquals(){
	Course c1 = new Course("SADI", "CS303", "sem1_2021");
	Course c2 = new Course("SADI", "CS303", "sem1_2021");
	Course c3 =  new Course("SADI", "CS304", "sem1_2021");
       	Course c4 =  new Course("SADI", "CS303", "sem1_2023");

	//returns true for equal object
	assertTrue(c1.equals(c2) == true);
	assertFalse(c1.equals(c2) == false);

	//ID does not match == false
	assertTrue(c1.equals(c3) == false);

	//sem does not match == false
	assertTrue(c1.equals(c4) == false);
    }
    
}
