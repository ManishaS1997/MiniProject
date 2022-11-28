package com.velocity.mcq.projectcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class fetchStudentRecord {
	public int count_record=0;
	String query;
	public void fetch_student() throws SQLException
	{
	DAO dao=new DAO();
	Scanner sc=new Scanner(System.in);
	Connection conn=dao.getConnection();
	Statement st=conn.createStatement();
	
	String count_query="select count(sid) from question_set.student";
	
	ResultSet rs1=st.executeQuery(count_query);
	
	while(rs1.next())
	{
		count_record=rs1.getInt(1);
	}
	System.out.println("Enter choice from below");
	System.err.println("Press 1 if Do you want to check your score ");
	System.err.println("Press 2 if Do you want to check other student score record");
	int option=sc.nextInt();
	switch(option)
	{
	case 1: 
		 query="select * from question_set.student where sid=?;";
		PreparedStatement preparestatement1=conn.prepareStatement(query);
		preparestatement1.setInt(1, count_record);
		ResultSet rs2=preparestatement1.executeQuery();
		while(rs2.next())
		{
			int id=rs2.getInt(1);
			String sname=rs2.getString(2);
			int marks=rs2.getInt(3);
			
			System.out.print("sid: "+id+" name: "+sname+" marks: "+marks);
			System.out.println();
		}
		
		
		break;
	case 2: 
	System.out.println("Enter students id to check only between 1 to "+count_record);
	int sid=sc.nextInt();
	if(sid>=1 && sid<=count_record)
	{
		 query="select * from question_set.student where sid=?;";
		PreparedStatement preparestatement=conn.prepareStatement(query);
		preparestatement.setInt(1, sid);
		
		ResultSet rs=preparestatement.executeQuery();
		
		while(rs.next())
		{
			int id=rs.getInt(1);
			String sname=rs.getString(2);
			int marks=rs.getInt(3);
			
			System.out.print("sid: "+id+" name: "+sname+" marks: "+marks);
			System.out.println();
		}
		
	}
	else if(sid<=0 || sid>count_record)
	{
		System.out.println("Enter proper student id from 1 to "+count_record);
	}
	break;
	default : System.out.println("Invalid choice you can only enter 1 or 2");
		
	}
	

	}
	
	

}
