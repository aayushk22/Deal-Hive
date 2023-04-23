package com.example.ecommerceak;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class UserInterface {
    GridPane loginPage;
    HBox headerBar;
    Button signInButton;
    Label welcomeLabel;
    Customer loggedInCustomer;
    VBox body;
    HBox footerBar;
    ProductList productList = new ProductList();
    VBox productPage;
    VBox orderPage;
    Button placeOrderButton = new Button("Place Order");
    ObservableList<Product> itemsInCart = FXCollections.observableArrayList();
    BorderPane createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(900,600);
        root.setTop(headerBar);
        //root.setCenter(loginPage);
        body = new VBox();
        body.setPadding(new Insets(10));
        body.setAlignment(Pos.CENTER);
        root.setCenter(body);
        productPage = productList.getAllProducts();
        body.getChildren().add(productPage);

        root.setBottom(footerBar);
        return root;
    }

    public UserInterface() {
        createLoginPage();
        createHeaderBar();
        createFooterBar();
    }
    private void createLoginPage() {
        Text userNameText = new Text("User Name");
        Text passwordText = new Text("Password");

        TextField userName = new TextField(); //creates a blank space to let the user enter his username
        userName.setPromptText("Type your User name here");
        PasswordField password = new PasswordField(); //creates a blank space to let the user enter his password
        password.setPromptText("Type your password here");
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(150);
        loginButton.setAlignment(Pos.CENTER);
        Label messageLabel = new Label("Hi");
        messageLabel.setWrapText(true);

        loginPage = new GridPane();
//        loginPage.setStyle(" -fx-background-color:#438C9E");
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setHgap(15);
        loginPage.setVgap(15);
        // .add(Node child, int column, int row) -- adding all the necessary nodes to our gridPane
        loginPage.add(userNameText,0,0);
        loginPage.add(userName,1,0);
        loginPage.add(passwordText,0,1);
        loginPage.add(password,1,1);
        loginPage.add(messageLabel,0,2);
        loginPage.add(loginButton,1,2);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = userName.getText(); //extracting the text entered by the user in the username text field
                String pass = password.getText();
                Login login = new Login();
                loggedInCustomer = login.customerLogin(name,pass);
                if(loggedInCustomer != null) {
                    messageLabel.setText("Welcome " + loggedInCustomer.getName()); //displaying the username of the user if login successful
                    welcomeLabel.setText("Welcome-" + loggedInCustomer.getName());
                    headerBar.getChildren().add(welcomeLabel);
                    body.getChildren().clear();
                    body.getChildren().add(productPage);
                }
                else {
                    messageLabel.setText("Login Failed !! Please Enter Correct Username and Password");
                }
            }
        });

    }
    private void createHeaderBar() {
        // making home button and setting the image as logo of the company
        Button homeButton = new Button();
        Image homeImg = new Image("C:\\Java Projects Acciojob\\E-CommerceAK\\src\\main\\Deal Hive-logos_transparent_final50.png");
        ImageView homeBtnImg = new ImageView(homeImg);
        homeButton.setGraphic(homeBtnImg);
        homeButton.setStyle(" -fx-background-color:#438C9E");
        homeButton.setPrefWidth(300);
        homeButton.setAlignment(Pos.CENTER_LEFT);

        TextField searchBar = new TextField(); // text field for user to enter his search query
        searchBar.setPromptText("Search here");
        searchBar.setPrefWidth(230);
        searchBar.setPrefHeight(35);

        //creating search button with image
        Image srch = new Image("C:\\Java Projects Acciojob\\E-CommerceAK\\src\\main\\icon-services-fcs.png");
        ImageView imgSrch = new ImageView(srch);
        imgSrch.setFitHeight(18);
//        imgSrch.setPreserveRatio(true);
        Button searchButton = new Button();
        searchButton.setStyle("-fx-background-color: white");
        searchButton.setGraphic(imgSrch);
        searchButton.setPrefHeight(35);

        //adding login button in the header
        signInButton = new Button("Sign In");
        signInButton.setPrefSize(80,20);
        signInButton.setStyle(" -fx-background-color:#438C9E");
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        signInButton.setFont(font);
        signInButton.setTextFill(Color.WHITE);
        signInButton.setUnderline(true);
        signInButton.setWrapText(false);

        //adding cart button into the header
        Button cartButton = new Button();
        Image cart = new Image("C:\\Java Projects Acciojob\\E-CommerceAK\\src\\main\\cart2.png");
        ImageView cartImage = new ImageView(cart);
        cartImage.setFitHeight(40);
        cartImage.setFitWidth(40);
        cartButton.setGraphic(cartImage);
        cartButton.setStyle(" -fx-background-color:#438C9E");

        Button orderButton = new Button("Orders");
        orderButton.setStyle(" -fx-background-color:#438C9E");
        Font font2 = Font.font("Times New Roman", FontWeight.BOLD, 14);
        orderButton.setFont(font2);
        orderButton.setTextFill(Color.WHITE);
        orderButton.setUnderline(true);


        //adding welcome user label
        welcomeLabel = new Label();
        welcomeLabel.setTextFill(Color.WHITE);
        welcomeLabel.setFont(Font.font("Verdana",12));

        //making our header bar with the use of h-box and giving attributes to that header bar
        headerBar = new HBox(5);
        headerBar.setPadding(new Insets(10));
        headerBar.setSpacing(10);
        headerBar.setAlignment(Pos.CENTER);
        headerBar.setStyle(" -fx-background-color:#438C9E");
        headerBar.getChildren().addAll(homeButton, searchBar, searchButton, signInButton, cartButton, orderButton);

        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear(); //remove everything
                body.getChildren().add(loginPage); //put login page
                headerBar.getChildren().remove(signInButton);
            }
        });

        cartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                VBox prodPage = productList.getProductsInCart(itemsInCart); //to show all the items added in the cart in a new vbox
                prodPage.setSpacing(10);
                prodPage.setAlignment(Pos.CENTER); //align the button to the center
                prodPage.getChildren().add(placeOrderButton); //adding place order button to the new Vbox
                body.getChildren().add(prodPage);
                footerBar.setVisible(false);//when we click the cart button we don't want the footer bar to be visible
            }
        });

        orderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (loggedInCustomer == null) {
                    //the user has not logged in yet so prompt him to login first
                    showDialog("Sorry!! You are not LoggedIn");
                    return;
                }
                body.getChildren().clear();
                orderPage = OrderList.getAllOrders(loggedInCustomer.getId());
                body.getChildren().add(orderPage);
            }
        });

        placeOrderButton.setStyle(" -fx-background-color:#FFC623");
        Font font1 = Font.font("Times New Roman", FontWeight.BOLD, 14);
        placeOrderButton.setFont(font1);

        placeOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // we need a list of products and also customer should be logged in

                if (itemsInCart == null) {
                    //the user has not clicked on any of the product from the list so ask him to click
                    showDialog("Sorry, Your Cart is Empty!!");
                    return;
                }
                if (loggedInCustomer == null) {
                    //the user has not logged in yet so prompt him to login first
                    showDialog("Please Login first to Place Order");
                    return;
                }
                int count = Order.placeMultipleOrders(loggedInCustomer, itemsInCart);
                if (count != 0) {
                    showOrderDialog("Order for "+count+" Products Placed Successfully!!");
                }
                else showOrderDialog("Order Failed!!");
            }
        });

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                body.getChildren().add(productPage); //showing the product page as the default page
                footerBar.setVisible(true);
                if (loggedInCustomer == null && headerBar.getChildren().indexOf(signInButton) == -1) {
                    // if there is no user logged in and the sign in button is not present
                    headerBar.getChildren().add(signInButton);
                }
            }
        });

    }

    private void createFooterBar() {

        Button buyNowButton = new Button("Buy Now"); // creating a buy now button to place orders
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        buyNowButton.setStyle(" -fx-background-color:#FFC623");
        buyNowButton.setFont(font);

        Button addToCart = new Button("Add To Cart");
        Font font1 = Font.font("Times New Roman", FontWeight.BOLD, 14);
        addToCart.setStyle(" -fx-background-color:#FFC623");
        addToCart.setFont(font1);


        //making our footer bar with the use of h-box and giving attributes to that header bar
        footerBar = new HBox(5);
        footerBar.setPadding(new Insets(10));
        footerBar.setSpacing(10);
        footerBar.setAlignment(Pos.CENTER_RIGHT);
        footerBar.setStyle(" -fx-background-color:#438C9E");
        footerBar.getChildren().addAll(buyNowButton, addToCart);

        buyNowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product product = productList.getSelectedProduct(); //fetching the product for which the order needs to be placed
                if (product == null) {
                    //the user has not clicked on any of the product from the list so ask him to click
                    showDialog("Please select a Product first to Place Order");
                    return;
                }
                if (loggedInCustomer == null) {
                    //the user has not logged in yet so prompt him to login first
                    showDialog("Please Login first to Place Order");
                    return;
                }
                boolean status = Order.placeOrder(loggedInCustomer, product);
                if (status == true) {
                    showOrderDialog("Order Placed Successfully!!");
                }
                else showOrderDialog("Order Failed!!");
            }
        });

        addToCart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product product = productList.getSelectedProduct(); //fetching the product for which the order needs to be placed
                if (product == null) {
                    //the user has not clicked on any of the product from the list so ask him to click
                    showDialog("Please select a Product first to Add to Cart");
                    return;
                }
                itemsInCart.add(product); //adding the item to the observable array list
                showOrderDialog("Item Added to the Cart!!");
            }
        });
    }

    private void showOrderDialog(String message) {
        //this function will create a pop-up alert if order is placed successfully or not
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setTitle("Confirmation");
        alert.showAndWait();
    }

    private void showDialog(String message) {
        //the function will create a pop-up alert
        Alert alert = new Alert(Alert.AlertType.ERROR); //creating a new alert of type error
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setTitle("Error");//don't want any title
        alert.showAndWait();
    }
}
