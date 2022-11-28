package com.velocity.mcq.projectcode;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudentDetails {
	
	public Connection conn=null;
	Statement st=null;
	Scanner sc=new Scanner(System.in);
	 String sname;
	 int smarks;
	
	/*once test is given by the student : 
	 particular student record inserted into DB 
	 here ID is auto_increment in DB so security and integrity is 
	 achieved by not giving authority to user (stduent) to enter id
	 for ex. if user enter 101 id and if that Id already presented in DB 
	 then contraction is occur*/
	public void insertOperation(String name, int marks) throws SQLException
	{
		DAO dao=new DAO();
		
		 conn=dao.getConnection();
		 sname=name;
		 smarks=marks;
		 //System.out.println("Name "+name+"Marks "+marks);
		 st=conn.createStatement();
		 st.execute("insert into question_set.student(sname,marks) values('"+sname+"'"+","+smarks+");");
			
		//System.out.println("Record inserted Successfully");
		
		conn.close();
		st.close();
		
		
		
	}
	
}
