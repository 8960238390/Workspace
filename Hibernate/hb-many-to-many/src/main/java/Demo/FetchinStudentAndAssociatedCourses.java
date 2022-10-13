package Demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;

public class FetchinStudentAndAssociatedCourses {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
				
		try {
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			System.out.println("student:"+student);
//			
			Course course1 = session.get(Course.class, 1);
			Course course2 = session.get(Course.class, 2);
			
//			
//			course1.addStudent(student);
//			course2.addStudent(student);
//			course3.addStudent(student);
//			
//			session.save(course1);
//			session.save(course2);
//			session.save(course3);
			
			
			
			List<Course> courseList = new ArrayList<>();
			courseList.add(course1);
			courseList.add(course2);
			
			student.setCourses(courseList);
			
			
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
			
		}

	}

}
