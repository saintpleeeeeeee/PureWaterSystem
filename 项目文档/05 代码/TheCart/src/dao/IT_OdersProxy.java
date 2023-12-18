package dao;

import java.util.ArrayList;

import util.DBHelper;

import entity.Orders;
import entity.PageModel;

public class IT_OdersProxy implements IT_Orders{
	private IT_Orders dao = null;
	private DBHelper dbc = null;
	public IT_OdersProxy(){
			this.dbc = new DBHelper();
			this.dao = new IT_OdersImpl(this.dbc.getConnnection());
	}
	public boolean OrderInsert(Orders o) throws Exception {
		boolean flag = false;
		if(this.dao.OrderInsert(o)){
			flag = true;
		}
		return flag;
	}
	public PageModel<Orders> OrderSelectNew(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		pageModel = this.dao.OrderSelectNew(pageNo, pageSize, keywords);
		return pageModel;
	}
	public PageModel<Orders> OrderHistory(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		pageModel = this.dao.OrderHistory(pageNo, pageSize, keywords);
		return pageModel;
	}
	public boolean OrderConfirm(Orders o) throws Exception {
		boolean flag = false;
		if(this.dao.OrderConfirm(o)){
			flag = true;
		}
		return flag;
	}
	public int NewOrdersNum() throws Exception {
		int count = 0;
		count = this.dao.NewOrdersNum();
		return count;
	}
	public int HistotyOrderNUm() throws Exception {
		int count = 0;
		count = this.dao.HistotyOrderNUm();
		return count;
	}
	public PageModel<Orders> OrderSelectByPet(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		pageModel = this.dao.OrderSelectByPet(pageNo, pageSize, keywords);
		return pageModel;
	}
	public PageModel<Orders> OrderSelectByUser(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		pageModel = this.dao.OrderSelectByUser(pageNo, pageSize, keywords);
		return pageModel;
	}
	public int UserNewOrderNum(String keywords) throws Exception {
		int count = 0;
		count = this.dao.UserNewOrderNum(keywords);
		return count;
	}
	public PageModel<Orders> OrderSelectHistory(int pageNo, int pageSize,
			String keywords) throws Exception {
		PageModel<Orders> pageModel = new PageModel<Orders>();
		pageModel = this.dao.OrderSelectHistory(pageNo, pageSize, keywords);
		return pageModel;
	}
	public int UserHistoryOrdersnum(String keywords) throws Exception {
		int count = 0;
		count = this.dao.UserHistoryOrdersnum(keywords);
		return count;
	}

	

}
