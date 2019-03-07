package com.FilipFlorczyk.hybernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.FilipFlorczyk.hybernate.demo.entity.Student;

public class PrimaryKeyDemo
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
			System.out.println("Creating 3 Student objects");

			Student student1= new Student("Filip", "Florczyk", "ff@wp.pl");
			Student student2 = new Student("John", "Doe", "jd@wp.pl");
			Student student3 = new Student("Anon", "Anonski", "aa@wp.pl");

			session.beginTransaction();

			System.out.println("Saving students");
			session.save(student1);
			session.save(student2);
			session.save(student3);

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
