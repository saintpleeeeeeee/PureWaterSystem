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
	}//宠物表的操作
	public static IT_Users getIT_UsersInstance() throws Exception{
		return new IT_UsersProxy();
	}//用户表的操作
	//问题表操作
	public static IT_Question getIT_QuestionInstance() throws Exception{
		return new IT_QuestionProxy();
	}
	//回答表操作
	public static IT_Answer getIT_AnswerInstance() throws Exception{
		return new IT_AswerProxy();
	} 
	//订单表操作
	public static IT_Orders getIt_OrderInstance() throws Exception{
		return new IT_OdersProxy();
	}
}
