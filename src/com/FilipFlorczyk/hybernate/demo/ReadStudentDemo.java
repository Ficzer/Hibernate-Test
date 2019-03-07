package com.FilipFlorczyk.hybernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.FilipFlorczyk.hybernate.demo.entity.Student;

public class ReadStudentDemo
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

			Student student = new Student("Dafy", "Duck", "dd@wp.pl");

			session.beginTransaction();

			System.out.println("Saving student");
			session.save(student);

			session.getTransaction().commit();
			System.out.println("Done");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id: " + student.getId());
			
			Student theStudent = session.get(Student.class, student.getId());
			
			System.out.println("Done: " + theStudent);
			
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
