package client;

import net.berinle.model.Body;
import net.berinle.model.Hand;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class OneToManyCascadeClient {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		
		Body body = new Body();
		body.getHands().add(new Hand());
		body.getHands().add(new Hand());
		
		s.save(body);
		
		s.getTransaction().commit();
		s.close();
		sessionFactory.close();
	}
}
