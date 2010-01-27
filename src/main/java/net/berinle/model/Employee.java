package net.berinle.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="employee")
public class Employee {

	private Long id;
	private String name;
	
	private Set<Company> companies = new HashSet<Company>();
	private Set<Skill> skills = new HashSet<Skill>();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * 	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="auction_groups",
			joinColumns=@JoinColumn(name="group_id"),
			inverseJoinColumns=@JoinColumn(name="auction_id"))
	 */
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="emp_comp",
			inverseJoinColumns=@JoinColumn(name="comp_id"),
			joinColumns=@JoinColumn(name="emp_id"))			
	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public void addCompany(Company company) {
		this.companies.add(company);
		company.getEmployees().add(this);
	}

	public void removeCompany(Company company) {
		this.companies.remove(company);
		company.getEmployees().remove(this);
	}
	
	public void addSkill(Skill skill){
		skills.add(skill);
		skill.getEmployees().add(this);
	}
	
	public void removeSkill(Skill skill){
		skills.remove(skill);
		skill.getEmployees().remove(this);
	}

	@ManyToMany(mappedBy="employees")
	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
}
