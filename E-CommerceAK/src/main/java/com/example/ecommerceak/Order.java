package com.example.ecommerceak;

import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Order {

    // when we have the customer and the product, then this function will place an order for us
    public static boolean placeOrder(Customer customer, Product product) {
        String groupOrderId = "SELECT max(group_order_id) +1 id FROM orders"; //this query will fetch the topmost group id and add 1 to it
        DBConnection dbConnection = new DBConnection();
        try{
            ResultSet rs = dbConnection.getQueryTable(groupOrderId);
            if(rs.next()) {
                String placeOrder = "INSERT INTO orders(group_order_id, customer_id, product_id) VALUES("+rs.getInt("id")+", "+customer.getId()+", "+product.getId()+")";
                return dbConnection.updateDatabase(placeOrder) != 0;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //function to place orders from our cart
    public static int placeMultipleOrders(Customer customer, ObservableList<Product> productList) {
        String groupOrderId = "SELECT max(group_order_id) +1 id FROM orders"; //this query will fetch the topmost group id and add 1 to it
        DBConnection dbConnection = new DBConnection();
        try{
            ResultSet rs = dbConnection.getQueryTable(groupOrderId);
            int count = 0;
            if(rs.next()) {
                for (Product product: productList) { // for each product in the cart
                    String placeOrder = "INSERT INTO orders(group_order_id, customer_id, product_id) VALUES("+rs.getInt("id")+", "+customer.getId()+", "+product.getId()+")";
                    count+= dbConnection.updateDatabase(placeOrder);
                }
                return count;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
