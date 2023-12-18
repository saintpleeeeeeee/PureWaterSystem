package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PageModel;
import entity.User;
public interface IT_Users {
	public User findUserByName(String keywords) throws SQLException;//根据用户名查找用户
	public boolean doCreate(User u) throws SQLException;//用户注册
	public PageModel<User> findUserAll(int pageNo, int pageSize) throws SQLException;//分页查找所有的用户
	public boolean deleteByName(String keywords) throws SQLException;//根据用户名删除用户
	public boolean UpdateByName(User u) throws SQLException;//用户修改个人信息
	public int getAllUserNum() throws SQLException;//查找用户的总数量
}
