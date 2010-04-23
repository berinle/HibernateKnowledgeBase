package client;

import net.berinle.model.Employee;
import net.berinle.service.EmployeeService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxRollBackSpring {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeService empService = (EmployeeService) ctx.getBean("employeeService");
		
		for(int i=0; i<5; i++){
			Employee emp = new Employee();
			empService.add(emp);
		}
		
		Employee rao = (Employee)empService.getAllEmployees().get(0);		
		rao.setName("GURU");
		empService.add(rao);
		
		for(int i=0;i<2; i++){
			Employee emp = new Employee();
			empService.add(emp);
		}
		
		double ans = 3/0; //trigger exception		
	}
}
