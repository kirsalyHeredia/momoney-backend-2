package com.momoney.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.momoney.jview.DataView;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@JsonView(DataView.AccountView.class)
	private Long userId;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "f_name")
	private String fName;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "l_name")
	private String lName;
	
	@NotBlank
	@Positive
	@Column(name = "dob")
	private String dob;
	
	@NotBlank
	@Email
	@Column(name = "email", unique = true)
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 40)
	@Column(name = "username", unique = true)
	private String username;
	
	@NotBlank
	@Size(min = 8)
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Column(name = "street_address")
	private String streetAddress;
	
	@NotBlank
	@Column(name = "city")
	private String city;
	
	@NotBlank
	@Column(name = "state")
	private String state;
	
	@NotBlank
	@Column(name = "zip")
	private Integer zip;
	
	@NotBlank
	@Positive
	@Size(min = 9, max = 9)
	@Column(name = "SSN", unique = true)
	private Long SSN;
	
	@NotBlank
	@Positive
	@Size(min = 10, max = 10)
	@Column(name = "phone_number", unique = true)
	private Long phoneNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "security_question_id")
	private SecurityQuestion securityQuestion;
	
	@NotBlank
	@Column(name = "security_answer")
	private String securityAnswer;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Long getSSN() {
		return SSN;
	}

	public void setSSN(Long sSN) {
		SSN = sSN;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public SecurityQuestion getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(SecurityQuestion securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public User(Long userId, @NotBlank @Size(max = 40) String fName, @NotBlank @Size(max = 40) String lName,
			@NotBlank @Positive String dob, @NotBlank @Email String email,
			@NotBlank @Size(min = 8, max = 40) String username, @NotBlank @Size(min = 8) String password,
			@NotBlank String streetAddress, @NotBlank String city, @NotBlank String state, @NotBlank Integer zip,
			@NotBlank @Positive @Size(min = 9, max = 9) Long sSN,
			@NotBlank @Positive @Size(min = 10, max = 10) Long phoneNumber, SecurityQuestion securityQuestion,
			@NotBlank String securityAnswer) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.email = email;
		this.username = username;
		this.password = password;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		SSN = sSN;
		this.phoneNumber = phoneNumber;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", dob=" + dob + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", streetAddress=" + streetAddress + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", SSN=" + SSN + ", phoneNumber=" + phoneNumber
				+ ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer + "]";
	}

	
}
