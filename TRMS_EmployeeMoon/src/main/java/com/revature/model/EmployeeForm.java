package com.revature.model;

import java.sql.Time;
import java.util.Date;

public class EmployeeForm {
	
	//NEED TO MATCH HTML FORM NAMES	
		private int id;
		private String firstName;
		private String lastName;
		private int employeeId;
		private Date currDate;
		private Date eventDate;
		private String eventTime; 
		private String eventLocation;
		private double eventCost;
		private String eventType;
		private String description;
		private String gradingFormat;
		private String workRelJust;
		private String eventAttachment;
		private String workTimeMissed;
		private double estimatedReimbursement;
		
		public EmployeeForm() {
			super();

		}

		public EmployeeForm(int id, String firstName, String lastName, int employeeId, Date currDate, Date eventDate,
				String eventTime, String eventLocation, double eventCost, String eventType, String description,
				String gradingFormat, String workRelJust, String eventAttachment, String workTimeMissed,
				double estimatedReimbursement) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.employeeId = employeeId;
			this.currDate = currDate;
			this.eventDate = eventDate;
			this.eventTime = eventTime;
			this.eventLocation = eventLocation;
			this.eventCost = eventCost;
			this.eventType = eventType;
			this.description = description;
			this.gradingFormat = gradingFormat;
			this.workRelJust = workRelJust;
			this.eventAttachment = eventAttachment;
			this.workTimeMissed = workTimeMissed;
			this.estimatedReimbursement = estimatedReimbursement;
		}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public Date getCurrDate() {
			return currDate;
		}

		public void setCurrDate(Date currDate) {
			this.currDate = currDate;
		}

		public Date getEventDate() {
			return eventDate;
		}

		public void setEventDate(Date eventDate) {
			this.eventDate = eventDate;
		}

		public String getEventLocation() {
			return eventLocation;
		}

		public void setEventLocation(String eventLocation) {
			this.eventLocation = eventLocation;
		}

		public double getEventCost() {
			return eventCost;
		}

		public void setEventCost(double eventCost) {
			this.eventCost = eventCost;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getGradingFormat() {
			return gradingFormat;
		}

		public void setGradingFormat(String gradingFormat) {
			this.gradingFormat = gradingFormat;
		}

		public String getWorkRelJust() {
			return workRelJust;
		}

		public void setWorkRelJust(String workRelJust) {
			this.workRelJust = workRelJust;
		}

		public String getEventAttachment() {
			return eventAttachment;
		}

		public void setEventAttachment(String eventAttachment) {
			this.eventAttachment = eventAttachment;
		}

		public String getWorkTimeMissed() {
			return workTimeMissed;
		}

		public void setWorkTimeMissed(String workTimeMissed) {
			this.workTimeMissed = workTimeMissed;
		}

		public double getEstimatedReimbursement() {
			return estimatedReimbursement;
		}

		public void setEstimatedReimbursement(double estimatedReimbursement) {
			this.estimatedReimbursement = estimatedReimbursement;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		public String getEventTime() {
			return eventTime;
		}

		public void setEventTime(String eventTime) {
			this.eventTime = eventTime;
		}


		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@Override
		public String toString() {
			return "EmployeeForm [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeId="
					+ employeeId + ", currDate=" + currDate + ", eventDate=" + eventDate + ", eventTime=" + eventTime
					+ ", eventLocation=" + eventLocation + ", eventCost=" + eventCost + ", eventType=" + eventType
					+ ", description=" + description + ", gradingFormat=" + gradingFormat + ", workRelJust="
					+ workRelJust + ", eventAttachment=" + eventAttachment + ", workTimeMissed=" + workTimeMissed
					+ ", estimatedReimbursement=" + estimatedReimbursement + "]";
		}


		
}
