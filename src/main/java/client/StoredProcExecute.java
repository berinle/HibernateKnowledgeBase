package client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import net.berinle.util.HibernateUtil;

public class StoredProcExecute {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		List list = s.getNamedQuery("sp_getemployees")
		.setParameter("param1", "1")
		.setParameter("param2", "2")
		.list();
		
		System.out.println(" list size: " + list.size());
		
		s.getTransaction().commit();
		
		System.out.println("=====================> Printing out lists...");
		for(Iterator i=list.iterator(); i.hasNext();){
			System.out.println(i.next());
		}
		
		s.close();
		sf.close();
	}
}
