package com.revature.model;

public class BalanceInfo {
	
		private int empId;
		private double availBal;
		
		public BalanceInfo() {
			super();
		}

		public BalanceInfo(int empId, double availBal) {
			super();
			this.empId = empId;
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

		@Override
		public String toString() {
			return "BalanceInfo [empId=" + empId + ", availBal=" + availBal + "]";
		}
}
