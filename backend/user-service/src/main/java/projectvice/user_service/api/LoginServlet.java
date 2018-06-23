package projectvice.user_service.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import projectvice.user_service.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * GET on this url leads user to login page
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*
     * I can forward users like this even to pages that are not public (in WEB-INF folder)
     */
    req.getRequestDispatcher("/login.jsp").forward(req, resp);
  }
  
  /**
   * POST tries login!
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    User u = UserServiceImpl.getInstance().getUser(username);
    if (u != null && password.equals(u.getPassword())) {
      req.getSession().setAttribute("user", u);
      resp.sendRedirect("private/user-info.jsp"); // better than forward, user will see new page's url!
    } else {
      req.getSession().setAttribute("errorMsg", "Invalid username or password!");
      // req.getRequestDispatcher("login").forward(req, resp); - INFINITE LOOP
      // I again get into this servlet with the same method POST and it again goes into this
      resp.sendRedirect("login");
    }
  }
}
