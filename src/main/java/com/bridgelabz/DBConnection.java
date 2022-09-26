package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBConnection {
    public static void main (String[] args){
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName =  "root";
        String password = "root";
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        }
        catch(ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath", e);
        }
        listDrivers();
        try{
            System.out.println("connecting to database:"+jdbcURL);
            con =  DriverManager.getConnection(jdbcURL,userName,password);
            System.out.println("Connecting successfully"+con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while(driverlist.hasMoreElements()){
            Driver driverClass = (Driver) driverlist.nextElement();
            System.out.println(" "+driverClass.getClass().getName());

        }
    }
}

