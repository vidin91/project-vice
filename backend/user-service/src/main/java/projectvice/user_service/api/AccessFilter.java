package projectvice.user_service.api;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * IMPORTANT: Filter must implement init/destroy methods!
 * @author Milos
 *
 */
@WebFilter("/private/*")
public class AccessFilter implements Filter {
  public void init(FilterConfig filterConfig) throws ServletException {
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (((HttpServletRequest)request).getSession().getAttribute("user") == null) {
      response.getWriter().println("ERROR - You Must login first!");
    } else {
      chain.doFilter(request, response);
    }
  }
  
  public void destroy() {}
}
