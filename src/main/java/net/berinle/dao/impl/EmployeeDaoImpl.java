package net.berinle.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.berinle.dao.EmployeeDao;
import net.berinle.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee edit(Employee emp) {
		//getting org.hibernate.NonUniqueObjectException: a different object with the same identifier value was already associated with the session: [net.berinle.model.Employee#2]
		//getSession().update(emp);
		
		//WORKS JUST FINE
		return (Employee)getSession().merge(emp);
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public List<Employee> getAll() {
		return getSession().createCriteria(Employee.class).list();
	}

	public Employee get(Long id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
