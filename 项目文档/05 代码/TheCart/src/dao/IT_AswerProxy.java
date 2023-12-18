package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Answer;
import util.DBHelper;

public class IT_AswerProxy implements IT_Answer{
	private IT_Answer dao = null;
	private DBHelper dbc = null;
	public IT_AswerProxy(){
		this.dbc = new DBHelper();
		this.dao = new IT_AnswerImpl(this.dbc.getConnnection());
		
	}
	public boolean AnswerInsert(Answer a) throws SQLException {
		boolean flag = false;
		flag = this.dao.AnswerInsert(a);
		return flag;
	}

	public Answer FindAnswerById(String id) throws SQLException {
		Answer a = new Answer();
		a = this.dao.FindAnswerById(id);
		return a;
	}

	public ArrayList<Answer> FindAnswerByQid(String id) throws SQLException {
		ArrayList<Answer> list = new ArrayList<Answer>();
		list = this.dao.FindAnswerByQid(id);
		return list;
	}

}
