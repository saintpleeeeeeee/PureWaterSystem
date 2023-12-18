package dao;

import java.sql.Date;
import java.util.ArrayList;


import entity.Orders;
import entity.PageModel;

public interface IT_Orders {
	//对订单表的插入操作
	public boolean OrderInsert(Orders o) throws Exception;
	//查找未确认订单
	public PageModel<Orders> OrderSelectNew(int pageNo, int pageSize,String keywords) throws Exception;
	//查找历史订单
	public PageModel<Orders> OrderHistory(int pageNo, int pageSize,String keywords) throws Exception;
	//管理员确认订单
	public boolean OrderConfirm(Orders o) throws Exception;
	//查询未确认订单的总数量
	public int NewOrdersNum() throws Exception;
	//查找历史订单的总数量
	public int HistotyOrderNUm() throws Exception;
	//根据宠物查找订单
	public PageModel<Orders> OrderSelectByPet(int pageNo, int pageSize,String keywords) throws Exception;
	//根据用户查找最新订单
	public PageModel<Orders> OrderSelectByUser(int pageNo, int pageSize,String keywords) throws Exception;
	//查找用户最新订单数量
	public int UserNewOrderNum(String keywords) throws Exception;
	//根据用户查找历史订单
	public PageModel<Orders> OrderSelectHistory(int pageNo, int pageSize,String keywords) throws Exception;
	//查找用户历史订单的数量
	public int UserHistoryOrdersnum(String keywords) throws Exception;
	
}
