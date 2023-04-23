package com.example.ecommerceak;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductList {
    private TableView<Product> productTable; //tableview allows us to create a table, populate it and remove items from it
    public VBox createTable(ObservableList<Product> data) {
        //Columns
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn description = new TableColumn("Description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));


        productTable = new TableView<>();
        productTable.getColumns().addAll(id,name,price, description); //adding the columns to the table
        productTable.setPrefHeight(800);
        productTable.setItems(data); //adding the data created above to our table
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // remove the extra column from the table

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10)); //will leave some space from the extreme edges of the window
        vBox.getChildren().addAll(productTable);
        return vBox;
    }

//    public VBox getDummyTable() {
//        //data - dummy data
//        ObservableList<Product> data = FXCollections.observableArrayList(); //permits tracking changes when occured
//        data.add(new Product(2, "Iphone", 44546));
//        data.add(new Product(5, "Laptop", 34543));
//        return createTable(data);
//    }

    public VBox getAllProducts(){
        ObservableList<Product> data = Product.getAllProducts();
        return createTable(data);
    }

    //this function will return us the product that we have selected in the product table in our UI
    public Product getSelectedProduct() {
        return productTable.getSelectionModel().getSelectedItem(); // when we click on an item in our tableview
    }
    public VBox getProductsInCart(ObservableList<Product> data) {
        return createTable(data); //creating a new table to display all the items that have been added to the cart
    }
}
