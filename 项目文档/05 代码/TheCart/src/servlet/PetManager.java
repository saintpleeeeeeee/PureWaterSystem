package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Cart;
import factory.DAOfactory;

public class PetManager extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PetManager() {
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
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String smallpath = "";
		if(request.getParameter("action").equals("delete")){
			//É¾³ý²Ù×÷
			String id = request.getParameter("id");
			try {
				if(DAOfactory.getIT_CartsInstance().DeletePetsById(id)){
					request.getRequestDispatcher("/ManagerPet.jsp?id=1").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("action").equals("update")){
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			Cart c = new Cart();
			if(isMultipart == true){
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> itemList = null;
				try {
					itemList = upload.parseRequest(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				Iterator<FileItem> it = itemList.iterator();
				while(it.hasNext()){
					FileItem item = (FileItem)it.next();
					if(item.isFormField()){
						if(item.getFieldName().equals("cid")){
							c.setCid(item.getString());
						}
						if(item.getFieldName().equals("cname")){
							c.setCartName(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
						if(item.getFieldName().equals("cweight")){
							c.setWight(Float.parseFloat(item.getString()));
						}
						if(item.getFieldName().equals("cprice")){
							c.setPrice(Float.parseFloat(item.getString()));
						}
						if(item.getFieldName().equals("csp")){
							c.setSp(item.getString());
						}
						if(item.getFieldName().equals("ckind")){
							c.setKinds(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
						if(item.getFieldName().equals("cdescript")){
							c.setDescript(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
					}else{
						String path = this.getServletContext().getRealPath("test");
						
						if(item.getFieldName().equals("cbimage")){
							File save = new File(path,item.getName());
							save.getParentFile().mkdirs();
							InputStream ins = item.getInputStream();
							OutputStream ous = new FileOutputStream(save);
							byte[] tmp = new byte[1024];
							int len = -1;
							while((len = ins.read(tmp)) != -1){
								ous.write(tmp, 0, len);
							}
							ous.close();
							ins.close();
							c.setBigPic("test/" + item.getName());
						}else{
							File save = new File(path,item.getName());
							save.getParentFile().mkdirs();
							InputStream ins = item.getInputStream();
							OutputStream ous = new FileOutputStream(save);
							byte[] tmp = new byte[1024];
							int len = -1;
							while((len = ins.read(tmp)) != -1){
								ous.write(tmp, 0, len);
							}
							ous.close();
							ins.close();
							smallpath+="test/" + item.getName() + "|";
						}
						
					}
				}
				c.setSmallPic(smallpath);
				try {
					if(DAOfactory.getIT_CartsInstance().UpdatePetsById(c)){
						request.getRequestDispatcher("/PetUpdate.jsp?id="+c.getCid()).forward(request, response);
					}else{
						out.println("¸üÐÂÊ§°Ü");
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
		if(request.getParameter("action").equals("add")){
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			Cart c = new Cart();
			if(isMultipart == true){
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> itemList = null;
				try {
					itemList = upload.parseRequest(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				Iterator<FileItem> it = itemList.iterator();
				while(it.hasNext()){
					FileItem item = (FileItem)it.next();
					if(item.isFormField()){
						if(item.getFieldName().equals("cid")){
							c.setCid(item.getString());
						}
						if(item.getFieldName().equals("cname")){
							c.setCartName(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
						if(item.getFieldName().equals("cweight")){
							c.setWight(Float.parseFloat(item.getString()));
						}
						if(item.getFieldName().equals("cprice")){
							c.setPrice(Float.parseFloat(item.getString()));
						}
						if(item.getFieldName().equals("csp")){
							c.setSp(item.getString());
						}
						if(item.getFieldName().equals("ckind")){
							c.setKinds(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
						if(item.getFieldName().equals("cdescript")){
							c.setDescript(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
					}else{
						String path = this.getServletContext().getRealPath("test");
						
						if(item.getFieldName().equals("cbimage")){
							File save = new File(path,item.getName());
							save.getParentFile().mkdirs();
							InputStream ins = item.getInputStream();
							OutputStream ous = new FileOutputStream(save);
							byte[] tmp = new byte[1024];
							int len = -1;
							while((len = ins.read(tmp)) != -1){
								ous.write(tmp, 0, len);
							}
							ous.close();
							ins.close();
							c.setBigPic("test/" + item.getName());
						}else{
							File save = new File(path,item.getName());
							save.getParentFile().mkdirs();
							InputStream ins = item.getInputStream();
							OutputStream ous = new FileOutputStream(save);
							byte[] tmp = new byte[1024];
							int len = -1;
							while((len = ins.read(tmp)) != -1){
								ous.write(tmp, 0, len);
							}
							ous.close();
							ins.close();
							smallpath+="test/" + item.getName() + "|";
						}
						
					}
				}
				c.setSmallPic(smallpath);
				try {
					if(DAOfactory.getIT_CartsInstance().AddPets(c)){
						request.getRequestDispatcher("/PetDelete.jsp").forward(request, response);
					}else{
						out.println("Ìí¼ÓÊ§°Ü");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
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
