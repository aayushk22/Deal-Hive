package com.example.ecommerceak;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class OrderList {

    private static TableView<customerOrders> customerOrdersTable; //tableview allows us to create a table, populate it and remove items from it
    // creating a table which contains the list of properties of all orders made by the current user
    public static VBox createTable(ObservableList<customerOrders> data) {
        //Columns
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn quantity = new TableColumn("QUANTITY");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        customerOrdersTable = new TableView<>();
        customerOrdersTable.getColumns().addAll(id,name,quantity); //adding the columns to the table
        customerOrdersTable.setItems(data); //adding the data created above to our table
        customerOrdersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // remove the extra column from the table

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10)); //will leave some space from the extreme edges of the window
        vBox.getChildren().addAll(customerOrdersTable);
        return vBox;
    }

//    public VBox getDummyTable() {
//        //data - dummy data
//        ObservableList<customerOrders> data = FXCollections.observableArrayList(); //permits tracking changes when occured
//        data.add(new customerOrders(2, "Iphone", 44546));
//        data.add(new customerOrders(5, "Laptop", 34543));
//        return createTable(data);
//    }

    public static VBox getAllOrders(int customer1_id){
        ObservableList<customerOrders> data = customerOrders.getAllOrders(customer1_id); //creating an observable list by getting all orders of a customer
        return createTable(data); //calling the create table function to display the table
    }

}
