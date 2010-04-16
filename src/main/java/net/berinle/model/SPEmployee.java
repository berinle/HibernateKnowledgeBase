package net.berinle.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="SP_EMPLOYEE")
public class SPEmployee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	@Column(name="version") private long version;
	
	@Column(name="fname") private String firstName;
	@Column(name="lname") private String lastName;
	@Column(name="hire_date") private Date hireDate;
	@Column(name="emp_no") private String employeeNo;
	
	public SPEmployee(){}
	public SPEmployee(String fname, String lname, Date hireDate, String empNo) {
		this.firstName = fname;
		this.lastName = lname;
		this.hireDate = hireDate;
		this.employeeNo = empNo;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
}

