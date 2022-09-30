package com.bridgelabz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeePayroll {
    public static void main(String[] args) {
        String FETCH = "SELECT * FROM employee_payroll";
        ArrayList<Employee> empList = new ArrayList<Employee>();
        DBConnection dbConnection = new DBConnection();
        dbConnection.getConfig();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbConnection.getConfig().prepareStatement(FETCH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setEmpId(resultSet.getInt("id"));
                employee.setEmpName(resultSet.getString("name"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setAddress(resultSet.getString("address"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setEmpStart(resultSet.getString("start"));
                employee.setBasicPay(resultSet.getDouble("basic_pay"));
                employee.setDeductions(resultSet.getDouble("deduction"));
                employee.setTaxablePay(resultSet.getDouble("taxable_pay"));
                employee.setIncomeTax(resultSet.getDouble("tax"));
                employee.setNetPay(resultSet.getDouble("net_pay"));

                empList.add(employee);
            }
            for (Employee i : empList) {
                System.out.println(i.toString());
            }
        }
        catch (SQLException e) {
            throw new EmployeeException("invalid column label");
        }
    }
}