package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Cart;
import entity.Orders;
import entity.PageModel;

public class IT_OdersImpl implements IT_Orders{
	private PreparedStatement stmt;
	private Connection conn;
	public IT_OdersImpl(Connection conn){
		this.conn = conn;
	}
	public boolean OrderInsert(Orders o) throws Exception {
		boolean flag = false;
		String sql = "insert into T_Orders(oid,username,goodsname,unitprice,price,counts,buytime,mcstate) values(?,?,?,?,?,?,?,?)";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, o.getOid());
		this.stmt.setString(2, o.getUsername());
		this.stmt.setString(3, o.getGoodsname());
		this.stmt.setFloat(4, o.getUnitprice());
		this.stmt.setFloat(5, o.getPrice());
		this.stmt.setInt(6, o.getCounts());
		this.stmt.setDate(7, new java.sql.Date(o.getBuyTime().getTime()));
		this.stmt.setString(8, o.getMcstate());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		this.stmt.close();
		return flag;
	}
	public PageModel<Orders> OrderSelectNew(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		ArrayList<Orders> list = new ArrayList<Orders>();
		String sql = "select * from(select A.*,rownum rn from(select * from T_Orders where mcstate=?) A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		this.stmt.setInt(2, pageNo * pageSize);
		this.stmt.setInt(3, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			Orders o = new Orders();
			o.setOid(rs.getString(1));
			o.setUsername(rs.getString(2));
			o.setGoodsname(rs.getString(3));
			o.setUnitprice(rs.getFloat(4));
			o.setPrice(rs.getFloat(5));
			o.setCounts(rs.getInt(6));
			o.setBuyTime(rs.getDate(7));
			o.setMcstate(rs.getString(8));
			list.add(o);
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
	public PageModel<Orders> OrderHistory(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		ArrayList<Orders> list = new ArrayList<Orders>();
		String sql = "select * from(select A.*,rownum rn from(select * from T_Orders where mcstate=?) A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		this.stmt.setInt(2, pageNo * pageSize);
		this.stmt.setInt(3, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			Orders o = new Orders();
			o.setOid(rs.getString(1));
			o.setUsername(rs.getString(2));
			o.setGoodsname(rs.getString(3));
			o.setUnitprice(rs.getFloat(4));
			o.setPrice(rs.getFloat(5));
			o.setCounts(rs.getInt(6));
			o.setBuyTime(rs.getDate(7));
			o.setMcstate(rs.getString(8));
			o.setMctime(rs.getDate(9));
			list.add(o);
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
	public boolean OrderConfirm(Orders o) throws Exception {
		boolean flag = false;
		String sql = "update T_Orders set mcstate=?,mctime=? where oid=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, o.getMcstate());
		this.stmt.setDate(2, new java.sql.Date(o.getMctime().getTime()));
		this.stmt.setString(3, o.getOid());
		if(this.stmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
	public int NewOrdersNum() throws Exception {
		int count = 0;
		String sql = "select count(*) from T_Orders where mcstate='未处理'";
		this.stmt = this.conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = this.stmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	public int HistotyOrderNUm() throws Exception {
		int count = 0;
		String sql = "select count(*) from T_Orders where mcstate='已处理'";
		this.stmt = this.conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = this.stmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	public PageModel<Orders> OrderSelectByPet(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		ArrayList<Orders> list = new ArrayList<Orders>();
		String sql= "select * from(select A.*,rownum rn from(select * from T_Orders where goodsname=?) A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		this.stmt.setInt(2, pageNo * pageSize);
		this.stmt.setInt(3, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			Orders o = new Orders();
			o.setOid(rs.getString(1));
			o.setUsername(rs.getString(2));
			o.setGoodsname(rs.getString(3));
			o.setUnitprice(rs.getFloat(4));
			o.setPrice(rs.getFloat(5));
			o.setCounts(rs.getInt(6));
			o.setBuyTime(rs.getDate(7));
			o.setMcstate(rs.getString(8));
			o.setMctime(rs.getDate(9));
			list.add(o);
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
	public PageModel<Orders> OrderSelectByUser(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		ArrayList<Orders> list = new ArrayList<Orders>();
		String sql = "select * from(select A.*,rownum rn from(select * from T_Orders where username=? and mcstate='未处理') A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		this.stmt.setInt(2, pageNo * pageSize);
		this.stmt.setInt(3, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			Orders o = new Orders();
			o.setOid(rs.getString(1));
			o.setUsername(rs.getString(2));
			o.setGoodsname(rs.getString(3));
			o.setUnitprice(rs.getFloat(4));
			o.setPrice(rs.getFloat(5));
			o.setCounts(rs.getInt(6));
			o.setBuyTime(rs.getDate(7));
			o.setMcstate(rs.getString(8));
			list.add(o);
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
	public int UserNewOrderNum(String keywords) throws Exception {
		int count = 0;
		String sql = "select count(*) from T_Orders where mcstate='未处理' and username=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		ResultSet rs = null;
		rs = this.stmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	public PageModel<Orders> OrderSelectHistory(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		ArrayList<Orders> list = new ArrayList<Orders>();
		String sql = "select * from(select A.*,rownum rn from(select * from T_Orders where username=? and mcstate='已处理') A where rownum <= ?)where rn >=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		this.stmt.setInt(2, pageNo * pageSize);
		this.stmt.setInt(3, (pageNo-1) * pageSize + 1);
		ResultSet rs = null; 
		rs = this.stmt.executeQuery();
		while(rs.next()){
			Orders o = new Orders();
			o.setOid(rs.getString(1));
			o.setUsername(rs.getString(2));
			o.setGoodsname(rs.getString(3));
			o.setUnitprice(rs.getFloat(4));
			o.setPrice(rs.getFloat(5));
			o.setCounts(rs.getInt(6));
			o.setBuyTime(rs.getDate(7));
			o.setMcstate(rs.getString(8));
			o.setMctime(rs.getDate(9));
			list.add(o);
		}
		pageModel.setList(list);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		return pageModel;
	}
	public int UserHistoryOrdersnum(String keywords) throws Exception {
		int count = 0;
		String sql = "select count(*) from T_Orders where mcstate='已处理' and username=?";
		this.stmt = this.conn.prepareStatement(sql);
		this.stmt.setString(1, keywords);
		ResultSet rs = null;
		rs = this.stmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}

	
	
}
