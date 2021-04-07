package web_gradle_erp.dto;

import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private Title title;
	private Employee manager; //외래키
	private int salary;
	private Department dept; //외래키
	private Date hiredate;
	
	public Employee(int empNo) {
		this.empNo = empNo;
	}
	
	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept,
			Date hiredate) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
		this.hiredate = hiredate;
	}


	public int getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public Title getTitle() {
		return title;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	public Employee getManager() {
		return manager;
	}
	
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Department getDept() {
		return dept;
	}
	
	public void setDept(Department dept) {
		this.dept = dept;
	}

	
	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return String.format("Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, dept=%s, hiredate=%s]",
				empNo, empName, title, manager, salary, dept, hiredate);
	}

}
