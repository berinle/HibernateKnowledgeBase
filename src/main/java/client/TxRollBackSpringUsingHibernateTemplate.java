package client;

import net.berinle.service.EmployeeService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxRollBackSpringUsingHibernateTemplate {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeService empService = (EmployeeService) ctx.getBean("employeeServiceUsingHibernateTemplate");
		
		empService.doMultipleThings();			
	}
}
