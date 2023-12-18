package dao;

import java.sql.Date;
import java.util.ArrayList;


import entity.Orders;
import entity.PageModel;

public interface IT_Orders {
	//�Զ�����Ĳ������
	public boolean OrderInsert(Orders o) throws Exception;
	//����δȷ�϶���
	public PageModel<Orders> OrderSelectNew(int pageNo, int pageSize,String keywords) throws Exception;
	//������ʷ����
	public PageModel<Orders> OrderHistory(int pageNo, int pageSize,String keywords) throws Exception;
	//����Աȷ�϶���
	public boolean OrderConfirm(Orders o) throws Exception;
	//��ѯδȷ�϶�����������
	public int NewOrdersNum() throws Exception;
	//������ʷ������������
	public int HistotyOrderNUm() throws Exception;
	//���ݳ�����Ҷ���
	public PageModel<Orders> OrderSelectByPet(int pageNo, int pageSize,String keywords) throws Exception;
	//�����û��������¶���
	public PageModel<Orders> OrderSelectByUser(int pageNo, int pageSize,String keywords) throws Exception;
	//�����û����¶�������
	public int UserNewOrderNum(String keywords) throws Exception;
	//�����û�������ʷ����
	public PageModel<Orders> OrderSelectHistory(int pageNo, int pageSize,String keywords) throws Exception;
	//�����û���ʷ����������
	public int UserHistoryOrdersnum(String keywords) throws Exception;
	
}
