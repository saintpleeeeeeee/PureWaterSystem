package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//购物车类
public class PetCart {
	//购买商品的集合
	private HashMap<Cart,Integer> goods;
	//购物车的总金额
	private double totalPrice;
	//构造方法
	public PetCart(){
		goods = new HashMap<Cart,Integer>();
		totalPrice = 0.0;
	}
	public HashMap<Cart, Integer> getGoods() {
		return goods;
	}
	public void setGoods(HashMap<Cart, Integer> goods) {
		this.goods = goods;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	//添加商品进购物车
	public boolean addGoodsInCart(Cart cart,int number){
		if(goods.containsKey(cart)){
			goods.put(cart, goods.get(cart) + number);
		}
		else{
			goods.put(cart, number);
		}
		calTotalPrice();//重新计算购物车的总金额
		return true;
	}
	//删除商品
	public boolean removeGoodsFromCart(Cart cart){
		goods.remove(cart);
		calTotalPrice();//重新计算购物车的总金额
		return true;
	}	
	//计算购物车的总金额
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Cart> keys = goods.keySet();//获得健的集合
		Iterator<Cart> it = keys.iterator();
		while(it.hasNext()){
			Cart i = it.next();
			sum += i.getPrice()*goods.get(i);
		}
		this.setTotalPrice(sum);//设置购物车的总金额
		return this.getTotalPrice();
	}
	public static void main(String[] args){
		Cart i1 = new  Cart("jss1001","金丝鼠",30,"金丝熊","CartImage/jss1.jpg","CartImage/jss1.jpg",15,"Mesocricetus auratus","鼠");
		Cart i2 = new  Cart("jss1001","布丁鼠",30,"布丁鼠","CartImage/jss1.jpg","CartImage/jss1.jpg",20,"Mesocricetus auratus","鼠");
		Cart i3 = new  Cart("jss1001","金丝鼠",30,"金丝熊","CartImage/jss1.jpg","CartImage/jss1.jpg",15,"Mesocricetus auratus","鼠");
		PetCart c = new PetCart();
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		c.addGoodsInCart(i3, 3);
		//遍历购买商品的集合
		Set<Map.Entry<Cart, Integer>> carts = c.getGoods().entrySet();
		for(Map.Entry<Cart, Integer> obj:carts){
			System.out.println(obj);
		}
		System.out.print(c.calTotalPrice());
	}
}
