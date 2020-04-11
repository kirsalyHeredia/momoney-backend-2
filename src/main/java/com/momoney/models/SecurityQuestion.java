package com.momoney.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "security_questions")
public class SecurityQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "security_question_id")
	private Long securityQuestionId;
	
	@NotBlank
	@Column(name = "security_question")
	private String securityQuestion;

	public Long getSecurityQuestionId() {
		return securityQuestionId;
	}

	public void setSecurityQuestionId(Long securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	@Override
	public String toString() {
		return "SecurityQuestion [securityQuestionId=" + securityQuestionId + ", securityQuestion=" + securityQuestion
				+ "]";
	}

	public SecurityQuestion(Long securityQuestionId, @NotBlank String securityQuestion) {
		super();
		this.securityQuestionId = securityQuestionId;
		this.securityQuestion = securityQuestion;
	}

	public SecurityQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
