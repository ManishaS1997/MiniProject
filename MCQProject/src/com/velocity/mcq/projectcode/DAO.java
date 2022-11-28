package com.velocity.mcq.projectcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;
public class DAO 
{
	/*one connection class is created 
	 * so each do not need to write connection username, password in each class
	 */
	String username="root";
	String password="123456";
	static final String DB_URL="jdbc:mysql://localhost:3306/question_set";
	public Connection getConnection()
	{
		
	Connection conn=null; // step 1 open a connection 
	try
	{
		//STEP 2:REGISTER JDBC DRIVER
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//STEP 3: OPEN A CONNECTION
				//System.out.println("connected to database Successfully");
				
		 conn=DriverManager.getConnection(DB_URL,username,password);
		


	}
	catch(Exception e)
	{
		System.out.println("Unable to connect database"+e);
	}
	return conn;
	}

}

