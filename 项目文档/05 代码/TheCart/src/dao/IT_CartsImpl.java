package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper;



import entity.Cart;
import entity.PageModel;
import entity.User;

public class IT_CartsImpl implements IT_Carts{
	private Connection conn = null;
	private PreparedStatement stmt = null;
	public IT_CartsImpl(Connection conn){
		this.conn = conn;
	}
	//根据类型查找
	public ArrayList<Cart> finCartByKinds(String KeyWords) throws SQLException {
		ArrayList<Cart> CartKinds = new ArrayList<Cart>();
		String sql = "select * from T_Carts where Kinds=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, KeyWords);
		ResultSet rs = this.stmt.executeQuery();
		Cart c = null;
		while(rs.next()){
			c = new Cart();
			c.setCid(rs.getString(1));
			c.setCartName(rs.getString(2));
			c.setWight(rs.getFloat(3));
			c.setDescript(rs.getString(4));
			c.setBigPic(rs.getString(5));
			c.setSmallPic(rs.getString(6));
			c.setPrice(rs.getFloat(7));
			c.setSp(rs.getString(8));
			c.setKinds(rs.getString(9));
			CartKinds.add(c);
		}
		this.stmt.close();
		return CartKinds;
	}
	//根据编号查找
	public Cart finCartById(String KeyWords) throws SQLException {
		Cart c = null;
		String sql = "select * from T_Carts where Cid=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, KeyWords);
		ResultSet rs = this.stmt.executeQuery();
		if(rs.next()){
			c = new Cart();
			c.setCid(rs.getString(1));
			c.setCartName(rs.getString(2));
			c.setWight(rs.getFloat(3));
			c.setDescript(rs.getString(4));
			c.setBigPic(rs.getString(5));
			c.setSmallPic(rs.getString(6));
			c.setPrice(rs.getFloat(7));
			c.setSp(rs.getString(8));
			c.setKinds(rs.getString(9));
		}
		this.stmt.close();
		return c;
	}
	public PageModel<Cart> FindAllPets(int pageNo, int pageSize) throws SQLException {
		PageModel<Cart> pageModel = new PageModel<Cart>();
		ArrayList<Cart> list = new ArrayList<Cart>();
		String sql = "select * from(select A.*,rownum rn from(select * from T_Carts) A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setInt(1, pageNo * pageSize);
		this.stmt.setInt(2, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			Cart c = new Cart();
			c.setCid(rs.getString(1));
			c.setCartName(rs.getString(2));
			c.setWight(rs.getFloat(3));
			c.setDescript(rs.getString(4));
			c.setBigPic(rs.getString(5));
			c.setSmallPic(rs.getString(6));
			c.setPrice(rs.getFloat(7));
			c.setSp(rs.getString(8));
			c.setKinds(rs.getString(9));
			list.add(c);
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
	
	public boolean AddPets(Cart c) throws SQLException {
		boolean flag = false;
		String sql = "insert into T_Carts values(?,?,?,?,?,?,?,?,?)";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, c.getCid());
		this.stmt.setString(2, c.getCartName());
		this.stmt.setFloat(3, c.getWight());
		this.stmt.setString(4, c.getDescript());
		this.stmt.setString(5, c.getBigPic());
		this.stmt.setString(6, c.getSmallPic());
		this.stmt.setFloat(7, c.getPrice());
		this.stmt.setString(8, c.getSp());
		this.stmt.setString(9, c.getKinds());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		this.stmt.close();
		return flag;
	}
	public boolean DeletePetsById(String id) throws SQLException {
		boolean flag = false;
		String sql = "delete from T_Carts where cid=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, id);
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
	public boolean UpdatePetsById(Cart c) throws SQLException {
		boolean flag = false;
		//String sql = "update T_Carts" +
			//	"SET cid=?,cartname=?,weight=?,descripte=?,bigpic=?,smallpic=?,price=?,sp=?,kinds=?" +
				//"where cid=?";
		String sql ="update T_Carts " +
				"set cid=?,cartname=?,weight=?,descripte=?,bigpic=?,smallpic=?,price=?,sp=?,kinds=?" +
				"where cid=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, c.getCid());
		this.stmt.setString(2, c.getCartName());
		this.stmt.setFloat(3, c.getWight());
		this.stmt.setString(4, c.getDescript());
		this.stmt.setString(5, c.getBigPic());
		this.stmt.setString(6, c.getSmallPic());
		this.stmt.setFloat(7, c.getPrice());
		this.stmt.setString(8, c.getSp());
		this.stmt.setString(9, c.getKinds());
		this.stmt.setString(10, c.getCid());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
	public int TotalPetsNum() throws SQLException {
		int count = 0;
		String sql="select count(*) from T_Carts";
		this.stmt = this.conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = this.stmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}

	//返回总宠物条数
		public int getTotalNum() throws Exception {
			int count = 0;
			String sql = "select count(*) from T_Cart";
			this.stmt = conn.prepareStatement(sql);
			ResultSet rs = null; 
			rs = this.stmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		}
	

}
