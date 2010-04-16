package net.berinle.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.berinle.dao.DummyDao;

@Repository
public class DummyDaoImpl implements DummyDao{

	@Autowired SessionFactory sessionFactory;
	
	public List getResults() {
		
		Session s = sessionFactory.openSession();
		
		try {
			System.out.println("***************** auto commit status: "
					+ s.connection().getAutoCommit());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List list = //sessionFactory.getCurrentSession().getNamedQuery("pqbGetRoundPwb")
			s.getNamedQuery("pqbGetRoundPwb")
		.setParameter("auctionId", 980)
		.setParameter("roundNum", 1)
		.setParameter("sortColumn", "1")
		.setParameter("sortOrder", "asc")
		.list();
		
		System.out.println(" list size: " + list.size());
		
		
		try {
			System.out.println("***************** auto commit status: "
					+ s.connection().getAutoCommit());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
