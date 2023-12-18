package dao;

import java.sql.SQLException;
import util.DBHelper;
import entity.Cart;
import entity.PageModel;
import entity.Question;

public class IT_QuestionProxy implements IT_Question{
	private IT_Question dao = null;
	private DBHelper dbc = null;
	public IT_QuestionProxy(){
		this.dbc = new DBHelper();
		this.dao = new IT_QuestionImpl(this.dbc.getConnnection());
	}

	public boolean AskQuestion(Question q) throws SQLException {
		boolean flag = false;
		flag = this.dao.AskQuestion(q);
		return flag;
	}

	public PageModel<Question> FindAllPage(int pageNo, int pageSize)
			throws SQLException {
		PageModel<Question> pageModel;
		pageModel = this.dao.FindAllPage(pageNo, pageSize);
		return pageModel;
	}

	public int getTotalNum() throws Exception {
		int count = 0;
		count = this.dao.getTotalNum();
		return count;
	}

	public Question FindById(String id) throws SQLException {
		Question q = new Question();
		q = this.dao.FindById(id);
		return q;
	}

	

}
