package com.aliniribeiro.api.jpapersistence.model.realese;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aliniribeiro.api.jpapersistence.model.employee.EmployeeEntity;

@Entity
@Table(name = "realese")
public class RealeseEntity implements Serializable {

	private static final long serialVersionUID = 8765692641963787506L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "location", nullable = false)
	private String location;

	@Column(name = "criationdate", nullable = false)
	private Date criationDate;

	@Column(name = "updatedate", nullable = false)
	private Date updateDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "realesetype", nullable = false)
	private TypeEnum realeseType;

	@ManyToOne(fetch = FetchType.EAGER)
	private EmployeeEntity employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public TypeEnum getType() {
		return realeseType;
	}

	public void setType(TypeEnum type) {
		this.realeseType = type;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
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
		return "Realese [id=" + id + ", date=" + date + ", description=" + description + ", location=" + location
				+ ", criationDate=" + criationDate + ", updateDate=" + updateDate + ", type=" + realeseType + ", employee="
				+ employee + "]";
	}
}
