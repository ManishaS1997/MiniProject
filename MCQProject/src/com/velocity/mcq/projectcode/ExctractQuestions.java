package com.velocity.mcq.projectcode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ExctractQuestions {
	
	public static int  qno=0;
	/*this static question Number field which increment each time 
	will displayed to user as question _ no : 1,2,3, and increment serial wise 
	*/
	public static String question;
	public static String  option_A;
	public static String option_B;
	public static String option_C;
	public static String option_D;
	public static String correct_Answer;
	public static String correct_option;
	public static String correct_answer;
	public static int count=0;
	
	public ResultSet rs=null;
	public Statement st=null;
	public Connection conn=null;
	Scanner sc=new Scanner(System.in);
	
	public void MarksCounted()
	{
	 countMarks c=new countMarks(); 
	 c.marksCalculation(count);
	}
	
	
	public void exctract(int question_no) throws SQLException, InterruptedException
	{
		String query;
				//qno=1;
			DAO dao=new DAO();
			 conn=dao.getConnection();	
			 st=conn.createStatement();
			 
			 
					
				 query="select * from question_set.question_paper where qid="+question_no;
				rs=st.executeQuery(query);
				//System.out.println("Record fetched succesfully ");
				
				while(rs.next())
				{
					//question_no= rs.getInt(1);
					question=rs.getString(2);
					option_A=rs.getString(3);
					option_B=rs.getString(4);
					option_C=rs.getString(5);
					option_D=rs.getString(6);
					correct_answer=rs.getString(7);
					correct_option= String.valueOf(rs.getInt(8));
					
					
				}
				
				qno++;
				System.err.println("question number: "+qno);
				
				System.out.print("question: "+question+"\t");
				System.out.println();
				System.out.print("1: "+option_A+"\t");
				System.out.println();
				System.out.print("2: "+option_B+"\t");
				System.out.println();
				System.out.print("3: "+option_C+"\t");
				System.out.println();
				System.out.print("4: "+option_D+"\t");
				System.out.println();
				
				
				System.out.println("Enter option");
				String option=sc.next();
				int opt=Integer.parseInt(option);
				if(correct_option.equals(option))
				{
					System.out.println("Correct Answer !.. ");
					count=count+1;
				}
				else if(opt>4)
				{
					System.out.println("Invalid choice: start quiz again!..");
					System.exit(0);
				}
				else if(correct_option!=option)
				{
					System.err.println("Wrong answer !.. ");
					count=count+0;
					System.out.println("Correct answer is: "+correct_answer);
					
				}
			
				
				
				
				for(int i=0;i<=100;i++)
				{
					Thread.sleep(10);
				}
					
		System.out.println("<<<---***********************************************--->>>>");
		 System.out.println("\n");
			
					 
				//step 6: close all connections
				 conn.close();
					st.close();
					rs.close();
					
						
	}
	
	
}
