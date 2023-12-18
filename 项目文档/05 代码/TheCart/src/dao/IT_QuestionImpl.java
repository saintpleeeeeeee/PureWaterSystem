package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entity.Cart;
import entity.PageModel;
import entity.Question;

public class IT_QuestionImpl implements IT_Question{
	private Connection conn;
	private PreparedStatement stmt;
	public IT_QuestionImpl(Connection conn){
		this.conn = conn;
	}
	//存储问题
	public boolean AskQuestion(Question q) throws SQLException {
		boolean flag = false;
		String sql = "insert into T_Question values(?,?,?,?,?,?,?)";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, q.getId());
		this.stmt.setString(2, q.getAskuser());
		this.stmt.setDate(3, new java.sql.Date(q.getTime().getTime()));
		this.stmt.setString(4, q.getHead());
		this.stmt.setString(5, q.getQuestion());
		this.stmt.setString(6, q.getKind());
		this.stmt.setString(7, q.getState());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		this.stmt.close();
		return flag;
	}
	//分页查找问题
	public PageModel<Question> FindAllPage(int pageNo, int pageSize)
			throws SQLException {
		PageModel<Question> pageModel = new PageModel<Question>();
		ArrayList<Question> list = new ArrayList<Question>();
		int i = 0;
		String sql = "select * from(select A.*,rownum rn from(select * from T_Question) A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setInt(1, pageNo * pageSize);
		this.stmt.setInt(2, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			Question q = new Question();
			q.setId(rs.getString(1));
			q.setAskuser(rs.getString(2));
			q.setTime(rs.getDate(3));
			q.setHead(rs.getString(4));
			q.setQuestion(rs.getString(5));
			q.setKind(rs.getString(6));
			q.setState(rs.getString(7));
			list.add(q);
			i++;
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		
		return pageModel;
	}
	//返回总问题条数
	public int getTotalNum() throws Exception {
		int count = 0;
		String sql = "select count(*) from T_Question";
		this.stmt = conn.prepareStatement(sql);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	//根据id查询问题
	public Question FindById(String id) throws SQLException {
		Question q = new Question();
		String sql = "select * from T_Question where qid=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, id);
		ResultSet rs = null;
		rs = this.stmt.executeQuery();
		if(rs.next()){
			q.setId(rs.getString(1));
			q.setAskuser(rs.getString(2));
			q.setTime(rs.getDate(3));
			q.setHead(rs.getString(4));
			q.setQuestion(rs.getString(5));
			q.setKind(rs.getString(6));
			q.setState(rs.getString(7));
		}
		return q;
	}
	
	
	
		

}
