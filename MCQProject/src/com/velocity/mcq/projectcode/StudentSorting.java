package com.velocity.mcq.projectcode;


import java.util.Comparator;
/*here student record will sort as per marks
we are displaying marks in desceding order 
by logic obj1<obj2 if 10<20 then swap so 20,10 likewise ...*/
public class StudentSorting implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) 
	{
		
		
		if(o1.getMarks()==o2.getMarks())
			return 0;
		else if(o1.getMarks()<o2.getMarks())//change 
			return 1;
		else
			return -1;//no change 
	}

	
	
}
