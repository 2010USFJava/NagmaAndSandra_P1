package com.revature.model;

public class CommunicationTable {
	// (25 TOTAL COLUMNS)
	
	// (READ ONLY VALUES) (3 total)
	private int formId; // [1]
	private int employeeId; // [2] 
	private double estimReimbursement; // [3]
	
	//Benco Approve (11 total)
	private String requestorNeedAdditionalInfoFrom; // [4]
	private String requesteeResponse;  // NAGMA replies // [5]
	private double alterReimbursmentAmount; // NAGMA pulls // [6]
	private String reasonForLargerAmount; // [7]
	private String exceedingAvailableFunds;  // [8]
	private double pendingAmountVal; // NAGMA pulls // [9]
	private String notifyEmployee;  // [10]
	private String employeeOptionToCancel; // NAGMA replies // [11]
	private String approvalStatus; // NAGMA pulls // [12]
	private String eventGrade; // NAGMA replies // [13]
	private String eventPresentation; //NAGMA replies // [14]
	
	// (mgmt & dirmgmt) Review (2 total)
	private String mgmtViewPresent;   // [15]
	private String dirMgrApprPresent;  // [16]
	
	// PROCESS 2 (All 3 Approvals) (5 total)
	private String gradeStatusDirectSup;    // [17]
	private String directSupAppr;  // [18]
	private String deptHeadAppr; // [19]
	private String bencoFinalAppr;  //NAGMA pulls // [20]
	private double finalReimburseValBenco; //Store in 4th table position 2 --NAGMA pulls from here // [21]
	
	// TRIGGERS (READ ONLY VALUES) (4 total)
	private String escalationEmailDirectSup; // (if benco does not approve in 2 weeks) // [22]
	private String automaticApprovDirectSup; // [23]
	private String automaticApprovDeptHead; // [24]
	private String markedUrgent; // [25]
	
	public CommunicationTable() {
		super();
		
	}

	public CommunicationTable(int formId, int employeeId, double estimReimbursement,
			String requestorNeedAdditionalInfoFrom, String requesteeResponse, double alterReimbursmentAmount,
			String reasonForLargerAmount, String exceedingAvailableFunds, double pendingAmountVal,
			String notifyEmployee, String employeeOptionToCancel, String approvalStatus, String eventGrade,
			String eventPresentation, String mgmtViewPresent, String dirMgrApprPresent, String gradeStatusDirectSup,
			String directSupAppr, String deptHeadAppr, String bencoFinalAppr, double finalReimburseValBenco,
			String escalationEmailDirectSup, String automaticApprovDirectSup, String automaticApprovDeptHead,
			String markedUrgent) {
		super();
		this.formId = formId;
		this.employeeId = employeeId;
		this.estimReimbursement = estimReimbursement;
		this.requestorNeedAdditionalInfoFrom = requestorNeedAdditionalInfoFrom;
		this.requesteeResponse = requesteeResponse;
		this.alterReimbursmentAmount = alterReimbursmentAmount;
		this.reasonForLargerAmount = reasonForLargerAmount;
		this.exceedingAvailableFunds = exceedingAvailableFunds;
		this.pendingAmountVal = pendingAmountVal;
		this.notifyEmployee = notifyEmployee;
		this.employeeOptionToCancel = employeeOptionToCancel;
		this.approvalStatus = approvalStatus;
		this.eventGrade = eventGrade;
		this.eventPresentation = eventPresentation;
		this.mgmtViewPresent = mgmtViewPresent;
		this.dirMgrApprPresent = dirMgrApprPresent;
		this.gradeStatusDirectSup = gradeStatusDirectSup;
		this.directSupAppr = directSupAppr;
		this.deptHeadAppr = deptHeadAppr;
		this.bencoFinalAppr = bencoFinalAppr;
		this.finalReimburseValBenco = finalReimburseValBenco;
		this.escalationEmailDirectSup = escalationEmailDirectSup;
		this.automaticApprovDirectSup = automaticApprovDirectSup;
		this.automaticApprovDeptHead = automaticApprovDeptHead;
		this.markedUrgent = markedUrgent;
	}

	public CommunicationTable(int formId, String mgmtViewPresent) {
		super();
		this.formId = formId;
		this.mgmtViewPresent = mgmtViewPresent;
	}
	
	
	
