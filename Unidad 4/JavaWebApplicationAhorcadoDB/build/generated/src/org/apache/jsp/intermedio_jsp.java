package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class intermedio_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

    HttpSession sesionActual = request.getSession(true);
    String usuario = (String) request.getParameter("nombreUsuario");
    String intentos = (String) request.getParameter("intentos");
    String nivel = (String) request.getParameter("nivel");
    String tipo = (String) request.getParameter("tipo");
    if(usuario == null || usuario.equals("") ) {
        response.sendRedirect("index.jsp");
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        <title>Bienvenido ");
      out.print(usuario);
      out.write(" </title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <table align=\"center\" width=\"350\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th><h4>Bienvenido: ");
      out.print(usuario);
      out.write("</h4></th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Quieres iniciar el juego?:</td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"Juego\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"intentosa\" value=\"");
      out.print(intentos);
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"usuario\" value=\"");
      out.print(usuario);
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"nivel\" value=\"");
      out.print(nivel);
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"tipo\" value=\"");
      out.print(tipo);
      out.write("\"/>\n");
      out.write("                            <input type=\"submit\" value=\"SI\" />\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"index.jsp\">\n");
      out.write("                            <input type=\"submit\" value=\"NO\" />\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html> \n");
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
