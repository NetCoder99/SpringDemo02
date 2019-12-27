package com.home.models.HumanResources;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Department", schema = "HumanResources")
public class Department {

	private Integer DepartmentID;
	private String  GroupName;
	private Timestamp ModifiedDate;
	private String Name;

	public Department() {}

	public Department(Integer departmentID, String groupName, Timestamp modifiedDate, String name) {
		super();
		this.DepartmentID = departmentID;
		this.GroupName = groupName;
		this.ModifiedDate = modifiedDate;
		this.Name = name;
	}

	
	@Override
	public String toString() {
	    return this.DepartmentID.toString() + ":" + this.Name;	
	}
	
	@Id
	@Column(name="DepartmentID")
	public Integer getDepartmentID() {
		return this.DepartmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.DepartmentID = departmentID;
	}


	@Column(name="GroupName")
	public String getGroupName() {
		return this.GroupName;
	}

	public void setGroupName(String groupName) {
		this.GroupName = groupName;
	}


	@Column(name="ModifiedDate")
	public Timestamp getModifiedDate() {
		return this.ModifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.ModifiedDate = modifiedDate;
	}


	@Column(name="Name")
	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}


}