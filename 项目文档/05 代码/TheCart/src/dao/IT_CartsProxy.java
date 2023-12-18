package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBHelper;
import entity.Cart;
import entity.PageModel;

public class IT_CartsProxy implements IT_Carts{
	private IT_Carts dao = null;
	private DBHelper dbc = null;
	public IT_CartsProxy(){
		dbc = new DBHelper();
		dao = new IT_CartsImpl(this.dbc.getConnnection());
	}
	public ArrayList<Cart> finCartByKinds(String KeyWords) throws SQLException {
		ArrayList<Cart> all = null;
		try{
			all = (ArrayList<Cart>) dao.finCartByKinds(KeyWords);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return all;
	}
	public Cart finCartById(String KeyWords) throws SQLException {
		Cart c = null;
		try{
			c = this.dao.finCartById(KeyWords);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return c;
	}
	public PageModel<Cart> FindAllPets(int pageNo, int pageSize)
			throws SQLException {
		PageModel<Cart> pageModel = new PageModel<Cart>();
		pageModel = this.dao.FindAllPets(pageNo, pageSize);
		return pageModel;
	}
	public boolean AddPets(Cart c) throws SQLException {
		boolean flag = false;
		if(this.dao.AddPets(c)){
			flag = true;
		}
		return flag;
	}
	public boolean DeletePetsById(String id) throws SQLException {
		boolean flag = false;
		if(this.dao.DeletePetsById(id)){
			flag = true;
		}
		return true;
	}
	public boolean UpdatePetsById(Cart c) throws SQLException {
		boolean flag = false;
		if(this.dao.UpdatePetsById(c)){
			flag = true;
		}
		return flag;
	}
	public int TotalPetsNum() throws SQLException {
		int count = 0;
		count = this.dao.TotalPetsNum();
		return count;
	}
	public int getTotalNum() throws Exception {
		int count = 0;
		count = this.dao.getTotalNum();
		return count;
	}

}
