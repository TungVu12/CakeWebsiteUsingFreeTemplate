package org.apache.jsp.view.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Product;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!-- Website template by freewebsitetemplates.com -->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <title>The Pastry Shop - Cake Delights Web Template</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("        <!--[if IE 8]>\n");
      out.write("                <link rel=\"stylesheet\" type=\"text/css\" href=\"css/ie8.css\" />\n");
      out.write("        <![endif]-->\n");
      out.write("        <!--[if IE 7]>\n");
      out.write("                <link rel=\"stylesheet\" type=\"text/css\" href=\"css/ie7.css\" />\n");
      out.write("        <![endif]-->\n");
      out.write("        <!--[if IE 6]>\n");
      out.write("                <link rel=\"stylesheet\" type=\"text/css\" href=\"css/ie6.css\" />\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div>\n");
      out.write("                <div>\n");
      out.write("                    <div id=\"logo\">\n");
      out.write("                        <a href=\"index.html\"><img src=\"images/logo.gif\" alt=\"Logo\"/></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>\n");
      out.write("                            <a href=\"signup.html\">My Account</a>\n");
      out.write("                            <a href=\"index.html\">Help</a>\n");
      out.write("                            <a href=\"signin.html\" class=\"last\">Sign in</a>\n");
      out.write("                        </div>\n");
      out.write("                        <form action=\"#\">\n");
      out.write("                            <input type=\"text\" id=\"search\" maxlength=\"30\" />\n");
      out.write("                            <input type=\"submit\" value=\"\" id=\"searchbtn\" />\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                    <li class=\"current\"><a href=\"product.html\">The Pastry shop</a></li>\n");
      out.write("                    <li><a href=\"about.html\">About us</a></li>\n");
      out.write("                    <li><a href=\"services.html\">Services</a></li>\n");
      out.write("                    <li><a href=\"blog.html\">Blog</a></li>\n");
      out.write("                    <li><a href=\"contact.html\">Contact Us</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"section\">\n");
      out.write("                    <a href=\"index.html\"><img src=\"images/wedding-cupcakes-small.jpg\" alt=\"Image\"/></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"content\">\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            ");

                String pid = request.getParameter("pid");
                Object value = session.getAttribute(pid);
                Product pro = (Product) value;
            
      out.write("\n");
      out.write("            <h1>Item with id=");
      out.print(pro.getPid());
      out.write(" was added to the Shopping Cart</h1>\n");
      out.write("            <div style=\"font-size: 130%; float: right;\">\n");
      out.write("            <p><span><a href=\"showCartController\">Show Shopping Cart</a></span> <span><a href=\"ControllerProductOverview\">Continue Shopping</a></span></p>\n");
      out.write("                 </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer\">\n");
      out.write("            <div class=\"section\">\n");
      out.write("                <div>\n");
      out.write("                    <div class=\"aside\">\n");
      out.write("                        <div>\n");
      out.write("                            <div>\n");
      out.write("                                <b>Too <span>BUSY</span> to shop?</b>\n");
      out.write("                                <a href=\"signin.html\">Sign up for free</a>\n");
      out.write("                                <p>and we&#39;ll deliver it on your doorstep</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"connect\">\n");
      out.write("                        <span>Follow Us</span>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"http://facebook.com/freewebsitetemplates\" target=\"_blank\" class=\"facebook\">Facebook</a></li>\n");
      out.write("                            <li><a href=\"http://twitter.com/fwtemplates\" target=\"_blank\" class=\"twitter\">Twitter</a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"subscribe\">Subscribe</a></li>\n");
      out.write("                            <li><a href=\"http://www.flickr.com/freewebsitetemplates/\" target=\"_blank\" class=\"flicker\">Flicker</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"featured\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"first\">\n");
      out.write("                        <a href=\"index.html\"><img src=\"images/fruit-cake.jpg\" alt=\"Image\" /></a>\n");
      out.write("                        <h2><a href=\"index.html\">Tips on how to preserve</a></h2>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href=\"index.html\" class=\"readmore\">read more</a></p>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.html\"><img src=\"images/italian.jpg\" alt=\"Image\" /></a>\n");
      out.write("                        <h2><a href=\"index.html\">Menu of the day: Italian</a></h2>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href=\"index.html\" class=\"readmore\">read more</a></p>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.html\"><img src=\"images/fruit.jpg\" alt=\"Image\" /></a>\n");
      out.write("                        <h2><a href=\"index.html\">Fruit menu for your diet</a></h2>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href=\"index.html\" class=\"readmore\">read more</a></p>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.html\"><img src=\"images/desserts.jpg\" alt=\"Image\" /></a>\n");
      out.write("                        <h2><a href=\"index.html\">Desserts for every occassion</a></h2>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href=\"index.html\" class=\"readmore\">read more</a></p>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"navigation\">\n");
      out.write("                <div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li class=\"first\"><a href=\"index.html\">help</a></li>\n");
      out.write("                        <li><a href=\"index.html\">about cake delight</a></li>\n");
      out.write("                        <li><a href=\"index.html\">cake delight talk</a></li>\n");
      out.write("                        <li><a href=\"index.html\">developers</a></li>\n");
      out.write("                        <li><a href=\"index.html\">privacy policy</a></li>\n");
      out.write("                        <li><a href=\"index.html\">terms of use(updated 10/15/08)</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <p>Copyright &copy; 2006-2008 cake delight  All rights reserved</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
