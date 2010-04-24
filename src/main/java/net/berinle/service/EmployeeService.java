package net.berinle.service;

import java.util.List;

import net.berinle.model.Employee;

public interface EmployeeService {

	void editEmployee(Employee emp, String[] companyIds, String[] skillIds);

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

	void add(Employee emp);

	void doMultipleThings();
}
