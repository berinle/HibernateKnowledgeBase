package client;

import java.util.List;

import net.berinle.model.Person;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class InClause {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		
		List<Long> ids = s.createQuery("select id from Person").list();
		System.out.println("# of ids: " + ids.size());
		
		s.createCriteria(Person.class)
		.add(Restrictions.in("id", ids))
		.list();
		
		s.getTransaction().commit();
		s.close();
	}
}
