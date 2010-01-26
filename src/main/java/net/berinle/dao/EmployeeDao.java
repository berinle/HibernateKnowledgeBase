package net.berinle.dao;

import java.util.List;

import net.berinle.model.Employee;

public interface EmployeeDao {

	void edit(Employee emp);

	List<Employee> getAll();

	Employee get(Long id);

}
