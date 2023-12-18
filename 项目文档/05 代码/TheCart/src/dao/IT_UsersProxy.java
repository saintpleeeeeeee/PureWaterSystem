package dao;

import java.sql.SQLException;
import util.DBHelper;
import entity.PageModel;
import entity.User;

public class IT_UsersProxy implements IT_Users{
	private IT_Users dao = null;
	private DBHelper dbc = null;
	public IT_UsersProxy() throws Exception{
		this.dbc = new DBHelper();
		this.dao = new IT_UsersImpl(this.dbc.getConnnection());
	}
	public User findUserByName(String keywords) throws SQLException {
		User u = null;
		u = this.dao.findUserByName(keywords);
		this.dbc.close();
		
		return u;
	}

	public boolean doCreate(User u) throws SQLException {
		boolean flag = false;
		if(this.dao.findUserByName(u.getUsername()) == null){
			flag = this.dao.doCreate(u);
		}
		this.dbc.close();
		return flag;
	}
	public PageModel<User> findUserAll(int pageNo, int pageSize)
			throws SQLException {
		PageModel<User> pageModel = new PageModel<User>();
		pageModel = this.dao.findUserAll(pageNo, pageSize);
		return pageModel;
	}
	public boolean deleteByName(String keywords) throws SQLException {
		boolean flag = false;
		flag = this.dao.deleteByName(keywords);
		return flag;
	}
	public boolean UpdateByName(User u) throws SQLException {
		boolean flag = false;
		flag = this.dao.UpdateByName(u);
		return flag;
	}
	public int getAllUserNum() throws SQLException {
		int count = 0;
		count  = this.dao.getAllUserNum();
		return count;
	}

}
