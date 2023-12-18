package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PageModel;
import entity.User;
public interface IT_Users {
	public User findUserByName(String keywords) throws SQLException;//�����û��������û�
	public boolean doCreate(User u) throws SQLException;//�û�ע��
	public PageModel<User> findUserAll(int pageNo, int pageSize) throws SQLException;//��ҳ�������е��û�
	public boolean deleteByName(String keywords) throws SQLException;//�����û���ɾ���û�
	public boolean UpdateByName(User u) throws SQLException;//�û��޸ĸ�����Ϣ
	public int getAllUserNum() throws SQLException;//�����û���������
}
