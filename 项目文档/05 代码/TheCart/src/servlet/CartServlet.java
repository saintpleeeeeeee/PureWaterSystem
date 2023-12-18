package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOfactory;
import entity.Cart;
import entity.PetCart;

public class CartServlet extends HttpServlet {
	private String action;
	
	/**
	 * Constructor of the object.
	 */
	public CartServlet() {
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

		doPost(request, response);
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
		if(request.getParameter("action") !=null){
			this.action = request.getParameter("action");
			if(action.equals("add")){//添加商品进购物车
				if(addToCart(request, response)){
					request.getRequestDispatcher("/Success.jsp").forward(request, response);
					//out.println("添加成功");
				}
			}
			if(action.equals("show")){
				//showCart(request,response);//显示购物车
				request.getRequestDispatcher("/MyCart.jsp").forward(request, response);
			}
			if(action.equals("delete")){
				try {
					if(deleteFromCart(request,response)){
						request.getRequestDispatcher("/MyCart.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("/MyCart.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//添加商品进购物车的方法
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Cart c = null;
		try {
			c = DAOfactory.getIT_CartsInstance().finCartById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//是否是第一次给购物侧滑添加商品
		if(request.getSession().getAttribute("petcart") == null){
			PetCart petcart = new PetCart();
			request.getSession().setAttribute("petcart", petcart);
		}
		PetCart petcart = (PetCart)request.getSession().getAttribute("petcart");
		if(petcart.addGoodsInCart(c,Integer.parseInt(number))){
			return true;
		}else{
			return false;
		}
	}
	//从购物车中删除商品
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception{
		String id = request.getParameter("id");
		PetCart petcart =(PetCart) request.getSession().getAttribute("petcart");
		Cart cart = DAOfactory.getIT_CartsInstance().finCartById(id);
		if(petcart.removeGoodsFromCart(cart)){
			return true;
		}else{
			return false;
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
