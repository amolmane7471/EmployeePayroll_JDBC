package com.bridgelabz;
public class Employee {
    int id;
    String name, phone_number, address, department, start, gender;
    double basic_pay, deduction, taxable_pay,tax, net_pay;

    public int getEmpId() {
        return id;
    }

    public void setEmpId(int empId) {
        id = empId;
    }

    public String getEmpName() {
        return name;
    }

    public void setEmpName(String empName) {
        name = empName;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        phone_number = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmpStart() {
        return start;
    }

    public void setEmpStart(String empStart) {
        start = empStart;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBasicPay() {
        return basic_pay;
    }

    public void setBasicPay(double basicPay) {
        basic_pay = basicPay;
    }

    public double getDeductions() {
        return deduction;
    }

    public void setDeductions(double deductions) {
        deduction = deductions;
    }

    public double getTaxablePay() {
        return taxable_pay;
    }

    public void setTaxablePay(double taxablePay) {
        taxable_pay = taxablePay;
    }

    public double getIncomeTax() {
        return tax;
    }

    public void setIncomeTax(double incomeTax) {
        tax = incomeTax;
    }

    public double getNetPay() {
        return net_pay;
    }

    public void setNetPay(double netPay) {
        net_pay = netPay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmpId=" + id +
                ", EmpName='" + name + '\'' +
                ", PhoneNumber='" + phone_number + '\'' +
                ", Address='" + address + '\'' +
                ", Department='" + department + '\'' +
                ", EmpStart='" + start + '\'' +
                ", Gender='" + gender + '\'' +
                ", BasicPay=" + basic_pay +
                ", Deductions=" + deduction +
                ", TaxablePay=" + taxable_pay +
                ", IncomeTax=" + tax +
                ", NetPay=" + net_pay +
                '}';
    }
}