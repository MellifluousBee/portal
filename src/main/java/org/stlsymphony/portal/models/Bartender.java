package org.stlsymphony.portal.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("B")

public class Bartender extends User implements Serializable {

	/**
	 * serializable?
	 */
	private static final long serialVersionUID = 1L;
	public Bartender(String username, String password){

		this.username = username;
		this.pwHash = hashPassword(password);
	}
	public Bartender(){}
}

