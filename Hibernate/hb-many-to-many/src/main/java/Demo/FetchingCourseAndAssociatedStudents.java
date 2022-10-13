package Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;

public class FetchingCourseAndAssociatedStudents {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();

			Course course = session.get(Course.class, 1);
			System.out.println(course);
			System.out.println(course.getStudents());
			
			
			session.getTransaction().commit();

		} catch (Exception e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

	}

}
