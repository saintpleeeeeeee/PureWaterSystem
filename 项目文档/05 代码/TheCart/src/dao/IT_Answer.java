package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Answer;
public interface IT_Answer {
	//存储回答
	public boolean AnswerInsert(Answer a) throws SQLException;
	//根据aid查找回答
	public Answer FindAnswerById(String id) throws SQLException;
	//根据cid查找回答
	public ArrayList<Answer> FindAnswerByQid(String id) throws SQLException;
}
