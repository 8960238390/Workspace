package Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;

public class gettingStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Student student = session.get(Student.class, 1);
			System.out.println(student);
			System.out.println(student.getCourses());
			
			
			session.getTransaction().commit();

		} catch (Exception e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

	}

}
