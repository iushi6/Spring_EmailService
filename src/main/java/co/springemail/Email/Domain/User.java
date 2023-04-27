package co.springemail.Email.Domain;

import java.io.Serializable;
import java.time.LocalDate;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;

@Entity
@Table
@EntityScan
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
//Table - Columns --->
	//Getters - Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	
	public User() {
	super();
}

	public User(String userName, String officialEmail, String personalEmail, String contactNo,
		String gender, LocalDate dob, Integer userStatus, String userRole) {
	super();
	this.userName = userName;
	this.officialEmail = officialEmail;
	this.personalEmail = personalEmail;
	this.contactNo = contactNo;
	this.gender = gender;
	this.dob = dob;
	this.userStatus = userStatus;
	this.userRole = userRole;
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.time.LocalDate getDob() {
		return dob;
	}

	public void setDob(java.time.LocalDate dob) {
		this.dob = dob;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "official_email")
	private String officialEmail;
	
	@Column(name = "personal_email")
	private String personalEmail;
	
    @Column(name = "contact_no")
    private String contactNo;
    
    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private java.time.LocalDate dob;

    @Column(name = "user_status")
    private Integer userStatus;

    @Column(name = "user_role")
    private String userRole;


}
