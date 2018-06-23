package projectvice.user_service.api;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import projectvice.user_service.service.impl.UserServiceImpl;

/**
 * 
 * @author Milos
 * IMPORTANT: urlPattern can't take wildcards even if it looks like it can.
 * This is the most complicated example :)
 */
@WebServlet(urlPatterns = {"/api/users/*"})
public class APIServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  Pattern urlPattern = Pattern.compile("/api/users(/(\\d{1,}))?");
  
  String getUserId(StringBuffer stringBuffer) {
    Matcher m = urlPattern.matcher(stringBuffer);
    if (m.find()) {
      return m.group(2);
    }
    return null;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userId = this.getUserId(req.getRequestURL());
    if (userId != null) {
      User u = UserServiceImpl.getInstance().getUser(new Integer(userId));
      ObjectMapper mapper = new ObjectMapper();
      mapper.writeValueAsString(u);
      resp.getWriter().println(mapper.writeValueAsString(u));
    } else {
      resp.getWriter().println("all users");
    }
  }
}
