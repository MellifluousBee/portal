package org.stlsymphony.portal.models;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;


	@MappedSuperclass //pushes Uid info into the database
	public class AbstractSchedule{
	////creates unique user id for all the schedule classes that will be stored in the database
	//all classes have a UID in a table in the DB
		private int uid;

		
		@Id//sets it as a primary key 
	    @GeneratedValue//hibernate generates a value for me
	    @NotNull//value must exist
	    @Column(name = "uid", unique = true)//makes the getter a column in DB table
		public int getUid() {
			return this.uid;
		}
		
		protected void setUid(int uid) {
	        this.uid = uid;
	    }
	

}
