package dao;

import java.sql.SQLException;

import entity.Cart;
import entity.Question;
import entity.PageModel;
public interface IT_Question {
	//�洢����
	public boolean AskQuestion(Question q) throws SQLException;
	//��ҳ�������е�����
	public PageModel<Question> FindAllPage(int pageNo, int pageSize) throws SQLException;
	
	//�����������������
	public int getTotalNum() throws Exception;
	
	//��id��ѯ����
	public Question FindById(String id) throws SQLException;
}
