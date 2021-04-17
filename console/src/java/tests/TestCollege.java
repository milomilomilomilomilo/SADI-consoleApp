package tests;

import java.util.ArrayList;
import java.util.Iterator;
import asg1.StudentEnrolment;
import junit.framework.TestCase;

import asg1.StudentEnrolment;
import asg1.Course;
import asg1.Student;
import asg1.College;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.After;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCollege{
   private College college;

   @Before
   public void setup(){
      college = new College();

      //Four unique course objects
      Course c1 = new Course("SADI", "CS303", "sem1_2021");
      Course c2 = new Course("MACHINES", "CS505", "sem1_2021");
      Course c3 = new Course("SADI", "CS303", "sem2_2021"); 
      Course c4 = new Course("AI_LISP", "CS809", "sem1_2021");

      //
      college.addCourse(c1);
      college.addCourse(c2); college.addCourse(c3);
      college.addCourse(c4);

      
      //three students added "milk, biscuits, kem"
      Student s1 = new Student("milk", "1234abcd");
      Student s2 = new Student("biscuits", "2345efgh");
      Student s3 = new Student("kem", "3456ijkl");
      
      college.addStudent(s1);
      college.addStudent(s2);
      college.addStudent(s3);
      
      //non existing student
      //	Student nonStudent = college.getStudent("2323232");
   }
    @After
    public void tearDown(){
	college = new College();
    }
    
    @Test 
    public void addOne(){
       Student s1 = college.getStudent("1234abcd");
       Course c1 = college.getCourse("CS303", "sem1_2021");
       // Course c1 = new Course("SADI", "CS303", "sem1_2021");
       assertTrue(s1.getID().equals("1234abcd"));
       assertTrue(c1 != null);
       
       boolean enrolled =college.add(s1.getID(), c1.getCID(), c1.getSemester());
	//enrolled as expected...
       assertTrue(enrolled);
	
       boolean notenrolled  =college.add("not a student number",
					 c1.getCID(), c1.getSemester());
	//invalid student ID will not enrol
         assertFalse(notenrolled);

	 //invalid course ID will not enrol
          boolean notCourse = college.add(s1.getID(), "not a course code",
					  c1.getSemester());
	  assertFalse(notCourse);
       
        //add ... should check for mult enrolments.. etc. !!getOne first?
       
       // should check that the student is not already enrolled in course
    }
    
    @Test  
    public void testDelete(){
	
      Student s1 = college.getStudent("1234abcd");
      Course c1 = college.getCourse("CS809", "sem1_2021");
      Course c2 = college.getCourse("CS303", "sem1_2021");

      //add enrolment, test enrolment object exists
      college.add(s1.getID(), c1.getCID(),c1.getSemester());
      assertTrue(college.getAll().hasNext() == true);

      //delete enrolment and add one. Still iterator object remaining
      college.delete( s1.getID(), c1.getCID(), c1.getSemester());
      college.add(s1.getID(), c2.getCID(),c2.getSemester());
      assertTrue(college.getAll().hasNext() == true);
      //test to see hasNext() does not effect subsequent calls to iterator
      assertTrue(college.getAll().hasNext() == true);
      assertTrue(college.getAll().hasNext() == true);
      
      //delete last enrolment. No iterator objects remaining.
      college.delete( s1.getID(), c2.getCID(), c2.getSemester());
      assertFalse(college.getAll().hasNext() == true);
            
    }
 
    @Test
    public void testGetCoursesStudents(){

      Student s1 = college.getStudent("1234abcd");
      Student s2 = college.getStudent("2345efgh" );
      Student s3 = college.getStudent("3456ijkl");

      Course c1 = college.getCourse("CS303", "sem1_2021");

	//three students added to course 'CS303'
	college.add(s1.getID(), c1.getCID(),c1.getSemester());
	college.add(s2.getID(), c1.getCID(),c1.getSemester());
	college.add(s3.getID(), c1.getCID(),c1.getSemester());

	
	Iterator students = college.getAllStudents(c1.getCID(),
						   c1.getSemester());
       //assertTrue(iter.hasNext());
	
       ArrayList studentArray = new ArrayList();
       // assertTrue(courses.hasNext());
	
       while (students.hasNext()){
	   Student stu = (Student) students.next();
	   studentArray.add(stu);
       }
       
       //correct number of courses as added in setup.
      assertEquals(studentArray.size(),3 );
      
    }
   
    @Test  
    public void testGetStudentsCourses(){
	/*
      Course c1 = new Course("SADI", "CS303", "sem1_2021");
      Course c2 = new Course("MACHINES", "CS505", "sem1_2021");
      Course c3 = new Course("SADI", "CS303", "sem2_2021"); 
      Course c4 = new Course("AI_LISP", "CS809", "sem1_2021");

	 */	
	
      Course c1 = college.getCourse("CS303", "sem1_2021");
      Course c2 = college.getCourse("CS505", "sem1_2021");
      Course c3 = college.getCourse("CS303", "sem2_2021");

      Student s1 = college.getStudent("1234abcd");
      //add three course enrolments for student 's1234abcd'
      college.add(s1.getID(), c1.getCID(),c1.getSemester());
      college.add(s1.getID(), c2.getCID(),c2.getSemester());
      college.add(s1.getID(), c3.getCID(),c3.getSemester());
      
      Iterator courses =  college.getStudentsCourses("1234abcd");
      ArrayList courseArray = new ArrayList();
      //      assertTrue(courses.hasNext());
      while (courses.hasNext()){
	      Course co = (Course) courses.next();
	      courseArray.add(co);
       }

      //correct number of courses as added
      assertEquals(courseArray.size(),3 );
      
    }
    
    @Test
    public void testGetStudentsCoursesSemester(){
      /*
      Course c1 = new Course("SADI", "CS303", "sem1_2021");
      Course c2 = new Course("MACHINES", "CS505", "sem1_2021");
      Course c3 = new Course("SADI", "CS303", "sem2_2021"); 
      Course c4 = new Course("AI_LISP", "CS809", "sem1_2021");
	*/
	
      Course c1 = college.getCourse("CS303", "sem1_2021");
      Course c2 = college.getCourse("CS505", "sem1_2021");
      Course c3 = college.getCourse("CS303", "sem2_2021");

      Student s1 = college.getStudent("1234abcd");
      //add three course enrolments for student 's1234abcd'
      college.add(s1.getID(), c1.getCID(),c1.getSemester());
      college.add(s1.getID(), c2.getCID(),c2.getSemester());
      //different semsester
      college.add(s1.getID(), c3.getCID(),c3.getSemester());
      
	
      Iterator courses =  college.getStudentsCourses("1234abcd");
      ArrayList courseArray = new ArrayList();

      assertTrue(courses.hasNext());

      while (courses.hasNext()){
	      Course co = (Course) courses.next();
	      courseArray.add(co);
       }

      //correct number of courses as added in setup.
      assertTrue(courseArray.size() ==3 );

      Iterator courses_fresh = college.getStudentsCourses("1234abcd");  
      Iterator semester1_Courses = college.getStudentCoursesSemester(
					 courses_fresh, "sem1_2021");
      courseArray = new ArrayList();
      while (semester1_Courses.hasNext()){
          Course co = (Course) semester1_Courses.next();
	  courseArray.add(co);
      }
      
      //correct number of courses for semester 1
      assertEquals(2, courseArray.size());

      courses_fresh = college.getStudentsCourses("1234abcd");  
      Iterator semester2_Courses = college.getStudentCoursesSemester(
					 courses_fresh, "sem2_2021");
      courseArray = new ArrayList();
      while (semester2_Courses.hasNext()){
          Course co = (Course) semester2_Courses.next();
	  courseArray.add(co);
      }

      //correct number of courses for semester 2
      assertEquals(1, courseArray.size());

    }

    
    //return one student enrolment for one course
    @Test   //pass
    public void testGetOne(){
	Student s1 = college.getStudent("1234abcd");
	assertFalse(s1 == null);

	Student s2 = college.getStudent("2345efgh" );
	Student s3 = college.getStudent("3456ijkl");
	
	Course c1 = college.getCourse("CS303", "sem1_2021");
	
	//two students added to course 'CS303'
	college.add(s1.getID(), c1.getCID(),c1.getSemester());
	college.add(s2.getID(), c1.getCID(),c1.getSemester());

	StudentEnrolment testEnrolment_1 = college.getOne(
		s1.getID(),c1.getCID(), c1.getSemester());

	StudentEnrolment testEnrolment_2 = college.getOne(
			s2.getID(),c1.getCID(), c1.getSemester());

	assertTrue(testEnrolment_1 != null);
	
	//correct Enrolment  for student1 returned.
	assertEquals(testEnrolment_1.getStudent().getID(), s1.getID());
	
	//correct Enrolment  for student2 returned.
	assertTrue(testEnrolment_2 != null);
	assertEquals(testEnrolment_2.getStudent().getID(), s2.getID());
    }

     //update might make more sense in College Class?
    @Ignore
    public void testUpdate(){

    }
  
    @Ignore
    public void testGetAll(){

    }

    //incomplete
    @Ignore
    public void testSaveAll(){
	
    }
    @Ignore
    public void testGetOne_Course(){

	
    }
    @Ignore
    public void testGetAllStudents(){
	
    }
    
    //    public void testDisplayAll(){}
    /* Utility Methods for propulate  */
    //getCourse

    //getStudent

    //addCourse

    //addStudent
    
}
