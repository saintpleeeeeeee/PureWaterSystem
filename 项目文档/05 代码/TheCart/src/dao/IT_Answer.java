package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Answer;
public interface IT_Answer {
	//�洢�ش�
	public boolean AnswerInsert(Answer a) throws SQLException;
	//����aid���һش�
	public Answer FindAnswerById(String id) throws SQLException;
	//����cid���һش�
	public ArrayList<Answer> FindAnswerByQid(String id) throws SQLException;
}
