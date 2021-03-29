package asg1;

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
      details += "Course name: " + getCName()+ "\n";
      details += "Course ID: " + getCID() + "\n\n";
      details += "Semester: "+ "";
      return details;
   }
    

    /*  public static void main(String[] args){
	Course c1 = new Course();
	} */
}
