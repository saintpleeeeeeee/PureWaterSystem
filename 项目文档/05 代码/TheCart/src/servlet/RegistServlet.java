package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import entity.User;
import factory.DAOfactory;

@SuppressWarnings("deprecation")
public class RegistServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegistServlet() {
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
		PrintWriter out1 = response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		User u = new User();
		if(isMultipart == true){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try{
				@SuppressWarnings("unchecked")
				List<FileItem> itemList = upload.parseRequest(request);
				Iterator<FileItem> it = itemList.iterator();
				while(it.hasNext()){
					FileItem item = (FileItem)it.next();
					if(item.isFormField()){
						if(item.getFieldName().equals("username")){
							u.setUsername(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
						if(item.getFieldName().equals("phone")){
							u.setPhone(item.getString());
						}
						if(item.getFieldName().equals("email")){
							u.setEmail(item.getString());
				
						}
						if(item.getFieldName().equals("pass1")){
							u.setPassWord(item.getString());
							
						}
						if(item.getFieldName().equals("sex")){
							u.setSex(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
						if(item.getFieldName().equals("date")){
							
							u.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(item.getString()));
						}
					}else{
							String path = this.getServletContext().getRealPath("UserImage");
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
							u.setImageUrl("UserImage/" + item.getName());
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		try {
			if(DAOfactory.getIT_UsersInstance().doCreate(u)){
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/Regist.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
