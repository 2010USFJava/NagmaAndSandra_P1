package com.revature.bean;

import java.util.Date;

public class EmployeeForm {
	
	private String username; //1
	private Date date; //2
	private Date time; //3
	private String location; //4
	private String description;  //5
	private double cost;  //6
	private String gradingFormat;  //7
	private int eventType;  //8
	private String workRelatedJustification; //9
	private String eventTypeAttachment; //10
	private String emailAttachment; //11
	private double workTimeMissed;  //12
	private double reimbursement; //13
	
	// Constructors for each Approver
	
	public EmployeeForm() {
		super();
	}
	
	// [1] BenCo : Access to everything
	
	public EmployeeForm(String username, Date date, Date time, String location, String description, double cost,
			String gradingFormat, int eventType, String workRelatedJustification, String eventTypeAttachment,
			String emailAttachment, double workTimeMissed, double reimbursement) {
		super();
		this.username = username;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.workRelatedJustification = workRelatedJustification;
		this.eventTypeAttachment = eventTypeAttachment;
		this.emailAttachment = emailAttachment;
		this.workTimeMissed = workTimeMissed;
		this.reimbursement = reimbursement;
	}


	// [5] Management : Access to presentation
	public EmployeeForm(String gradingFormat) {
		super();
		this.gradingFormat = gradingFormat;
	}
	
	// [6] Direct Manager : Access to presentation {
	public EmployeeForm(String gradingFormat, int eventType) {
			super();
			this.gradingFormat = gradingFormat;
			this.eventType = eventType;
		}
	
	
	
	
	
	
}
