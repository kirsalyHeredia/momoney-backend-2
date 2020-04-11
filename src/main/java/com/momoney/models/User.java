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

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
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
	private Integer zip;
	
	@NotBlank
	@Positive
	@Size(min = 9, max = 9)
	@Column(name = "SSN", unique = true)
	private Integer SSN;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "security_question_id")
	private SecurityQuestion securityQuestion;
	
	@NotBlank
	@Column(name = "security_answer")
	private String securityAnswer;

	
	
}
