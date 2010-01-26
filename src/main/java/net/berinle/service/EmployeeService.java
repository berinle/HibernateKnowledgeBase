package net.berinle.service;

import java.util.List;

import net.berinle.model.Employee;

public interface EmployeeService {

	void editEmployee(Employee emp, String[] companyIds);

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);
}
