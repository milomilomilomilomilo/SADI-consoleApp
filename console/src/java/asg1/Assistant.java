/*
  Author: Nathan Lankshear (s3529801) Class: SADI Tutor: Minh Vu Thanh
  Name: Assignment1 Console App  Submission Date: 20/04/21 (ELP extension)
  
*/
package asg1;

//Assistant enrols students. Used implicitly in the program as a delegate.
//We assume the assistant is always logged in. 

public class Assistant implements Role{
  
  public Assistant(){
  }
  
  public String getRole(){
    return "Assistant";
  }
  
}
