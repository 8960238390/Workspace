package Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;

public class CreateCourseAndStudentDemo {
	
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
				
		try {
			
			session.beginTransaction();
			
			Course course1 = new Course("Java");
			Course course2 = new Course("Spring");
			Course course3 = new Course("Hibernate");
			
			Student std1 = new Student("md","Sharif","sharif@gmail.com");
			Student std2 = new Student("md","Baqar","baqar@gmail.com");
			Student std3 = new Student("nitin","singh","nitin@gmail.com");
			
			//saving couse object
			session.persist(course1);
			session.persist(course2);
			session.persist(course3);
			
			//saving student object
			session.persist(std1);
			session.persist(std2);
			session.persist(std3);
			
			System.out.println("getting students"+course1.getStudents());
			
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
			session.close();
			factory.close();
		}

	}

}
