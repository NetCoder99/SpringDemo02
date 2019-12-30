package com.home.models.HumanResources;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ContactType database table.
 * 
 */
@Entity
@Table(name = "ContactType", schema = "Person")
@NamedQuery(name="ContactType.findAll", query="SELECT c FROM ContactType c")
public class ContactType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int contactTypeID;
	private Timestamp modifiedDate;
	private String name;

	public ContactType() {
	}

	
	@Override
	public String toString() {
	    return String.valueOf(this.contactTypeID) + ":" + this.name;	
	}
	
	@Id
	@Column(name="ContactTypeID")
	public int getContactTypeID() {
		return this.contactTypeID;
	}

	public void setContactTypeID(int contactTypeID) {
		this.contactTypeID = contactTypeID;
	}


	@Column(name="ModifiedDate")
	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	@Column(name="Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}