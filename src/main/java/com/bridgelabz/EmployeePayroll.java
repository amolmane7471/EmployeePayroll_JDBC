package com.bridgelabz;
import java.sql.*;
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
        } catch (SQLException e) {
            throw new EmployeeException("invalid column label");
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "root");
            System.out.println("Connectiom" + connection);
            PreparedStatement preparedStatementObject = connection.prepareStatement("UPDATE employee_payroll SET basic_pay = ? WHERE name = ?");
            preparedStatementObject.setDouble(1, 90000.00);
            preparedStatementObject.setString(2, "terica");

            preparedStatementObject.executeUpdate();
            PreparedStatement preparedStatementDisplay = connection.prepareStatement("select * from employee_payroll");
            ResultSet resultSet = preparedStatementDisplay.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getDouble(1) + " " + resultSet.getString(2) );
            }
            connection.close();

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}