package client;

import java.util.Iterator;
import java.util.List;

import net.berinle.util.HibernateUtilSybase;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public class SybaseStroedProcExecute {
	public static void main(String[] args) throws Exception{
		SessionFactory sf = HibernateUtilSybase.getSessionFactory();
		Session s = sf.openSession();
		
		
		s.connection().setAutoCommit(false);
		
		s.beginTransaction();
		
		//s.createSQLQuery("SET CHAINED OFF").executeUpdate();
		
		List list = s.getNamedQuery("pqbGetRoundPwb")
		.setParameter("auctionId", 980)
		.setParameter("roundNum", 1)
		.setParameter("sortColumn", "1")
		.setParameter("sortOrder", "asc")
		.list();
		
		System.out.println(" list size: " + list.size());
		
		s.getTransaction().commit();
		
		System.out.println("=====================> Printing out lists...");
		/*for(Iterator i=list.iterator(); i.hasNext();){
			System.out.println(i.next());
		}*/
		
		
		//s.createSQLQuery("SET CHAINED ON").executeUpdate();
		s.connection().setAutoCommit(false);
		s.close();
		sf.close();
	}
}
