package ro.teamnet.zth.appl.domain;


import ro.teamnet.zth.api.annotations.*;

import java.util.Date;

/**
 * Created by user on 7/7/2016.
 */
@Table(name = "EMPLOYEES")
public class Employee {
    @Id(name = "employee_id")
    private String employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "hire_date")
    private Date date;
    @Column(name = "job_id")
    private Long jobId;
    @Column(name = "salary")
    private Long salary;
    @Column(name = "commission_pct")
    private Long commissionPct;
    @Column(name = "department_id")
    private Long departmentId;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Long commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", date=" + date +
                ", jobId=" + jobId +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!employeeId.equals(employee.employeeId)) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!email.equals(employee.email)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        if (!date.equals(employee.date)) return false;
        if (!jobId.equals(employee.jobId)) return false;
        if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) return false;
        if (commissionPct != null ? !commissionPct.equals(employee.commissionPct) : employee.commissionPct != null)
            return false;
        return departmentId != null ? departmentId.equals(employee.departmentId) : employee.departmentId == null;

    }


}
