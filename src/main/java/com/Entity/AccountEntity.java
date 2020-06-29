package com.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class AccountEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="accountId",unique=true,nullable=false)
	private Integer accountId;
	
	@Column(name="accountNumber",unique = true)
	private String accountNumber;
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="employee_account",joinColumns = @JoinColumn(name="accountId",referencedColumnName = "accountId",nullable = true),inverseJoinColumns = @JoinColumn(name="employeeId",referencedColumnName = "employeeId",nullable = true))
	/* @JsonIgnoreProperties("accountEntity") */
	private EmployeeEntity employeeEntity;
}
