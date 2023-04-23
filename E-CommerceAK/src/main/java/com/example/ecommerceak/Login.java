package com.example.ecommerceak;

import java.sql.ResultSet;

public class Login {
    public Customer customerLogin(String userName, String password) {
        String loginQuery = "SELECT * from customer where email = '"+userName+"' and password = '"+password+"'";
        DBConnection conn = new DBConnection();
        ResultSet rs = conn.getQueryTable(loginQuery);

        try {
            if(rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("mobile"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        Login login = new Login();
        Customer customer = login.customerLogin("ayushkumar22.ak@gmail.com", "ayusk23");
        System.out.println("Welcome : " + customer.getName());
    }
}
