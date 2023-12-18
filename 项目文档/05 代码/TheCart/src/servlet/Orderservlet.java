package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IT_Users;

import entity.Cart;
import entity.Orders;
import entity.PetCart;
import entity.User;
import factory.DAOfactory;

public class Orderservlet extends HttpServlet {
	
	private String action=null;
	
	/**
	 * Constructor of the object.
	 */
	public Orderservlet() {
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
		this.action = request.getParameter("action");
		User u = (User)request.getSession().getAttribute("User");
		if(action.equals("insert")){
			if(request.getSession().getAttribute("petcart")!=null){
				PetCart pcart =(PetCart) request.getSession().getAttribute("petcart");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date BuyTime = null;
				try {
					BuyTime = df.parse(df.format(new Date()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				HashMap<Cart,Integer> good = pcart.getGoods();
				Set<Cart> carts = good.keySet();
				Iterator<Cart> it = carts.iterator();
				int i= 0;
				float price2;
				boolean iszhifu=false;
				while(it.hasNext()){
					Cart c = new Cart();
					c = it.next();
					Orders o = new Orders();
					o.setOid(u.getUsername()+df.format(new Date()));
					o.setUsername(u.getUsername());
					o.setGoodsname(c.getCartName());
					o.setUnitprice(c.getPrice());
					o.setPrice(c.getPrice()*good.get(c));
					o.setCounts(good.get(c));
					o.setBuyTime(BuyTime);
					o.setMcstate("未处理");
					
					
					
					try {
						User us = (User)request.getSession().getAttribute("User");
		    			if(us!=null)
		    		{us=DAOfactory.getIT_UsersInstance().findUserByName(us.getUsername());}
						price2=c.getPrice()*good.get(c);
						if(us.getJine()-price2>=0)
						{
						us.setJine(us.getJine()-price2);
						iszhifu=true;
						}
						else 
						{
							us.setJine(us.getJine());
							iszhifu=false;
							
						}
						DAOfactory.getIT_UsersInstance().UpdateByName(us);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						if( DAOfactory.getIt_OrderInstance().OrderInsert(o)){
							it.remove();
						}
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
				if(iszhifu)
				{
					
					  out.print("<script language='JavaScript'>alert('支付成功!');location.href='http://127.0.0.1:8080/TheCart/PersonalCenter.jsp';</script>");
					  

				}
				else
				{
					  out.print("<script language='JavaScript'>alert('支付失败!');location.href='http://127.0.0.1:8080/TheCart/PersonalCenter.jsp';</script>");
				}
				//request.getRequestDispatcher("/MyCart.jsp").forward(request, response);
					out.flush();
		          out.close();
			}
			
		}
		if(action.equals("buy")){
			String id = request.getParameter("id");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date BuyTime = null;
			try {
				BuyTime = df.parse(df.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Orders o = new Orders();
			Cart c = null;
			try {
				c = DAOfactory.getIT_CartsInstance().finCartById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			o.setOid(u.getUsername()+df.format(new Date()));
			o.setUsername(u.getUsername());
			o.setGoodsname(c.getCartName());
			o.setUnitprice(c.getPrice());
			o.setPrice(c.getPrice());
			o.setCounts(1);
			o.setBuyTime(BuyTime);
			o.setMcstate("未处理");
			try {
				if( DAOfactory.getIt_OrderInstance().OrderInsert(o)){
					request.getRequestDispatcher("/Details.jsp?id="+c.getCid()).forward(request, response);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
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
