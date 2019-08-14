package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jwapahorcado.model.Jugadas;
import java.util.List;
import jwapahorcado.model.Tipo;
import jwapahorcado.directiva.Directiva;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Directiva d = new Directiva();
    String [] nivel = d.getDificultad();
    List<Tipo> tipos = d.getTipos();
    List<Jugadas> usuarios = d.getUsuariosDesc();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"autenticacion\" action=\"intermedio.jsp\" method=\"post\"> \n");
      out.write("            <table align=\"center\" width=\"350\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"2\">Acceso</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Usuario:</td>\n");
      out.write("                        <td> \n");
      out.write("                            <input type=\"text\" name=\"nombreUsuario\" value=\"\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Intentos:</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"number\" name=\"intentos\" value=\"5\" max=\"15\" min=\"5\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Dificultad:</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"nivel\">\n");
      out.write("\n");
      out.write("                                ");
for(int i=0; i<nivel.length; i++){
                                    out.println("                   <option value=\""+(i+1)+"\">"+nivel[i]+"</option>");
                                }
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Tipo:</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"tipo\">\n");
      out.write("                                ");
for(int i=0; i<tipos.size(); i++){
                                    out.println("                   <option value=\""+tipos.get(i).getIdTipo()+"\">"+tipos.get(i).getDescripcion()+"</option>");
                                }
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <input type =\"submit\" value=\"Aceptar\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                </tbody>\n");
      out.write("            </table>     \n");
      out.write("        </form>\n");
      out.write("        <br><br>\n");
      out.write("        <div align=\"center\" width=\"350\">\n");
      out.write("            <h3>MEJORES RACHAS</h3>\n");
      out.write("        <table cellpadding='5' border='1'>\n");
      out.write("            <thead>\n");
      out.write("                <th>Nombre</th>\n");
      out.write("                <th>Palabra</th>\n");
      out.write("                <th>Gano</th>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
 for(int i=0; i<usuarios.size(); i++){
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
out.print(usuarios.get(i).getJugador());
      out.write("</td>\n");
      out.write("                        <td>");
out.print(usuarios.get(i).getPalabra().getPalabra());
      out.write("</td>\n");
      out.write("                        <td>");
out.print(usuarios.get(i).getGano());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("            <br><br>\n");
      out.write("         <a href =\"admin.jsp\">Administrador</a>\n");
      out.write("        </div>\n");
      out.write("    </body> \n");
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
