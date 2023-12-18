package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOfactory;
import entity.User;

public class LoginServlet extends HttpServlet {
	private String User;
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		User = request.getParameter("user");
		User u = new User();
		if(User.equals("User")){
			try {
				if(DAOfactory.getIT_UsersInstance().findUserByName(username) != null ){
					u =(User) DAOfactory.getIT_UsersInstance().findUserByName(username);
					if(pass.equals(u.getPassWord())){
						request.getSession().setAttribute("User", u);
						request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
						
					}else{
						request.getRequestDispatcher("/Login.jsp").forward(request, response);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(User.equals("Manager")){
			request.getRequestDispatcher("/Manager.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
