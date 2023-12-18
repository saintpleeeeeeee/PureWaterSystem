package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Orders;
import factory.DAOfactory;

public class OrderMUserlet extends HttpServlet {

	private String action = null;
	/**
	 * Constructor of the object.
	 */
	public OrderMUserlet() {
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
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		action = request.getParameter("action");
		if(action.equals("confirm")){
			Orders o = new Orders();
			String id = null;
			id = java.net.URLDecoder.decode(request.getParameter("oid"),"utf-8");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			o.setOid(id);
			try {
				o.setMctime(df.parse(df.format(new Date())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			o.setMcstate("已处理");
			out.println(o.getOid() + o.getMctime() + o.getMcstate());
			
			try {
				if(DAOfactory.getIt_OrderInstance().OrderConfirm(o)){
					request.getRequestDispatcher("/Mangerorder.jsp?id=1").forward(request, response);
				}else{
					out.println("处理失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
				//request.getRequestDispatcher("/Mangerorder.jsp?id=1").forward(request, response);
				
			
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
