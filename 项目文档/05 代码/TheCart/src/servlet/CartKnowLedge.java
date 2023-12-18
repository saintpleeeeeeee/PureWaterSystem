package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Question;
import entity.User;
import entity.Answer;
import factory.DAOfactory;

public class CartKnowLedge extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CartKnowLedge() {
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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragrma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = response.getWriter();
		User u = (User)request.getSession().getAttribute("User");
		Answer a = new Answer();
		a.setAnswername(u.getUsername());
		a = (Answer)request.getSession().getAttribute("answer");
		String answer = request.getParameter("answer");
		a.setAnswer(answer);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		
		//格式aid||qid||回答者||回答时间||回答内容||评论
		//String value = a.getAid() + "||" + a.getQid() + "||" + a.getAnswername() + "||" + df.format(new Date()) + "||" + a.getAnswer() + "||" + a.getComments();
		String value = "3" + "||" + "23" + "||" + a.getAnswername() + "||" + df.format(new Date()) + "||" + a.getAnswer() + "||" + "12";
		out.println(value);
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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//用户提交问题
		if(request.getParameter("action").equals("ask")){
			Question q = new Question();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = null;
			try {
				time = df.parse(df.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			q.setAskuser(request.getParameter("askuser"));
			q.setTime(time);
			String id = request.getParameter("askuser") + df.format(new Date());
			q.setId(id);
			q.setHead(request.getParameter("head"));
			q.setQuestion(request.getParameter("question"));
			q.setKind(request.getParameter("kind"));
			String state = "未解决";
			q.setState(state);
			try {
				if(DAOfactory.getIT_QuestionInstance().AskQuestion(q)){
					request.getRequestDispatcher("/MyKnowledge.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		//用户提交回答表
		if(request.getParameter("action").equals("answer")){
			User u = (User)request.getSession().getAttribute("User");
			Answer a = new Answer();
			String qid = request.getParameter("qid");
			String answername = u.getUsername();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String aid = df.format(new Date()) + answername;
			Date time = null;
			try {
				time = df.parse(df.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String answer = request.getParameter("answer");
			String comments = null;
			a.setAid(aid);
			a.setQid(qid);
			a.setAnswername(answername);
			a.setAtime(time);
			a.setAnswer(answer);
			a.setComments(comments);
			if(request.getParameter("insert").equals("insert")){
			try {
				if(DAOfactory.getIT_AnswerInstance().AnswerInsert(a)){
					
					//格式aid||qid||回答者||回答时间||回答内容||评论
					//String value = a.getAid() + "||" + a.getQid() + "||" + a.getAnswername() + "||" + df.format(new Date()) + "||" + a.getAnswer() + "||" + a.getComments();
					//out.println(value);
					request.getSession().setAttribute("answer", a);
					
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
