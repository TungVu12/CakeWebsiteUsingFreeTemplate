<%-- 
    Document   : update
    Created on : Oct 19, 2021, 4:04:58 PM
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
                    %>
                    <%if (rs.next()) {%>
                    <form action="ControllerCustomer?service=update" method="POST">
                        <table>     
                            <tr>
                                <td>Customer ID</td>
                                <td><input type="text" name="id" value="<%=rs.getInt(1)%>" /></td>
                            </tr>
                            <tr>
                                <td>Name</td>
                                <td><input type="text" name="name" value="<%=rs.getString(2)%>" /></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><input type="text" name="phone" value="<%=rs.getString(3)%>" /></td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td><input type="text" name="address" value="<%=rs.getString(4)%>" /></td>
                            </tr>
                            <tr>
                                <td>Username</td>
                                <td><input type="text" name="username" value="<%=rs.getString(5)%>" /></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="text" name="password" value="<%=rs.getString(6)%>" /></td>
                            </tr>
                            <tr>
                                <td>New Password</td>
                                <td><input type="password" name="newpassword" value="" /></td>
                            </tr>
                            <tr>
                                <td>Status: </td>
                                <td><input type="radio" name="status" value="1" <%=(rs.getInt(7) == 1 ? "checked" : "")%>/>Enable</td>
                                <td><input type="radio" name="status" value="0"<%=(rs.getInt(7) == 0 ? "checked" : "")%> /> Disable</td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="update" name="submit"/></td>
                            </tr>
                        </table>
                    </form>
                    <%}%>
                </div>
                <div id="sidebar">
                    <h2>List for Admin</h2>
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

