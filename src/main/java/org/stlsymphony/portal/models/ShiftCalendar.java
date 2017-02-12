package org.stlsymphony.portal.models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	@Entity
	@Table(name="shiftCalendar")
	public class ShiftCalendar{
	
		public String day;//i.e. Friday
		public LocalDate date; //will this timestamp or input anydate?
		public String calltime;//5:30PM or 12:30PM
		public List<BarSchedule> barschedule= new ArrayList<>();//joins table for associated bar schedule, one directional mapping foreign key
		public int shiftUid;
		
		public void setBarschedule(List<BarSchedule> barschedule) {
			this.barschedule = barschedule;
		}

		public ShiftCalendar(){
			//hibernate required no args constructor
		}
		
		public ShiftCalendar(String day, LocalDate date, String calltime){
			
			this.day=day;
			this.date=date;
			this.calltime=calltime;
			
		}
		
		@Id//sets it as a primary key 
	    @GeneratedValue//hibernate generates a value for me
	    @NotNull
	    @Column(name = "shift_uid", unique = true)
		public int getShiftUid() {
			return this.shiftUid;
		}
		
		protected void setShiftUid(int shiftUid) {
	        this.shiftUid = shiftUid;
	    }	
		@NotNull
	    @Column(name = "date")
		public LocalDate getDate(){
			return this.date;
		}
		public void setDate(LocalDate date){
			this.date=date;
		}
		@NotNull
	    @Column(name = "day")
		public String getDay(){
			return this.day;
		}
	
		public void setDay(String day){
			this.day=day;
		}
		
		@NotNull
	    @Column(name = "calltime")
		public String getCalltime(){
			return this.calltime;
		}
		
		public String setCalltime(String calltime){
			return this.calltime=calltime;
		}
	
		
		
		@OneToMany(cascade=CascadeType.ALL)
		private List<BarSchedule>getBarschedule(){
			return barschedule;
		}
		//need a function that takes the numBartenders and NumHead, checks the user exceptions table,
		//and generates a barschedule
		
		
//		}
}
