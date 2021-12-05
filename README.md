# CakeWebsiteUsingFreeWebsiteTemplate

This is a cake website project that I created. I used the Front-End section of https://freewebsitetemplates.com for reference and then modified it again to fit my project and I designed the Back-End for this website using JSP/Servlets. I hope everyone will enjoy looking at this website. Thanks for watching

## WHAT
This is a cake-selling website that I created during my recent studies. I spent a lot of time and effort to create it. 

## WHY
This is a project that once completed I have to present to the teacher and let them reivew it. Luckily it passed and I feel very happy and satisfied. Hopefully when you see this project you will see my efforts and I hope that you also try your best to be able to create better projects than this.

## HOW

In this project I used the following to create them: 
+ Java
+ JSP/Servlet
+ SQL
+ HTML/CSS

## Details
In this part, we will find out what the files in my project are created for

a. Front-End

*File-List

Index.jsp          Home Page

(Admin)Admin.jsp    -----         Show the list of account for Admin

(Admin)Bill.jsp     -----         Show the list of bill for Admin

(Admin)Bill_Detail.jsp	-----	   Show the details of bill for Admin

(Admin)BillWaiting.jsp	-----	   Show the list of bill in status "waiting" for Admin

(Admin)Category.jsp     -----     Show the list of category for Admin                                          

(Admin)Customer.jsp	    -----     Show the list of customer that sign-up for Admin

(Admin)Product.jsp		-----      Show the list of Product(Image/Price/Description,...) for Admin

(Account)MyAccount.jsp		 ------  Show the information of user

(Account)add.jsp		------	       Show the adding account page for Admin

(Account)login.jsp		    ------   Show the login page

(Account)signup.jsp		 ------      Show the signup page

(Account)update.jsp		------       Show the update account page for Admin

(Bill)update.jsp    -----  Show the update bill page for Admin

(Bill_Details)update.jsp    -----  Show the update bill_detail page for Admin

(Cart)details.jsp ----- Show the details page when user add some products into cart

(Cart)showCart.jsp ----- Show the shopping cart of user

(Category)add.jsp  ----- Show the adding category page for Admin

(Category)update.jsp ----- Show the update category page for Admin

(Customer)add.jsp  ----- Show the adding customer page for Admin

(Customer)update.jsp ----- Show the update customer page for Admin

(Product)add.jsp  ----- Show the adding product page for Admin

(Product)update.jsp ----- Show the update product page for Admin

(Product)ViewProduct.jsp ------ Show the list of cake in the store for all user 



b. Back-End

*File-List

(Controller)CheckoutController.java-----Store all information about the buyer and their cart in the database when the user clicks the "Checkout" button to complete the purchase process.

(Controller)ControllerAdmin.java-----Perform operations add, edit and delete for account

(Controller)ControllerBill.java-----Perform operations add, edit and delete for bill

(Controller)ControllerBill_Detail.java-----Perform operations add, edit and delete for bill_detail

(Controller)ControllerCategory.java-----Perform operations add, edit and delete for category

(Controller)ControllerCustomer.java-----Perform operations add, edit and delete for customer

(Controller)ControllerProduct.java-----Perform operations add, edit and delete for product

(Controller)ControllerDetails.java-----Take the user to the details.jsp page

(Controller)ControllerProductOverview.java-----Bring data from database to ViewProduct.jsp page and show them

(Controller)LogoutController.java-----Remove all session and bring the user back to index.jsp

(Controller)LoginController.java-----Get data from login.jsp page and check if they exist in database or not. If yes ---> redirect user to index.jsp page. If not or user not input username or password ---> return user to login.jsp

(Controller)MyAccountController.java-----Bring tha data information from database of that user to MyAccount.jsp page and show them

(Controller)RemoveController.java-----Remove the shopping cart of user when user click on "Remove" or "Remove All"

(Controller)SignupController.java-----Create new account and new customer in database and bring user to index.jsp with the account they have been signup

(Controller)add2cart.java-----Add products into cart when user want to buy it

(Controller)showCartController----Move user to showCart.jsp to view the shopping cart

entity (Folder) ----- Store attributes

model (Folder)-----Store DAO files and database connection files


## Contributors 
https://freewebsitetemplates.com/?fbclid=IwAR3hM7sx6ClGQ4BpENPuCbeaEDneneAFQ52mwcNaMxSLda_34G0DL94s1M4

## License & Copyright
https://freewebsitetemplates.com/?fbclid=IwAR3hM7sx6ClGQ4BpENPuCbeaEDneneAFQ52mwcNaMxSLda_34G0DL94s1M4






