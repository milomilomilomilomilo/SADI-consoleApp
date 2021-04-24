package asg1;
/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
  
*/

public class Course{
  private String coursename;
  private String courseID;
  private String semester;
    
  public Course (String name, String ID, String semester){
    this.semester = semester;
    this.coursename = name;
    this.courseID = ID;   
  }
  
  public String getCName( ){
    return this.coursename;
  }
  
  public String getCID( ){
    return this.courseID;
  }
  
  public void setSemester(String semester){
    this.semester = semester;
  }
  
  public String getSemester(){
    return this.semester;
  }
  
  public String toString(){
    String details = "";
    details += "Course_name: " + getCName()+ " \n";
    details += "Course_ID: " + getCID() + " \n";
    details += "Semester: "+ getSemester() + " \n";
    return details;
  }
  
  public boolean equals(Object obj){
    Course co2 = (Course) obj;
    
    if (co2.getCID().equals(this.getCID())
	&& co2.getSemester().equals(this.getSemester())){
      return true;
	}
    return false;
  }
  

  
}
