package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Cart;
//���������ķ����ӿڣ���������ʵ��
import entity.PageModel;
import entity.User;
public interface IT_Carts {
	//�������Ͳ���
	public ArrayList<Cart> finCartByKinds(String KeyWords) throws SQLException;
	//���ݱ�Ų���
	public Cart finCartById(String KeyWords) throws SQLException;
	//�������е���Ʒ��Ϣ
	public PageModel<Cart> FindAllPets(int pageNo, int pageSize) throws SQLException;
	//�����Ʒ
	public boolean AddPets(Cart c) throws SQLException;
	//ɾ����Ʒ
	public boolean DeletePetsById(String id) throws SQLException;
	//�޸���Ʒ��Ϣ
	public boolean UpdatePetsById(Cart c) throws SQLException;
	//������Ʒ������
	public int TotalPetsNum() throws SQLException;
	//�������г��������
		public int getTotalNum() throws Exception;
}
