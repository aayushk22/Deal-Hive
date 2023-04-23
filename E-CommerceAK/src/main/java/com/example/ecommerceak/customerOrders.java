package com.example.ecommerceak;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class customerOrders {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty quantity;


    public customerOrders(int id, String name, int quantity) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public static ObservableList<customerOrders> getAllOrders(int customer1_id) {
        //will return the list of orders which have been made by the logged-in user
        String selectAllOrders = "SELECT orders.id, product.name, orders.quantity, orders.order_status FROM orders JOIN product on orders.product_id = product.id WHERE orders.customer_id = " +customer1_id;
        return fetchOrderData(selectAllOrders);
    }

    public static ObservableList<customerOrders> fetchOrderData (String query) { //connecting to the sql database
        ObservableList<customerOrders> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        try {
            ResultSet rs = dbConnection.getQueryTable(query);
            while(rs.next()) {
                customerOrders customerOrder = new customerOrders(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"));
                data.add(customerOrder);
            }
            return data;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public int getQuantity() {
        return quantity.get();
    }



}
