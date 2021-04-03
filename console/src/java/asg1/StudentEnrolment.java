package asg1;
import java.util.Iterator;
import asg1.Course;

public class StudentEnrolment{

  private  Course course;   
  private Student student;
  private String semester;

  public StudentEnrolment(Student stu, Course co, String sem)   {
    this.course = co;
    this.student = stu;
    this.semester = sem;
	
  }
    
    public boolean equals(Object enrolment){

       StudentEnrolment enrol = (StudentEnrolment) enrolment;

       if (enrol.getCourse().equals(this.getCourse())
	   && enrol.getStudent().equals(this.getStudent()))
	   //&& enrol.getSemester().equals(this.getSemester()))
	  {
	     return true;
	  }
	  return false;
	
       
    }
    
    public Student getStudent(){
      return this.student;
  }

   public Course getCourse(){
      return this.course;
   }

    public String getSemester(){
      return this.semester;
   }

 public String toString(){
   String enrolment = "";
      //
      
    enrolment += "NAME: " +  getStudent().getName();
     //enrolment += "  ENROLLED IN"+  getSemester() +  "\n"
    enrolment +=  "COURSE: " + getCourse().getCName() +  "\n\n";

    return enrolment;
   }
     

}
