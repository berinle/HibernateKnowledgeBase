package net.berinle.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.berinle.dao.CompanyDao;
import net.berinle.model.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Company> loadCompanies(String[] companyIds) {
		Session session = sessionFactory.getCurrentSession();
		List<Company> result = new ArrayList<Company>();
		for(String id: companyIds){
			Long companyId = new Long(id);
			result.add( (Company) session.load(Company.class, companyId));
		}
		return result;
	}

	public List<Company> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Company.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
