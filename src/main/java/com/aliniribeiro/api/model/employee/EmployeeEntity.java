package com.aliniribeiro.api.model.employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.aliniribeiro.api.model.company.CompanyEntity;
import com.aliniribeiro.api.model.realese.RealeseEntity;
import com.aliniribeiro.api.security.ProfileEnum;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = 2676777528084821096L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = true)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cpf", nullable = true)
	private String cpf;
	
	@Column(name = "hourlyvalue", nullable = true)
	private BigDecimal hourlyValue;
	
	@Column(name = "workinghoursdayvalue", nullable = true)
	private Float workingHoursDayValue;
	
	@Column(name = "lunchhoursvalue", nullable = true)
	private Float lunchHoursValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	private ProfileEnum profile;
	
	@Column(name = "criationdate", nullable = false)
	private Date criationDate;
	
	@Column(name = "updatedate", nullable = false)
	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CompanyEntity company;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RealeseEntity> realeses;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getHourlyValue() {
		return hourlyValue;
	}

	public void setHourlyValue(BigDecimal hourlyValue) {
		this.hourlyValue = hourlyValue;
	}

	public Float getWorkingHoursDayValue() {
		return workingHoursDayValue;
	}

	public void setWorkingHoursDayValue(Float workingHoursDayValue) {
		this.workingHoursDayValue = workingHoursDayValue;
	}

	public Float getLunchHoursValue() {
		return lunchHoursValue;
	}

	public void setLunchHoursValue(Float lunchHoursValue) {
		this.lunchHoursValue = lunchHoursValue;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
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

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public List<RealeseEntity> getRealeses() {
		return realeses;
	}

	public void setRealeses(List<RealeseEntity> realeses) {
		this.realeses = realeses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", hourlyValue=" + hourlyValue + ", workingHoursDayValue=" + workingHoursDayValue
				+ ", lunchHoursValue=" + lunchHoursValue + ", profile=" + profile + ", criationDate=" + criationDate
				+ ", updateDate=" + updateDate + ", realeses=" + realeses + "]";
	}
	
}