	public CommunicationTable(String requesteeResponse, String employeeOptionToCancel, String eventGrade,
			String eventPresentation, int formId) {
		super();
		this.formId = formId;
		this.requesteeResponse = requesteeResponse;
		this.employeeOptionToCancel = employeeOptionToCancel;
		this.eventGrade = eventGrade;
		this.eventPresentation = eventPresentation;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getEstimReimbursement() {
		return estimReimbursement;
	}

	public void setEstimReimbursement(double estimReimbursement) {
		this.estimReimbursement = estimReimbursement;
	}

	public String getRequestorNeedAdditionalInfoFrom() {
		return requestorNeedAdditionalInfoFrom;
	}

	public void setRequestorNeedAdditionalInfoFrom(String requestorNeedAdditionalInfoFrom) {
		this.requestorNeedAdditionalInfoFrom = requestorNeedAdditionalInfoFrom;
	}

	public String getRequesteeResponse() {
		return requesteeResponse;
	}

	public void setRequesteeResponse(String requesteeResponse) {
		this.requesteeResponse = requesteeResponse;
	}

	public double getAlterReimbursmentAmount() {
		return alterReimbursmentAmount;
	}

	public void setAlterReimbursmentAmount(double alterReimbursmentAmount) {
		this.alterReimbursmentAmount = alterReimbursmentAmount;
	}

	public String getReasonForLargerAmount() {
		return reasonForLargerAmount;
	}

	public void setReasonForLargerAmount(String reasonForLargerAmount) {
		this.reasonForLargerAmount = reasonForLargerAmount;
	}

	public String getExceedingAvailableFunds() {
		return exceedingAvailableFunds;
	}

	public void setExceedingAvailableFunds(String exceedingAvailableFunds) {
		this.exceedingAvailableFunds = exceedingAvailableFunds;
	}

	public double getPendingAmountVal() {
		return pendingAmountVal;
	}

	public void setPendingAmountVal(double pendingAmountVal) {
		this.pendingAmountVal = pendingAmountVal;
	}

	public String getNotifyEmployee() {
		return notifyEmployee;
	}

	public void setNotifyEmployee(String notifyEmployee) {
		this.notifyEmployee = notifyEmployee;
	}

	public String getEmployeeOptionToCancel() {
		return employeeOptionToCancel;
	}

	public void setEmployeeOptionToCancel(String employeeOptionToCancel) {
		this.employeeOptionToCancel = employeeOptionToCancel;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getEventGrade() {
		return eventGrade;
	}

	public void setEventGrade(String eventGrade) {
		this.eventGrade = eventGrade;
	}

	public String getEventPresentation() {
		return eventPresentation;
	}

	public void setEventPresentation(String eventPresentation) {
		this.eventPresentation = eventPresentation;
	}

	public String getMgmtViewPresent() {
		return mgmtViewPresent;
	}

	public void setMgmtViewPresent(String mgmtViewPresent) {
		this.mgmtViewPresent = mgmtViewPresent;
	}

	public String getDirMgrApprPresent() {
		return dirMgrApprPresent;
	}

	public void setDirMgrApprPresent(String dirMgrApprPresent) {
		this.dirMgrApprPresent = dirMgrApprPresent;
	}

	public String getGradeStatusDirectSup() {
		return gradeStatusDirectSup;
	}

	public void setGradeStatusDirectSup(String gradeStatusDirectSup) {
		this.gradeStatusDirectSup = gradeStatusDirectSup;
	}

	public String getDirectSupAppr() {
		return directSupAppr;
	}

	public void setDirectSupAppr(String directSupAppr) {
		this.directSupAppr = directSupAppr;
	}

	public String getDeptHeadAppr() {
		return deptHeadAppr;
	}

	public void setDeptHeadAppr(String deptHeadAppr) {
		this.deptHeadAppr = deptHeadAppr;
	}

	public String getBencoFinalAppr() {
		return bencoFinalAppr;
	}

	public void setBencoFinalAppr(String bencoFinalAppr) {
		this.bencoFinalAppr = bencoFinalAppr;
	}

	public double getFinalReimburseValBenco() {
		return finalReimburseValBenco;
	}

	public void setFinalReimburseValBenco(double finalReimburseValBenco) {
		this.finalReimburseValBenco = finalReimburseValBenco;
	}

	public String getEscalationEmailDirectSup() {
		return escalationEmailDirectSup;
	}

	public void setEscalationEmailDirectSup(String escalationEmailDirectSup) {
		this.escalationEmailDirectSup = escalationEmailDirectSup;
	}

	public String getAutomaticApprovDirectSup() {
		return automaticApprovDirectSup;
	}

	public void setAutomaticApprovDirectSup(String automaticApprovDirectSup) {
		this.automaticApprovDirectSup = automaticApprovDirectSup;
	}

	public String getAutomaticApprovDeptHead() {
		return automaticApprovDeptHead;
	}

	public void setAutomaticApprovDeptHead(String automaticApprovDeptHead) {
		this.automaticApprovDeptHead = automaticApprovDeptHead;
	}

	public String getMarkedUrgent() {
		return markedUrgent;
	}

	public void setMarkedUrgent(String markedUrgent) {
		this.markedUrgent = markedUrgent;
	}

	@Override
	public String toString() {
		return "CommunicationTable [formId=" + formId + ", employeeId=" + employeeId + ", estimReimbursement="
				+ estimReimbursement + ", requestorNeedAdditionalInfoFrom=" + requestorNeedAdditionalInfoFrom
				+ ", requesteeResponse=" + requesteeResponse + ", alterReimbursmentAmount=" + alterReimbursmentAmount
				+ ", reasonForLargerAmount=" + reasonForLargerAmount + ", exceedingAvailableFunds="
				+ exceedingAvailableFunds + ", pendingAmountVal=" + pendingAmountVal + ", notifyEmployee="
				+ notifyEmployee + ", employeeOptionToCancel=" + employeeOptionToCancel + ", approvalStatus="
				+ approvalStatus + ", eventGrade=" + eventGrade + ", eventPresentation=" + eventPresentation
				+ ", mgmtViewPresent=" + mgmtViewPresent + ", dirMgrApprPresent=" + dirMgrApprPresent
				+ ", gradeStatusDirectSup=" + gradeStatusDirectSup + ", directSupAppr=" + directSupAppr
				+ ", deptHeadAppr=" + deptHeadAppr + ", bencoFinalAppr=" + bencoFinalAppr + ", finalReimburseValBenco="
				+ finalReimburseValBenco + ", escalationEmailDirectSup=" + escalationEmailDirectSup
				+ ", automaticApprovDirectSup=" + automaticApprovDirectSup + ", automaticApprovDeptHead="
				+ automaticApprovDeptHead + ", markedUrgent=" + markedUrgent + "]";
	}
	
	
	
}