package com.velocity.mcq.projectcode;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.ResultSet;
public class ExctractStudentDetails {
	
	
	public ArrayList<Student> al=new ArrayList<Student>();
	
	public void exctractStudent() throws SQLException
	{
		Student student=new Student();
		int sid=0,marks=0;
		
		String sname="";
		DAO dao=new DAO();
		Connection conn=dao.getConnection();
		Statement st=conn.createStatement();

		String query="select * from question_set.student;";
		
		ResultSet rs=st.executeQuery(query);
		
		
		while(rs.next())
		{
			sid=rs.getInt(1);
			student.setSid(sid);
			sname=rs.getString(2);
			student.setStud_name(sname);
			marks=rs.getInt(3);
			student.setMarks(marks);
		
			al.add(new Student(sid,sname,marks));
		}
		
	}
	public void sortMarks()
	{
		Collections.sort(al,new StudentSorting());
		
		System.out.println("Student details are sorted as per marks: ");	
		for(Student s:al)
		{
			System.out.print("sid: "+s.getSid()+" name: "+s.getStud_name()+" marks: "+s.getMarks());
			System.out.println();
		}
	}
	
}
