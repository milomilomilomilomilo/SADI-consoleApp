package asg1;

import java.util.Date;

public class Student implements Role{
    
   private String name;
   private String ID;
   private Date DOB;

   public Student(String name, String ID){
      this.name = name;
      this.ID = ID;
      System.out.println();
   }

    
   public String getName(){
      return this.name;

   }

   public String getID(){
      return this.ID;
   }

   public String getRole(){
      return "Student";
   }


    

    /*
   public static void printDate(){
       Date d = new Date();
     System.out.println(d);
   }
    
   public static void main(String[] args){
      printDate(); 
       
      } */
}
