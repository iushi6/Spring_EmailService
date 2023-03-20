package co.springemail.EmailService.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="emp")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
//Table - Columns --->
	//Getters - Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	@Column(name = "login_id")
	private String loginId;
	
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

    @Column(nullable = true, name = "dob")
    private java.time.LocalDate dob;

    @Column(name = "user_status")
    private Integer userStatus;

    @Column(name = "user_role")
    private String userRole;


}
