package com.example.vo;

import java.sql.Date;

public class EmployeeVO {
	private int empno,mgr,deptno;
	private String ename,job,dname,loc;
	private Date hiredate;
	private double sal,comm;
	
	public EmployeeVO() {}

	public EmployeeVO(int empno, int mgr, int deptno, String ename, String job, String dname, String loc, Date hiredate, 	double sal, double comm) {
		this.empno = empno;
		this.mgr = mgr;
		this.deptno = deptno;
		this.ename = ename;
		this.job = job;
		this.dname = dname;
		this.loc = loc;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "EmployeeVO [empno=" + empno + ", mgr=" + mgr + ", deptno=" + deptno + ", ename=" + ename + ", job="
				+ job + ", dname=" + dname + ", loc=" + loc + ", hiredate=" + hiredate + ", sal=" + sal + ", comm="
				+ comm + "]";
	}
		
}
