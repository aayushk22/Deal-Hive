package com.example.ecommerceak;
import java.sql.*;
public class DBConnection {
    private final String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
    private final String userName = "root";
    private final String password = "12345";
    private Statement getStatement() {
        try {
            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            return connection.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getQueryTable(String query) { //this method is for select queries
        try{
            Statement statement = getStatement();
            return statement.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //method for queries for updating database
    public int updateDatabase(String query) {
        try{
            Statement statement = getStatement();
            return statement.executeUpdate(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        ResultSet rs = conn.getQueryTable("SELECT * from customer");
        if (rs != null) System.out.println("Connection successful");
        else System.out.println("Failed");
    }
}
