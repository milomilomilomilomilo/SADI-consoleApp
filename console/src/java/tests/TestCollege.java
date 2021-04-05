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
	
      Course c1 = new Course("SADI", "CS303", "sem1_2021");
      Student s1 = new Student("milk", "1234abcd");
      Course c2 = new Course("MACHINES", "CS505", "sem4_2021");
      Course c3 = new Course("SADI", "CS303", "sem1_2024");
     
      Student s2 = new Student("biscuit", "1sdfbfdsgcd");
      
      Course c4 = new Course("AI_LISP", "CS809", "sem2_2021");
      
      college.addCourse(c1);
      college.addCourse(c2);
      college.addCourse(c3);
      college.addCourse(c4);
      
      college.addStudent(s1);
      college.addStudent(s2);
       //       Student s6 = college.getStudent();

       college.add(s1.getID(), c1.getCID());
       college.add(s1.getID(), c2.getCID());
       college.add(s1.getID(), c3.getCID());
       college.add(s2.getID(), c1.getCID());
       
       //
    }

    @After
    public void tearDown(){
       college = new College();
    }
    
    
    @Test   //pass
    public void testAdd_1(){

	//fetch student from prepoulated list
	Student s1 = college.getStudent("1234abcd");
	//fetch course
	Course c1 = college.getCourse("CS303");
	
	//non existing student
	//	Student nonStudent = college.getStudent("2323232");
	
	boolean enrolled =college.add(s1.getID(),
				 c1.getCID());
	//enrolled as expected...
	assertTrue(enrolled);

	boolean notenrolled  =college.add("not a student number",
				 c1.getCID());
	//invalid student not enrolled
	assertFalse(notenrolled);
	//invalid course not enrolled
	boolean notCourse = college.add(s1.getID(), "not a course code");

	assertFalse(notCourse);
	
      
	//add ... needs to check for mult enrolments.. etc. !!getOne first
	
	//add check that the student is not already enrolled in course


    }

    @Test    //problem.. needs to delete all objects?
    public void testDelete(){
	
	/*Student s1 = college.getStudent("1234abcd");
	college.add(s1.getID() ,"CS809");
	*/
	StudentEnrolment testEnrolment_1 = college.getOne(
				 "1234abcd","CS809", "sem2_2021");
	
	
	StudentEnrolment enrol = college.getOne(
	       	"1234abcd", "CS303", "sem1_2021");
       
	assertTrue(enrol != null);
	
        college.delete( "1234abcd", "CS303", "sem1_2021");
	college.delete(	"1234abcd", "CS303", "sem1_2021");
	college.delete(	"1234abcd", "CS303", "sem1_2021");
	  
	StudentEnrolment enrol_del = college.getOne(
	      "1234abcd", "CS303", "sem1_2021");
       
	assertTrue(enrol_del == null);

	
	
    }

    //incomplete
    public void testUpdate(){
	
    }

    //incomplete
    public void testSaveAll(){

    }

    public void testGetOne_Course(){

	
    }

    public void testGetAllStudents(){
	
    }
    
    @Test // 
    public void testGetCoursesStudents(){
	Iterator students = college.getAllStudents("CS303", "sem1_2021" );
	//assertTrue(iter.hasNext());
	
	ArrayList studentArray = new ArrayList();
	// assertTrue(courses.hasNext());
	
      while (students.hasNext()){
	      Student stu = (Student) students.next();
	      studentArray.add(stu);
       }

      //correct number of courses as added in setup.
      assertEquals(studentArray.size(),2 );
      
 	
    }
   
    @Test  //pass 
    public void testGetStudentsCourses(){
      Iterator courses =  college.getStudentsCourses("1234abcd");
      ArrayList courseArray = new ArrayList();
      assertTrue(courses.hasNext());

      while (courses.hasNext()){
	      Course co = (Course) courses.next();
	      courseArray.add(co);
       }

      //correct number of courses as added in setup.
      assertTrue(courseArray.size() ==3 );
      
    }
    
    @Test  //pass .. but tidy it up.
    public void testGetStudentsCoursesSemester(){

      Iterator courses =  college.getStudentsCourses("1234abcd");
      ArrayList courseArray = new ArrayList();

      assertTrue(courses.hasNext());

      while (courses.hasNext()){
	      Course co = (Course) courses.next();
	      courseArray.add(co);
       }

      //correct number of courses as added in setup.
      assertTrue(courseArray.size() ==3 );
      courseArray = new ArrayList();
      Iterator courses_fresh = college.getStudentsCourses("1234abcd");
      
      Iterator semesterCourses = college.getStudentCoursesSemester(
					 courses_fresh, "sem1_2021");
      while (semesterCourses.hasNext()){
          Course co = (Course) semesterCourses.next();
	  courseArray.add(co);
      }
      
      // correct amount according to semester...
      assertEquals(courseArray.size(), 2);

    }

    
    //return one student enrolment for one course
    @Test   //pass
    public void testGetOne(){
	Student s1 = college.getStudent("1234abcd");
	assertFalse(s1 == null);
	assertFalse(college.add(s1.getID() ,"CS809") == false);
	
	
	StudentEnrolment testEnrolment_1 = college.getOne(
				 "1234abcd","CS809", "sem2_2021");
	assertTrue(testEnrolment_1 != null);
	StudentEnrolment testEnrolment_2 = new StudentEnrolment(
			  college.getStudent("1234abcd"),college.getCourse("CS809"));

	//Identical enrolment returned from getOne method.
	assertTrue(testEnrolment_1.equals(testEnrolment_2));
	
	
    }
    
    public void testGetAll(){

    }
    //    public void testDisplayAll(){}
    /* Utility Methods for propulate  */
    //getCourse

    //getStudent

    //addCourse

    //addStudent
    
}
 
