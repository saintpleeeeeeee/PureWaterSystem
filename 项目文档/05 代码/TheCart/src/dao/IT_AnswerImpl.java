package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Answer;

public class IT_AnswerImpl implements IT_Answer{
	private Connection conn;
	private PreparedStatement stmt;
	public IT_AnswerImpl(Connection conn){
		this.conn = conn;
	}
	//对回答表的插入操作
	public boolean AnswerInsert(Answer a) throws SQLException {
		boolean flag = false;
		String sql = "insert into T_Answer values(?,?,?,?,?,?)";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, a.getAid());
		this.stmt.setString(2, a.getQid());
		this.stmt.setString(3, a.getAnswername());
		this.stmt.setDate(4, new java.sql.Date(a.getAtime().getTime()));
		this.stmt.setString(5, a.getAnswer());
		this.stmt.setString(6, a.getComments());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		this.stmt.close();
		return flag;
	}
	//根据回答id查询
	public Answer FindAnswerById(String id) throws SQLException {
		Answer a = new Answer();
		String sql = "select * from T_Answer where aid = ?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, id);
		ResultSet rs = this.stmt.executeQuery();
		if(rs.next()){
			a.setAid(rs.getString(1));
			a.setQid(rs.getString(2));
			a.setAnswername(rs.getString(3));
			a.setAtime(rs.getDate(4));
			a.setAnswer(rs.getString(5));
			a.setComments(rs.getString(6));
		}
		return a;
	}
	//根据问题id查询
	public ArrayList<Answer> FindAnswerByQid(String id) throws SQLException {
		ArrayList<Answer> list = new ArrayList<Answer>();
		Answer a = new Answer();
		String sql = "select * from T_Answer where qid = ?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, id);
		ResultSet rs = this.stmt.executeQuery();
		while(rs.next()){
			a.setAid(rs.getString(1));
			a.setQid(rs.getString(2));
			a.setAnswername(rs.getString(3));
			a.setAtime(rs.getDate(4));
			a.setAnswer(rs.getString(5));
			a.setComments(rs.getString(6));
			list.add(a);
		}
		return list;
	}

}
