package com.revature.model;

import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

public class EmployeeForm {
	
	//NEED TO MATCH HTML FORM NAMES	
		private int id;
		private int employeeId;
		private int eventId;
		private Date currDate;
		private Time currTime; 
		private Date eventDate;
		private String eventLocation;
		private double eventCost;
		private String description;
		private String gradingFormat;
		private String workRelJust;
		private Blob eventAttachment;
		private String workTimeMissed;
		private double estimatedReimbursement;
		
		public EmployeeForm() {
			super();

		}

		public EmployeeForm(int id, int employeeId, int eventId, Date currDate, Time currTime, Date eventDate,
				String eventLocation, double eventCost, String description, String gradingFormat, String workRelJust,
				Blob eventAttachment, String workTimeMissed, double estimatedReimbursement) {
			super();
			this.id = id;
			this.employeeId = employeeId;
			this.eventId = eventId;
			this.currDate = currDate;
			this.currTime = currTime;
			this.eventDate = eventDate;
			this.eventLocation = eventLocation;
			this.eventCost = eventCost;
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

		public int getEventId() {
			return eventId;
		}

		public void setEventId(int eventId) {
			this.eventId = eventId;
		}

		public Date getCurrDate() {
			return currDate;
		}

		public void setCurrDate(Date currDate) {
			this.currDate = currDate;
		}

		public Time getCurrTime() {
			return currTime;
		}

		public void setCurrTime(Time currTime) {
			this.currTime = currTime;
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

		public Blob getEventAttachment() {
			return eventAttachment;
		}

		public void setEventAttachment(Blob eventAttachment) {
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

		@Override
		public String toString() {
			return "EmployeeForm [id=" + id + ", employeeId=" + employeeId + ", eventId=" + eventId + ", currDate="
					+ currDate + ", currTime=" + currTime + ", eventDate=" + eventDate + ", eventLocation="
					+ eventLocation + ", eventCost=" + eventCost + ", description=" + description + ", gradingFormat="
					+ gradingFormat + ", workRelJust=" + workRelJust + ", eventAttachment=" + eventAttachment
					+ ", workTimeMissed=" + workTimeMissed + ", estimatedReimbursement=" + estimatedReimbursement + "]";
		}
		

}
