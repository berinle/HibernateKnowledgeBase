package client;

import net.berinle.service.EmployeeService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxRollBackSpring {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeService empService = (EmployeeService) ctx.getBean("employeeService");
		
		empService.doMultipleThings();			
	}
}
