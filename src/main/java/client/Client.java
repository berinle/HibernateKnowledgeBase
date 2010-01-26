package client;

import net.berinle.model.Company;
import net.berinle.model.Employee;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Client {

	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session s = sessionFactory.openSession();
			s.beginTransaction();
			
			Employee yinka = (Employee)s.createQuery("from Employee where id = :id" )
			.setParameter("id", 2L)
			.uniqueResult();
			
			yinka.addCompany((Company)s.load(Company.class, new Long(1)));
			yinka.removeCompany((Company)s.load(Company.class, new Long(2)));
			yinka.removeCompany((Company)s.load(Company.class, new Long(3)));
			
			s.getTransaction().commit();
			s.close();
			sessionFactory.close();			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
