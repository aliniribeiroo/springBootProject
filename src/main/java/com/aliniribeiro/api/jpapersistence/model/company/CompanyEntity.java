package com.aliniribeiro.api.jpapersistence.model.company;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.aliniribeiro.api.jpapersistence.model.employee.EmployeeEntity;

@Entity
@Table(name = "company")
public class CompanyEntity implements Serializable {

	private static final long serialVersionUID = 9054312905365693357L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "socialname", nullable = false)
	private String socialName;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	@Column(name = "criationdate", nullable = false)
	private Date criationDate;
	
	@Column(name = "updatedate", nullable = false)
	private Date updateDate;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmployeeEntity> employees;

	public CompanyEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getCriationDate() {
		return criationDate;
	}

	public void setCriationDate(Date criationDate) {
		this.criationDate = criationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	
	@PreUpdate
	public void preUpdate() {
		updateDate = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date now = new Date();
		criationDate = now;
		updateDate = now;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", socialName=" + socialName + ", cnpj=" + cnpj + ", criationDate=" + criationDate
				+ ", updateDate=" + updateDate + "]";
	}

}
