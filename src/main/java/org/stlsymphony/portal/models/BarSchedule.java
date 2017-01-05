package org.stlsymphony.portal.models;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity //this is an object I want you to store in database
@Table(name = "barschedule")
public class BarSchedule extends AbstractSchedule{
	//make a table in DB for schedules, each schedule will be a different row in the table

			//has a:
			public String day;//i.e. Friday
			public LocalDate date; //will this timestamp or input anydate?
			public String calltime;//5:30PM or 12:30PM
			public ArrayList<Bartender>bartenders;
			
			public BarSchedule(){
				//no args required for hibernate
			}
			//constructor
			public BarSchedule(String day, LocalDate date, String calltime, ArrayList<Bartender>bartenders){
				super();
				this.day=day;
				this.date=date;
				this.calltime=calltime;
				this.bartenders= bartenders;
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
			public String getCallTime(){
				return this.calltime;
			}
			
			public String setCallTime(String calltime){
				return this.calltime=calltime;
			}
			@Column(name="scheduled_bartenders")
			public ArrayList<Bartender> getBartenders(){
				return this.bartenders;
			}
			public void setBartenders(ArrayList<Bartender> bartenders){
				return;
			}
			
			public void addBartender(Bartender b){
				bartenders.add(b);
			}

}
