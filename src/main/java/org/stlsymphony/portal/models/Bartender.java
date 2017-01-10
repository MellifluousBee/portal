package org.stlsymphony.portal.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("B")

public class Bartender extends User implements Serializable {

	/**
	 * serializable? - can be saved?
	 */
	private static final long serialVersionUID = 1L;
	public Bartender(){
		super();
	}
	
}


