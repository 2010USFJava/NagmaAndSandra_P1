package com.revature.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class Reimbursements {
	// NEED TO MATCH HTML FORM NAMES
	private int id;
	private int eId;
	private int deptId;
	private Date date;
	private Time currentTime;
	private Date eDate;
	private String location;
	private String description;
	private double cost;
	private String gradingFormat;
	private int eventTypeId;
	private String workRelatedJustification;
	private Blob eventAttachment;
	private String timeMissed;
	private double estimatedReimbursement;
	private String status;
	private boolean supApproval;
	private boolean headApproval;
	private boolean bencoApproval;

	public Reimbursements() {
		super();
	}

	public Reimbursements(int id, int eId, int deptId, Date date, Time currentTime, Date eDate, String location,
			String description, double cost, String gradingFormat, int eventTypeId, String workRelatedJustification,
			Blob eventAttachment, String timeMissed, double estimatedReimbursement, String status, boolean supApproval,
			boolean headApproval, boolean bencoApproval) {
		super();
		this.id = id;
		this.eId = eId;
		this.deptId = deptId;
		this.date = date;
		this.currentTime = currentTime;
		this.eDate = eDate;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventTypeId = eventTypeId;
		this.workRelatedJustification = workRelatedJustification;
		this.eventAttachment = eventAttachment;
		this.timeMissed = timeMissed;
		this.estimatedReimbursement = estimatedReimbursement;
		this.status = status;
		this.supApproval = supApproval;
		this.headApproval = headApproval;
		this.bencoApproval = bencoApproval;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Time currentTime) {
		this.currentTime = currentTime;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getWorkRelatedJustification() {
		return workRelatedJustification;
	}

	public void setWorkRelatedJustification(String workRelatedJustification) {
		this.workRelatedJustification = workRelatedJustification;
	}

	public Blob getEventAttachment() {
		return eventAttachment;
	}

	public void setEventAttachment(Blob eventAttachment) {
		this.eventAttachment = eventAttachment;
	}

	public String getTimeMissed() {
		return timeMissed;
	}

	public void setTimeMissed(String timeMissed) {
		this.timeMissed = timeMissed;
	}

	public double getEstimatedReimbursement() {
		return estimatedReimbursement;
	}

	public void setEstimatedReimbursement(double estimatedReimbursement) {
		this.estimatedReimbursement = estimatedReimbursement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSupApproval() {
		return supApproval;
	}

	public void setSupApproval(boolean supApproval) {
		this.supApproval = supApproval;
	}

	public boolean isHeadApproval() {
		return headApproval;
	}

	public void setHeadApproval(boolean headApproval) {
		this.headApproval = headApproval;
	}

	public boolean isBencoApproval() {
		return bencoApproval;
	}

	public void setBencoApproval(boolean bencoApproval) {
		this.bencoApproval = bencoApproval;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", eId=" + eId + ", deptId=" + deptId + ", date=" + date + ", currentTime="
				+ currentTime + ", eDate=" + eDate + ", location=" + location + ", description=" + description
				+ ", cost=" + cost + ", gradingFormat=" + gradingFormat + ", eventTypeId=" + eventTypeId
				+ ", workRelatedJustification=" + workRelatedJustification + ", eventAttachment=" + eventAttachment
				+ ", timeMissed=" + timeMissed + ", estimatedReimbursement=" + estimatedReimbursement + ", status="
				+ status + ", supApproval=" + supApproval + ", headApproval=" + headApproval + ", bencoApproval="
				+ bencoApproval + "]";
	}
}