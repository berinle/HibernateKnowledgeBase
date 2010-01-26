package net.berinle.dao;

import java.util.List;

import net.berinle.model.Company;

public interface CompanyDao {

	List<Company> loadCompanies(String[] companyIds);

	List<Company> getAll();

}
