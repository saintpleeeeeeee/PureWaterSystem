package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Cart;
//操作宠物表的方法接口，不做具体实现
import entity.PageModel;
import entity.User;
public interface IT_Carts {
	//根据类型查找
	public ArrayList<Cart> finCartByKinds(String KeyWords) throws SQLException;
	//根据编号查找
	public Cart finCartById(String KeyWords) throws SQLException;
	//查找所有的商品信息
	public PageModel<Cart> FindAllPets(int pageNo, int pageSize) throws SQLException;
	//添加商品
	public boolean AddPets(Cart c) throws SQLException;
	//删除商品
	public boolean DeletePetsById(String id) throws SQLException;
	//修改商品信息
	public boolean UpdatePetsById(Cart c) throws SQLException;
	//查找商品总数量
	public int TotalPetsNum() throws SQLException;
	//查找所有宠物的数量
		public int getTotalNum() throws Exception;
}
