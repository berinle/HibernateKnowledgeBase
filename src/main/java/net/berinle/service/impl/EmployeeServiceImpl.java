package net.berinle.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.berinle.dao.CompanyDao;
import net.berinle.dao.EmployeeDao;
import net.berinle.dao.SkillDao;
import net.berinle.model.Company;
import net.berinle.model.Employee;
import net.berinle.model.Skill;
import net.berinle.service.EmployeeService;

@Service
@Transactional(readOnly=true)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private CompanyDao companyDao;
	@Autowired private SkillDao skillDao;
		
	
	@Transactional(readOnly=false)
	public void editEmployee(Employee emp, String[] companyIds, String[] skillIds) {
		List<Company> companies = companyDao.loadCompanies(companyIds);
		List<Skill> skills = skillDao.loadSkills(skillIds);
		
		//remove existing companies
		Set<Company> existingCompanies = emp.getCompanies();
		Set<Skill> existingSkills = emp.getSkills();
		
		//do for companies
		for(Company c: existingCompanies){
			emp.removeCompany(c);
		}
		for(Company c: companies){
			emp.addCompany(c);
		}
		
		emp = employeeDao.edit(emp);
		
		
		for(Skill s: existingSkills)
			emp.removeSkill(s);
		
		for(Skill s: skills){
			emp.addSkill(s);
		}
		
		emp = employeeDao.edit(emp);

	}

	public List<Employee> getAllEmployees() {		
		return employeeDao.getAll();
	}

	public Employee getEmployee(Long id) {
		return employeeDao.get(id);
	}

}
