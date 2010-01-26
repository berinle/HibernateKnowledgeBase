package net.berinle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.berinle.dao.CompanyDao;
import net.berinle.model.Company;
import net.berinle.service.CompanyService;

@Service
@Transactional(readOnly=true)
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	public List<Company> getAllCompanies() {
		return companyDao.getAll();		
	}

}
