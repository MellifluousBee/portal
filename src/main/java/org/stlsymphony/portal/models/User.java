package org.stlsymphony.portal.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@MappedSuperclass
@Table(name="user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name= "job_type")
public class User{

	protected String username; 
	protected String pwHash;
	protected static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	protected String phoneNumber;
	protected String email;
	private int Useruid;
	private List<BarSchedule>BarSchedule= new ArrayList<>();
		
		public User(String username, String password, String phoneNumber, String email) {
			
			if (!isValidUsername(username)) {
				throw new IllegalArgumentException("Invalid username");
			}
			
			this.username = username;
			this.pwHash = hashPassword(password);
			this.phoneNumber=phoneNumber;
			this.email=email;
			
		}
		

		//hibernate required no args// also hibernate requires setters
		public User() {}
	
		@Id//sets it as a primary key 
	    @GeneratedValue//hibernate generates a value for me
	    @NotNull
	    @Column(name = "user_uid", unique = true)
		public int getUserUid() {
			return this.Useruid;
		}
		
		protected void setUserUid(int Useruid) {
	        this.Useruid = Useruid;
	    }	
		
	    @Column(name = "pwhash")
		public String getPwHash() {
			return pwHash;
		}
		
	    public void setPassword(String password) {
			this.pwHash = User.hashPassword(password);
		}
		public void setPwHash(String pwhash) {
			this.pwHash = pwhash;
		}
		

	    @Column(name = "username", unique = true)//store this property in a column
		public String getUsername() {
			return username;
		}
		
		protected static String hashPassword(String password) {		
			return encoder.encode(password);
		}
		
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		@Column (name="phone")
		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		@Column (name="email")
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		//checks that the password matches
		//need a user object to do this user.isMatchingPassword(...)
		public boolean isMatchingPassword(String password) {
			return encoder.matches(password, pwHash);
		}
		
		public static boolean isValidPassword(String password) {
			Pattern validUsernamePattern = Pattern.compile("(\\S){6,20}");
			Matcher matcher = validUsernamePattern.matcher(password);
			return matcher.matches();
		}
		
		public static boolean isValidUsername(String username) {
			Pattern validUsernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
			Matcher matcher = validUsernamePattern.matcher(username);
			return matcher.matches();
		}
		//want to be able to add pictures for each user

		@OneToMany(cascade=CascadeType.ALL)
		public List <BarSchedule>getBarSchedule(){
			return BarSchedule;
		}
		
		public void setBarSchedule(List<BarSchedule> BarSchedule){
			this.BarSchedule=BarSchedule;
		}
	

		
	

		


}
