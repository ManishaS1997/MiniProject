package com.velocity.mcq.projectcode;


//creating pogo class and generating getters and setters to access stud record
public class Student
{

	private int sid;
	private  String stud_name; 
	private  int marks;
	
	Student()
	{
		//default constructor
	}
	Student(int id, String sname, int marks)
	{
		this.sid=id;
		this.stud_name=sname;
		this.marks=marks;
		
	}
	
	public int getSid() 
	{
		
		return sid;
	}
	public void setSid(int sid) 
	{
		
		this.sid = sid;
		
	}
	public String getStud_name() 
	{
		return stud_name;
	}
	public void setStud_name(String stud_name)
	{
		this.stud_name = stud_name;
	}
	public int getMarks() 
	{
		return marks;
	}
	public void setMarks(int marks) 
	{
		
		this.marks = marks;
	}
	
	
	
	
	
}
