package net.berinle.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import net.berinle.dao.EmployeeDao;
import net.berinle.model.Employee;

@Repository("employeeDaoHibernateTemplate")
public class EmployeeDaoUsingHibernateTemplateImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Employee edit(Employee emp) {
		return (Employee)hibernateTemplate.merge(emp);
	}

	public Employee get(Long id) {
		return (Employee) hibernateTemplate.get(Employee.class, id);
	}

	public List<Employee> getAll() {
		return hibernateTemplate.loadAll(Employee.class);
	}

}
