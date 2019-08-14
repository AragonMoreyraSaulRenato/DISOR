package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ticket.directiva.Directiva;

public final class reserv_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');

    HttpSession sesionActual = request.getSession(true);
    String user = (String) sesionActual.getAttribute("user");
    if(sesionActual == null || user == null){
        response.sendRedirect("index.jsp");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <title>Terminal de Autobuses Fornite</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-grid.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-reboot.min.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main_reserv.css\" type=\"text/css\"/>\n");
      out.write("        </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"compra\" action=\"ticket\" method=\"post\" class=\"form-group w-50\"> \n");
      out.write("            \n");
      out.write("            <div id=\"container\" class=\"cabecera p-4\">\n");
      out.write("                Reservacion Servlet\n");
      out.write("            </div>\n");
      out.write("            ");
 
                String today = d.currentDate();
                String nocompra = d.getNumberClient(); 
                
            
      out.write("\n");
      out.write("            <div id=\"container\" class=\"info p-2\">\n");
      out.write("                <div class=\"column  w-25\">\n");
      out.write("                    <input  name=\"user\" type=\"hidden\" value=\"");
      out.print(user);
      out.write("\"/>\n");
      out.write("                    <label>Bienvenido: ");
      out.print(user);
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"column  w-25\">\n");
      out.write("                    <label name=\"today\" value=\"");
      out.print(today);
      out.write("\" >FECHA: ");
      out.print(today);
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"column  w-25\">\n");
      out.write("                    <input  name=\"nocompra\" type=\"hidden\" value=\"");
      out.print(nocompra);
      out.write("\"/>\n");
      out.write("                    <label>NUMERO DE COMPRA: ");
      out.print(nocompra);
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id = \"container\" class=\"p-3\">\n");
      out.write("                <div class=\"column  w-50\">\n");
      out.write("                    <label>ORIGEN</label>\n");
      out.write("                    <select class=\"custom-select form-control\" name=\"origen\">\n");
      out.write("                        <option selected>Llegada a...</option>\n");
      out.write("                        <option value=\"Oaxaca\">Oaxaca</option>\n");
      out.write("                        <option value=\"Puebla\">Puebla</option>\n");
      out.write("                        <option value=\"CDMX\">CDMX</option>\n");
      out.write("                        <option value=\"Queretaro\">Queretaro</option>\n");
      out.write("                        <option value=\"Veracruz\">Veracruz</option>\n");
      out.write("                        <option value=\"Sonora\">Sonora</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"column w-50\">\n");
      out.write("                    <label>DESTINO</label>\n");
      out.write("                    <select class=\"custom-select form-control\" name=\"destino\">\n");
      out.write("                        <option selected>Llegada a...</option>\n");
      out.write("                        <option value=\"Oaxaca\">Oaxaca</option>\n");
      out.write("                        <option value=\"Puebla\">Puebla</option>\n");
      out.write("                        <option value=\"CDMX\">CDMX</option>\n");
      out.write("                        <option value=\"Queretaro\">Queretaro</option>\n");
      out.write("                        <option value=\"Veracruz\">Veracruz</option>\n");
      out.write("                        <option value=\"Sonora\">Sonora</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id = \"container\" class=\"p-3\">\n");
      out.write("\n");
      out.write("                <div class=\"column w-25\">\n");
      out.write("                    <label>ADULTOS</label>\n");
      out.write("                    <input class=\"form-control\" name=\"adultos\" value=\"0\" type=\"number\" min=\"0\" max=\"10\" id=\"example-number-input\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"column w-25\">\n");
      out.write("                    <label>NIÑOS</label>\n");
      out.write("                    <input class=\"form-control\" name=\"ninos\" value=\"0\" type=\"number\" min=\"0\" max=\"10\" id=\"example-number-input\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"column w-25\">\n");
      out.write("                    <label>FECHA</label>\n");
      out.write("                    <input class=\"form-control\" name=\"fecha\" type=\"date\"  id=\"example-number-input\" value=\"");
out.print(d.currentDate());
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"column w-25\">\n");
      out.write("                    <label>HORA</label>\n");
      out.write("                    <select class=\"custom-select form-control\" name=\"hora\">\n");
      out.write("                        <option selected>Hora de salida...</option>\n");
      out.write("                        <option value=\"06:00\">06:00 HRS</option>\n");
      out.write("                        <option value=\"10:00\">10:00 HRS</option>\n");
      out.write("                        <option value=\"14:00\">14:00 HRS</option>\n");
      out.write("                        <option value=\"18:00\">18:00 HRS</option>\n");
      out.write("                        <option value=\"20:00\">20:00 HRS</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id = \"container\" class=\"p-3\">\n");
      out.write("                <div class=\"column w-25\"></div>\n");
      out.write("                <div class=\"column w-25\"></div>\n");
      out.write("                <div class=\"column w-25\"></div>\n");
      out.write("                <div class=\"column w-25\">\n");
      out.write("                    <input type =\"submit\" name =\"comprar\" value=\"Comprar\" class=\"btn-light form-control\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
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
