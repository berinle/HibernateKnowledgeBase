package client;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import net.berinle.model.Employee;
import net.berinle.util.HibernateUtil;

public class TxRollBack {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		
		for(int i=0; i<5; i++){
			Employee emp = new Employee();
			s.save(emp);
		}
		
		Employee rao = (Employee)s.createQuery("from Employee where id = 2")
		.uniqueResult();
		rao.setName("GURU");
		s.update(rao);
		
		for(int i=0;i<2; i++){
			Employee emp = new Employee();
			s.save(emp);
		}
		
		double ans = 3/0; //trigger exception
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
