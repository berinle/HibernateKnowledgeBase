package client;

import java.util.Iterator;
import java.util.List;

import net.berinle.service.DummyService;
import net.berinle.util.HibernateUtilSybase;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSybaseStroedProcExecute {
	public static void main(String[] args) {
		//Going via Spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-sybase.xml");
		DummyService dummyService = (DummyService) ctx.getBean("dummyService");
		List results = dummyService.getResults();
		/*for(Iterator i=results.iterator(); i.hasNext();){
			System.out.println(i.next());
		}*/
		
		System.out.println("results size: " + results.size());
	}
}
