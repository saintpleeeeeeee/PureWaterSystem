package factory;
import dao.IT_Answer;
import dao.IT_AswerProxy;
import dao.IT_Carts;
import dao.IT_CartsProxy;
import dao.IT_OdersProxy;
import dao.IT_Orders;
import dao.IT_Question;
import dao.IT_QuestionProxy;
import dao.IT_Users;
import dao.IT_UsersProxy;
public class DAOfactory {
	public static IT_Carts getIT_CartsInstance() throws Exception{
		return new IT_CartsProxy();
	}//�����Ĳ���
	public static IT_Users getIT_UsersInstance() throws Exception{
		return new IT_UsersProxy();
	}//�û���Ĳ���
	//��������
	public static IT_Question getIT_QuestionInstance() throws Exception{
		return new IT_QuestionProxy();
	}
	//�ش�����
	public static IT_Answer getIT_AnswerInstance() throws Exception{
		return new IT_AswerProxy();
	} 
	//���������
	public static IT_Orders getIt_OrderInstance() throws Exception{
		return new IT_OdersProxy();
	}
}
