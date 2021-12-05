<%-- 
    Document   : Bill
    Created on : Oct 19, 2021, 3:03:09 PM
    Author     : pc
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Blog - Cake Delights Web Template</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <!--[if IE 8]>
                <link rel="stylesheet" type="text/css" href="css/ie8.css" />
        <![endif]-->
        <!--[if IE 7]>
                <link rel="stylesheet" type="text/css" href="css/ie7.css" />
        <![endif]-->
        <!--[if IE 6]>
                <link rel="stylesheet" type="text/css" href="css/ie6.css" />
        <![endif]-->
    </head>
    <body>
        <div id="header">
            <div>
                <div>
                    <div id="logo">
                        <a href="HomeController"><img src="images/logo.gif" alt="Logo"/></a>
                    </div>

                    <div>
                        <c:choose>
                            <c:when test="${sessionScope.user eq null}">
                                <a href="HomeController">My Account</a>
                                <a href="index.html">Help</a>
                                <a href="LoginController" class="last">Sign in</a>
                            </c:when>
                            <c:otherwise>
                                <a href="MyAccountController?service=Information">My Account</a>
                                <c:if test="${not empty sessionScope.user}">Welcome ${sessionScope.user.username} ${sessionScope.user.role}</c:if>
                                <a href="LogOutController" class="last">Log out</a>
                            </c:otherwise>
                        </c:choose>
                     <a href="showCartController" class="last">Show Cart</a>
                    </div>

                </div>
                <%
                    int total = (Integer)request.getAttribute("total");
                %>
                
                <a href="ControllerBill?service=listWaiting"> Total Bill Waiting:</a><%=total%>
                <ul>
                    
                    <li class="current"><a href="HomeController">Home</a></li>
                    <li><a href="ControllerProductOverview">The Pastry shop</a></li>
                    <li><a href="about.html">About us</a></li>
                    <li><a href="services.html">Services</a></li>
                    <li><a href="blog.html">Blog</a></li>
                        <c:if test="${sessionScope.user.role == 'admin'}">
                        <li><a href="ControllerAdmin">Manage</a></li>
                        </c:if>
                </ul>
                <div class="section">
                    <a href="index.html"><img src="images/wedding-cupcakes-small.jpg" alt="Image"/></a>
                </div>
            </div>
        </div>
        <div id="content">
            <div id="blog">
                <div id="articles">
                    <%
                        ResultSet rs = (ResultSet) request.getAttribute("rs");
                        String title = (String) request.getAttribute("title");
                    %>
                    <table border="1" >
                        <caption><%=title%></caption>
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Date Create</th>
                                <th>Customer Name</th>
                                <th>Customer Phone</th>
                                <th>Customer Address</th>
                                <th>Total</th>
                                <th>Status</th>
                                <th>Customer ID</th>
                                <th>Bill Detail</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%while (rs.next()) {%>
                            <tr>
                                <td><%=rs.getString(1)%></td>
                                <td><%=rs.getString(2)%></td>
                                <td><%=rs.getString(3)%></td>
                                <td><%=rs.getString(4)%></td>
                                <td><%=rs.getString(5)%></td>
                                <td><%=rs.getDouble(6)%></td>
                                <%
                                    if (rs.getInt(7) == 1) {
                                %>
                                <td>Processing</td>
                                <td><%=rs.getInt(8)%></td>
                                <td><h4><a href="ControllerBill?service=received&oID=<%= rs.getString("oid") %>">Customer Has Received</a></h4></td>
                                <%
                                } else if (rs.getInt(7) == 2) {
                                %>
                                <td>Done</td>
                                <td><%=rs.getInt(8)%></td>
                                <%
                                } else if (rs.getInt(7) == -1) {
                                %>
                                <td>Cancel</td>
                                <td><%=rs.getInt(8)%></td>
                                <td><p><a href="ControllerBill_Detail?service=listBillDetail&oID=<%=rs.getString("oid")%>">Bill Detail</a></p></td>
                                <%
                                } else if (rs.getInt(7) == 0) {
                                %>
                                <td>Waiting</td>
                                <td><%=rs.getInt(8)%></td>
                                <td><p><a href="ControllerBill_Detail?service=listBillDetail&oID=<%=rs.getString("oid")%>">Bill Detail</a></p></td>
                                <td><a href="ControllerBill?service=delete&oID=<%=rs.getString(1)%>">Delete</a></td>
                                <td><a href="ControllerBill?service=update&oID=<%=rs.getString(1)%>">Update</a></td>
                                <td><p><a href="ControllerBill?service=delivery&oID=<%=rs.getString("oid")%>">Delivery the Item</a></p></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <div id="sidebar">
                    <h3><a href="ControllerAdmin">Manage Account</a></h3>
                    <h3><a href="ControllerProduct">Mange Product</a></h3>
                    <h3><a href="ControllerCategory">Mange Category</a></h3>
                    <h3><a href="ControllerCustomer">Manage Customer</a></h3>
                    <h3><a href="ControllerBill">Manage Bill</a></h3>
                </div>
            </div>
        </div>
        <div id="footer">
            <div class="section">
                <div>
                    <div class="aside">
                        <div>
                            <div>
                                <b>Too <span>BUSY</span> to shop?</b>
                                <a href="signin.html">Sign up for free</a>
                                <p>and we&#39;ll deliver it on your doorstep</p>
                            </div>
                        </div>
                    </div>
                    <div class="connect">
                        <span>Follow Us</span>
                        <ul>
                            <li><a href="http://facebook.com/freewebsitetemplates" target="_blank" class="facebook">Facebook</a></li>
                            <li><a href="http://twitter.com/fwtemplates" target="_blank" class="twitter">Twitter</a></li>
                            <li><a href="#" class="subscribe">Subscribe</a></li>
                            <li><a href="http://www.flickr.com/freewebsitetemplates/" target="_blank" class="flicker">Flicker</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="featured">
                <ul>
                    <li class="first">
                        <a href="index.html"><img src="images/fruit-cake.jpg" alt="Image" /></a>
                        <h2><a href="index.html">Tips on how to preserve</a></h2>
                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.html" class="readmore">read more</a></p>
                    </li>
                    <li>
                        <a href="index.html"><img src="images/italian.jpg" alt="Image" /></a>
                        <h2><a href="index.html">Menu of the day: Italian</a></h2>
                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.html" class="readmore">read more</a></p>
                    </li>
                    <li>
                        <a href="index.html"><img src="images/fruit.jpg" alt="Image" /></a>
                        <h2><a href="index.html">Fruit menu for your diet</a></h2>
                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.html" class="readmore">read more</a></p>
                    </li>
                    <li>
                        <a href="index.html"><img src="images/desserts.jpg" alt="Image" /></a>
                        <h2><a href="index.html">Desserts for every occassion</a></h2>
                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.html" class="readmore">read more</a></p>
                    </li>
                </ul>
            </div>
            <div id="navigation">
                <div>
                    <ul>
                        <li class="first"><a href="index.html">help</a></li>
                        <li><a href="index.html">about cake delight</a></li>
                        <li><a href="index.html">cake delight talk</a></li>
                        <li><a href="index.html">developers</a></li>
                        <li><a href="index.html">privacy policy</a></li>
                        <li><a href="index.html">terms of use(updated 10/15/08)</a></li>
                    </ul>
                    <p>Copyright &copy; 2006-2008 cake delight  All rights reserved</p>
                </div>
            </div>
        </div>
    </body>
</html>


