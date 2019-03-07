package com.FilipFlorczyk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc 
{

	public static void main(String[] args) 
	{
		String jdbcUrlString = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try 
		{
			System.out.println("Connecting to database: " + jdbcUrlString);
			Connection myConnection = DriverManager.getConnection(jdbcUrlString, user, pass);
			System.out.println("Connection succesfull!!!");

		} 
		catch (Exception e) 
		{

		}
	}

}
