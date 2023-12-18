package dao;

import java.sql.SQLException;

import entity.Cart;
import entity.Question;
import entity.PageModel;
public interface IT_Question {
	//存储问题
	public boolean AskQuestion(Question q) throws SQLException;
	//分页查找所有的问题
	public PageModel<Question> FindAllPage(int pageNo, int pageSize) throws SQLException;
	
	//查找所有问题的数量
	public int getTotalNum() throws Exception;
	
	//按id查询问题
	public Question FindById(String id) throws SQLException;
}
