package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ticket.directiva.Directiva;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 Directiva d = new Directiva(); 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <link href=\"css/main_login.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"reserv\" action=\"reservacion\" method=\"post\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row login_box\">\n");
      out.write("                <div class=\"col-md-12 col-xs-12\" align=\"center\">\n");
      out.write("                    <div class=\"line text\"><h3>");
out.println(d.currentTime());
      out.write("</h3></div>\n");
      out.write("                    <div class=\"outter\"><img src=\"img/user.png\" class=\"image-circle\"/></div>   \n");
      out.write("                    <h1 class=\"text\">Bienvenido</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-12 col-xs-12 follow line\" align=\"center\">\n");
      out.write("                    <h3 class=\"text\"> ");
 d.VISITAS++; 
      out.write("\n");
      out.write("                         ");
 out.print(d.VISITAS); 
      out.write(" <br/> <span>VISITAS</span>\n");
      out.write("                    </h3>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-12 col-xs-12 login_control\">\n");
      out.write("\n");
      out.write("                    <div class=\"control\">\n");
      out.write("                        <div class=\"label\">Usuario</div>\n");
      out.write("                        <input name=\"user\" type=\"text\" class=\"form-control\" placeholder=\"usuario_1\"/>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"control\">\n");
      out.write("                         <div class=\"label\">Contraseña</div>\n");
      out.write("                        <input name=\"contra\" type=\"password\" class=\"form-control\" placeholder=\"*******\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div align=\"pass\">\n");
      out.write("                            <input class=\"btn-orange form-control\" type =\"submit\" name =\"comprar\" value=\"Ingresar\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("</html>");
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
