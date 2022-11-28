package com.velocity.mcq.projectcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.sql.SQLException;


public class Main {
	
	public static int choice=0;
	public static int  random_question_number=0;
	public static void main(String[] args) throws SQLException,ClassNotFoundException, InterruptedException
	{
		
		
		
		Student student=new Student();//student object created
		//this code is implemented by anshit
		ExctractQuestions e=new ExctractQuestions();
		//this code is implemented by chetan
		//extract question object
		
		ExctractStudentDetails exctract=new ExctractStudentDetails();
		//exctracting student details from db object : stud
		//this code is implemented by manisha
		
		InsertStudentDetails insert=new InsertStudentDetails();
		//inserting student record into database object : insert
		//this code is implemented by anshit
		
		fetchStudentRecord fetch=new fetchStudentRecord();
		//this code is implemented by manisha
		//fetching the particular student record by creating object : fetch
		System.err.println("<<--           Welcome to Quiz           -->>");
		System.out.println("\n");
		Scanner sc=new Scanner(System.in);
		String name="";
			
		do
		{
		System.out.println("Enter the choice from below options: ");
		System.out.println("1: START");
		System.out.println("2: HELP");
		System.out.println("3: Fetch the students records by highest marks");
		System.out.println("4: Fetch the particular student record");
		System.out.println("5: EXIT");
		System.out.println("*****************************************************************");
		
		choice=sc.nextInt();
		switch(choice)
		{
		case 1: 
		
			System.out.println("Enter your name: ");
			name=sc.next();
			student.setStud_name(name);
			
			System.err.print("Best");
			Thread.sleep(100);
			System.err.print("Of");
			Thread.sleep(100);
			System.err.print("Luck");
			Thread.sleep(100);
			System.err.print(" "+name+"");
			
			System.out.println();
			ArrayList list=new ArrayList();
			for(int i=1;i<=10;i++)//we have 10 questions hence adding 10 no's to list
			{
				list.add(i);
				
			}
			Collections.shuffle(list);//it will shuffle list also will not repeat that number
			int a[]=new int[list.size()];
				for(int i=0;i<list.size();i++)
				{
					int n=(int) list.get(i);//type casting obj to int
					//here n is randomly generated number
					e.exctract(n);//passing randomly generated number to extract query/question
					
				}	
				e.MarksCounted();//this code is implemented by aaftab
				
			//System.out.println("Student name is :"+student.getStud_name());
			student.setMarks(ExctractQuestions.count);
			System.out.println("Your test is completed");
			int marks=student.getMarks();
			
			insert.insertOperation(name, marks);//inserting record into DB
			
					break;
		case 2:		Suggestion suggest=new Suggestion();
		//this code is implemented by Manisha
					suggest.display();
					break;
		case 3:		exctract.exctractStudent();
					exctract.sortMarks();
					break;
		case 4:		fetch.fetch_student();
					break;
		case 5: 	System.out.println("Terminated..");
					System.exit(0);
					break;
					
		default : System.out.println("Invalid choice");
				System.out.println("Enter Choice from 1 to 5 only!..");
		}
		}while(choice<=5);
	
		sc.close();
			
	}

}
