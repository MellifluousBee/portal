package org.stlsymphony.portal.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="barSchedule")
public class BarSchedule implements Serializable {
	//has a:
		private int id;
		private ShiftCalendar ShiftCalendar= new ShiftCalendar();
		private Bartender bartender=new Bartender();
	
			public BarSchedule(ShiftCalendar ShiftCalendar, Bartender bartender){
				this.ShiftCalendar=ShiftCalendar;
				this.bartender=bartender;
			}
			public BarSchedule(){
				//hibernate required no args constructor
			}
			@Id @GeneratedValue
			public int getid(){
				return this.id;}
		
			public int setid(int id){
				return this.id=id;
			}
			
			@ManyToOne
			@JoinColumn(name="shift_uid", 
						foreignKey=@ForeignKey(name="FK_ShiftCalendar"))
			public ShiftCalendar getShiftCalendar() {
				return ShiftCalendar;
			}

			public void setShiftCalendar(ShiftCalendar shiftCalendar) {
				ShiftCalendar = shiftCalendar;
			}

			
			@ManyToOne
			@JoinColumn(name= "user_uid", foreignKey=
					@ForeignKey (name="FK_User"))
			public Bartender getBartender() {
				return bartender;
			}

			public void setBartender(Bartender bartender) {
				this.bartender = bartender;
			}

		
}