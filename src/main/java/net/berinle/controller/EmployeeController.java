package net.berinle.controller;

import javax.servlet.http.HttpServletRequest;

import net.berinle.model.Employee;
import net.berinle.service.CompanyService;
import net.berinle.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value="/employee/list.do", method=RequestMethod.GET)
	public void list(Model model){
		model.addAttribute("employees", employeeService.getAllEmployees());
	}
	
	
	@RequestMapping(value="/employee/edit.do", method=RequestMethod.GET)
	public void edit(@RequestParam(required=true) Long id, Model model){
		model.addAttribute("employee", employeeService.getEmployee(id));
		model.addAttribute("companies", companyService.getAllCompanies());
	}
	
	@RequestMapping(value="/employee/edit.do", method=RequestMethod.POST)
	public String edit(@ModelAttribute Employee emp, BindingResult result, HttpServletRequest request){
		//String[] companyIds = ServletRequestUtils.getStringParameters(request, "companies");
		String[] companyIds = ServletRequestUtils.getStringParameters(request, "companyIds");
		if(!result.hasErrors()){
			employeeService.editEmployee(emp, companyIds);
		}
		
		return "redirect:list.do";
	}
}
