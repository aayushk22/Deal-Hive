# Deal-Hive
**What the Application does?

The Application is essentially an E-Commerce Platform which allows basic functionalities to the user. We can see the list of products that are available on the platform on the homepage. Products can be selected and bought by the user and also the user can add multiple products to the cart. From the cart he can place orders for all the products added to the cart at once. The application also allows a user to login and only when the login is successful, he can buy and view his orders that he has placed till now.  

**What are the technologies used?

Javafx and Java
IDE: IntelliJ IDEA


**HOME PAGE

Following is the screenshot of the home-page
![Screenshot 2023-04-23 225528](https://user-images.githubusercontent.com/119917400/233855386-2ee27fc2-6492-4b6b-b38d-b577af4d9e9a.png)

The hompage has the following UI components and functionalities:

1. Home Button (Header) : This button contains the logo of our brand that is Deal-Hive, if the user is on any page other than the homepage, the application will get redirected to the homepage. Whenever the button is clicked its set on action function is called which will clear the elements present in the body(center)  and add the product page to the body which contains the list of all products contained in our product table in our database.
2. Search Bar and Search Button (Header)
3. Sign-In Button(Header) : The sign in button is a UI element in the header bar which when pressed, will clear the current element present in the body and will take us to our login-page which is a Grid Pane. 
4. Cart Button(Header) : Cart Button is a button on which an image of a cart is set as its graphic. Whenever the cart button is clicked, it basically clears the current elements present in the body and replaces it with our cart page which contains the list of the products that have been added by the user in the cart.
5. Orders Button(Header) : If the user is not logged in yet, clicking the orders button will pop-up an error message. If the user is logged in it will run an SQL query which will create a list of table which will contain properties of Orders made by the user. 
6. Product Page (Body-CENTER) : It is a VBox that contains the list of all the products that we have added in our database table product and displays the same in a table view.
7. Buy Now (Footer) : The buy-now button is present in the footer bar, When it is clicked, its set on action function gets called. If the user has not logged in yet, it shows an alert with an error mesage. If the user is logged in, then it checks whether we have selected a product from the list, if not clicked it shows an alert with error message and if the user has selected a product, it updates the order table contained in our sql database and also shows an alert stating that the order has been placed successfully.
8. Add to Cart(Footer) : Clicking this button check whether a product has been selected by the user, if yes, then it adds the selected product to the cart. 



**LOGIN PAGE 

Following is the Screenshot of the login page:

![sign-in page](https://user-images.githubusercontent.com/119917400/233858152-39eb2583-ee7b-4b19-95ff-846b8c2187e2.png)

The Login Page has the following UI Components and functionalities:

1. The Header Bar is similar to the home page with a minute change that the sign-in button's visibility is set to false and thus we cant see that button in our header bar.
2. The Footer bar is exactly the same as our home-page.
3. The BODY: The body is a grid pane.
4. In the grid pane, our first element is a label which has the text username.
5. Corresponding to the username label, there is a text field in which the user can enter his username
6. in the next row, there is a label with text password
7. Corresponding to that, there is a password field in which the user can enter his password. Password field hides the text written in the field by showhing * instead of the alphabet.
8. In the next row there is a label which intitially shows Hi as the text.
9. The last element is the login button. When the login button is clicked, it collects the data in the text field for username and the password field for password and verifies this data from the data stored in the customer table in the sql database. If it matches, then the login is successful and we are redirected to the homepage and now there is a messagelabel in the header bar which says welcome along with the name of the logged in customer. But if the login is failed, the the label with the hi text shows an error that the login was failed and that we need to retry the login.



**CART-PAGE

Following is the screenshot of the cart-page

![cart page](https://user-images.githubusercontent.com/119917400/233858746-5ebfa068-8ee1-42a6-b67b-b649537134d0.png)

The Cart-page has the following UI Components and functionalities:

1. The footer bar is set to not visible.
2. header bar remains the same as before.
3. In the body, firstly we can see a table view, that contains the list of all the products which have been added by the user in the cart. Whenever the user added any product to the cart, it got added to an observable list of product namely "items in cart". This observable list is shown in tabular manner in our body(center)
4. A new button is added to the body on this page. The PlaceOrder button updates the order table in the database with all the products that are present in the cart at that time. It also shows a pop-up alert which gives a confirmation of the order being placed.




**ORDES-PAGE

When the order button in the header bar is clicked it takes us to the orders page if the user has logged in. If the user has not logged in yet, it displays an alert with error message.
Following is the Screenshot of Orders Page:

![orders page](https://user-images.githubusercontent.com/119917400/233859196-9a5ecafa-aa47-4899-a76d-6942f3950aad.png)

Whenever the order button is clicked, it collects the id of the logged in customer and calls a function that will generate a table of all the orders that the logged-in customer has placed till date with the customer id as the parameter. It will create a table view and an SQL query would be generated which uses the joins command of SQL and will display the order id, the name of the product and the quantity ordered by the logged in customer only. The header bar and the footer bar will remain the same.
