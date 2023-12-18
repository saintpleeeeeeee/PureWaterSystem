package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.PageModel;
import entity.User;

public class IT_UsersImpl implements IT_Users{
	private Connection conn;
	private PreparedStatement stmt;
	public IT_UsersImpl(Connection conn){
		this.conn = conn;
	}
	public User findUserByName(String keywords) throws SQLException {
		User u = null;
		String sql = "select * from T_Users where Username = ?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		ResultSet rs = this.stmt.executeQuery();
		if(rs.next()){
			u = new User();
			u.setUsername(rs.getString(1));
			u.setPassWord(rs.getString(2));
			u.setPhone(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setImageUrl(rs.getString(5));
			u.setDate(rs.getDate(6));
			u.setSex(rs.getString(7));
			u.setJine(rs.getFloat(8));
		}
		this.stmt.close();
		return u;
	}

	public boolean doCreate(User u) throws SQLException {
		boolean flag = false;
		String sql = "insert into T_Users values(?,?,?,?,?,?,?,null)";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, u.getUsername());
		this.stmt.setString(2, u.getPassWord());
		this.stmt.setString(3, u.getPhone());
		this.stmt.setString(4, u.getEmail());
		this.stmt.setString(5, u.getImageUrl());
		this.stmt.setDate(6, new java.sql.Date(u.getDate().getTime()));
		this.stmt.setString(7, u.getSex());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		this.stmt.close();
		return flag;
	}
	
	public boolean deleteByName(String keywords) throws SQLException {
		boolean flag = false;
		String sql = "delete from T_Users where username=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
	public boolean UpdateByName(User u) throws SQLException {
		boolean flag =false;
		String sql = "update T_Users set username=?,pass=?,phone=?,email=?,image=?,birth=?,sex=?,jine=? where username=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, u.getUsername());
		this.stmt.setString(2, u.getPassWord());
		this.stmt.setString(3, u.getPhone());
		this.stmt.setString(4, u.getEmail());
		this.stmt.setString(5, u.getImageUrl());
		this.stmt.setDate(6, new java.sql.Date(u.getDate().getTime()));
		this.stmt.setString(7, u.getSex());
		this.stmt.setFloat(8, u.getJine());
		this.stmt.setString(9, u.getUsername());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
	public PageModel<User> findUserAll(int pageNo, int pageSize)
			throws SQLException {
		PageModel<User> pageModel = new PageModel<User>();
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from(select A.*,rownum rn from(select * from T_Users) A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setInt(1, pageNo * pageSize);
		this.stmt.setInt(2, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			User u = new User();
			u.setUsername(rs.getString(1));
			u.setPassWord(rs.getString(2));
			u.setPhone(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setImageUrl(rs.getString(5));
			u.setDate(rs.getDate(6));
			u.setSex(rs.getString(7));
			u.setJine(rs.getFloat(8));
			list.add(u);
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
	public int getAllUserNum() throws SQLException {
		int count = 0;
		String sql ="select count(*) from T_Users";
		this.stmt = this.conn.prepareStatement(sql);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	
}
