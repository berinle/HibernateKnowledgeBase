package net.berinle.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.berinle.dao.CompanyDao;
import net.berinle.dao.EmployeeDao;
import net.berinle.model.Company;
import net.berinle.model.Employee;
import net.berinle.service.EmployeeService;

@Service
@Transactional(readOnly=true)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Transactional(readOnly=false)
	public void editEmployee(Employee emp, String[] companyIds) {
		List<Company> companies = companyDao.loadCompanies(companyIds);
						
		//remove existing companies
		Set<Company> existingCompanies = emp.getCompanies();
		
		for(Company c: existingCompanies){
			emp.removeCompany(c);
		}
		
		//add new ones
		for(Company c: companies){
			emp.addCompany(c);
		}
		
		employeeDao.edit(emp);
	}

	public List<Employee> getAllEmployees() {		
		return employeeDao.getAll();
	}

	public Employee getEmployee(Long id) {
		return employeeDao.get(id);
	}

}
