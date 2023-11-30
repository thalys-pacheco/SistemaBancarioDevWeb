package filtro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import entidade.UsuarioEntidade;

@WebFilter(filterName = "filtro", servletNames = {"transacao","conta","usuario","forward"})
public class filtro implements Filter {
    
    public filtro() {
    }    
    
    @Override
    public void init(FilterConfig arg0)  throws ServletException{}
   
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
            UsuarioEntidade usuario = (UsuarioEntidade) ((HttpServletRequest)request).getSession().getAttribute("usuario");
            if(usuario!=null){
                chain.doFilter(request, response);
            } else{
                RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
                rd.forward(request, response);
            }
   
    }

   @Override
    public void destroy() {}

    
}
