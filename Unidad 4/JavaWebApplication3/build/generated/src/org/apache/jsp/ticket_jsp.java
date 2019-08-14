package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import ticket.directiva.Directiva;
import java.util.Date;
import ticket.directiva.Directiva;
import java.text.ParseException;;

public final class ticket_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 boolean fech = true;

    public void validarFecha(String fecha) throws ParseException{
        Directiva d = new Directiva();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(d.currentDate());
        Date date2 = sdf.parse(fecha);
        fech =  date1.before(date2) || date1.equals(date2);
    };

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
 
    Directiva d = new Directiva(); 
    HttpSession sesionActual = request.getSession(true);
    if(sesionActual == null){
        response.sendRedirect("index.jsp");
    }
    String origen = (String)  request.getParameter("origen");
    String destino = (String)  request.getParameter("destino");
    String adultos = (String) request.getParameter("adultos");
    String ninos = (String)  request.getParameter("ninos");
    String fecha = (String)  request.getParameter("fecha");
    String hora = (String)  request.getParameter("hora");
    String compra = (String)  request.getParameter("nocompra");
    String user = (String)  request.getParameter("user");

      out.write('\n');
      out.write('\n');
      out.write('\n');

    if(!origen.equals("Salida de...") &&
           !destino.equals("Llegada a...") &&
           !hora.equals("Hora de salida...") &&
           Integer.parseInt(adultos) > 0 &&
           fech){
            response.sendRedirect("index.jsp");
        }
    

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Tickets</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" id=\"bootstrap-css\">\n");
      out.write("        <link href=\"css/main_ticket.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        <div class=\"contenedor\">\n");
      out.write("        ");
for (int i=0;i<(Integer.parseInt(ninos) + Integer.parseInt(adultos));i++){
      out.write("\n");
      out.write("            <div class=\"ticket\">\n");
      out.write("                <div class=\"stub\">\n");
      out.write("                    <div class=\"top\">\n");
      out.write("                        <span class=\"admit\">\n");
      out.write("                            ");
if(i>= Integer.parseInt(adultos)){
      out.write(" NIÑO \n");
      out.write("                            ");
}else{ 
      out.write("\n");
      out.write("                                ADULTO\n");
      out.write("                            ");
}
      out.write("</span>\n");
      out.write("                        <span class=\"line\"></span>\n");
      out.write("                        <span class=\"num\">\n");
      out.write("                            Compra <br><span> ");
      out.print(compra );
      out.write(" </span>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"number\">");
      out.print(i+1);
      out.write("</div>\n");
      out.write("                        <div class=\"invite\">\n");
      out.write("                            ASIENTO\n");
      out.write("                        </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"check\">\n");
      out.write("                    <div class=\"big\">\n");
      out.write("                      De: ");
      out.print(origen);
      out.write(" <br> A: ");
      out.print(destino);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!--div class=\"number\">#1</div-->\n");
      out.write("                    <div class=\"info\">\n");
      out.write("                        <section>\n");
      out.write("                            <div class=\"title\">Responsable</div>\n");
      out.write("                            <div>");
      out.print(user);
      out.write("</div>\n");
      out.write("                        </section>\n");
      out.write("                        <section>\n");
      out.write("                            <div class=\"title\">Fecha Salida</div>\n");
      out.write("                            <div>");
      out.print(fecha);
      out.write("</div>\n");
      out.write("                        </section>\n");
      out.write("                        <section>\n");
      out.write("                            <div class=\"title\">Hora Salida</div>\n");
      out.write("                            <div>");
      out.print(hora);
      out.write("</div>\n");
      out.write("                        </section>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                    \n");
      out.write("        ");
 } 
      out.write("  \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
