package com.velocity.mcq.projectcode;

public class countMarks {

	
	
	 public void  marksCalculation(int count)
	 {
		 
		 if(count>=8)
		 {
			 System.out.println("Good!. Keep it Up >>");
			 System.out.println("You got class A and total score is : "+count);
		 }
		 else if(count>5 && count <8)
		 {
			 System.out.println("Keep practising more >>");
			 System.out.println("You got class B and total score is : "+count);
		 }
		 else if(count==5)
		 {
			 System.out.println("Need more practice >>");
			 System.out.println("You got class C and total score is : "+count);
			 
		 }
		 else 
		 {
			 System.out.println("You are fail");
		 System.out.println("You got class D and total score is : "+count);
		 }
		 
	 }


}
