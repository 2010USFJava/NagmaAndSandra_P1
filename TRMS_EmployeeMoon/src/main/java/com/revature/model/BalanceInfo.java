package com.revature.model;

public class BalanceInfo {
	
		private int empId;
		private double initalBal;
		private double availBal;
		
		public BalanceInfo() {
			super();
		}

		public BalanceInfo(int empId, double availBal) {
			super();
			this.empId = empId;
			this.availBal = availBal;
		}

		public BalanceInfo(int empId, double initalBal, double availBal) {
			super();
			this.empId = empId;
			this.initalBal = initalBal;
			this.availBal = availBal;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public double getAvailBal() {
			return availBal;
		}

		public void setAvailBal(double availBal) {
			this.availBal = availBal;
		}

		public double getInitalBal() {
			return initalBal;
		}

		public void setInitalBal(double initalBal) {
			this.initalBal = initalBal;
		}

		@Override
		public String toString() {
			return "BalanceInfo [empId=" + empId + ", initalBal=" + initalBal + ", availBal=" + availBal + "]";
		}
		
		
}
