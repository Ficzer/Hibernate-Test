package com.FilipFlorczyk.hybernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.FilipFlorczyk.hybernate.demo.entity.Student;


public class CreateStudentDemo
{

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			System.out.println("Creating new Student object");
			
			Student student = new Student("Filip", "Florczyk", "ff@wp.pl");
			
			session.beginTransaction();
			
			System.out.println("Saving student");
			session.save(student);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		catch (Exception e)
		{
			
		}
		finally 
		{
			factory.close();
		}

	}

}
