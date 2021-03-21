package asg1;

public class Course{
  private String coursename;
  private String courseID;
    
  public Course (String name, String ID){
      
      this.coursename = name;
      this.courseID = ID;   
   }

   public String getCName( ){
      return this.coursename;
   }

   public String getCID( ){
	return this.courseID;
   }
    
   public String toString(){
      String details = "";
      details += "Course name: " + getCName()+ "\n";
      details += "Course ID: " + getCID() + "\n\n";
      return details;
   }
    

    /*  public static void main(String[] args){
	Course c1 = new Course();
	} */
}
