package com.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employeeId",unique = true)
	private int employeeId;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="email",unique = true,nullable = false)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "employeeEntity",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	/* @JoinColumn(name="employeeId") */
	private List<AccountEntity> accountEntity=new ArrayList<AccountEntity>();

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountEntity> getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(List<AccountEntity> accountEntity) {
		this.accountEntity = accountEntity;
	}


}
