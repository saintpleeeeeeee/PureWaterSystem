package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//���ﳵ��
public class PetCart {
	//������Ʒ�ļ���
	private HashMap<Cart,Integer> goods;
	//���ﳵ���ܽ��
	private double totalPrice;
	//���췽��
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
	//�����Ʒ�����ﳵ
	public boolean addGoodsInCart(Cart cart,int number){
		if(goods.containsKey(cart)){
			goods.put(cart, goods.get(cart) + number);
		}
		else{
			goods.put(cart, number);
		}
		calTotalPrice();//���¼��㹺�ﳵ���ܽ��
		return true;
	}
	//ɾ����Ʒ
	public boolean removeGoodsFromCart(Cart cart){
		goods.remove(cart);
		calTotalPrice();//���¼��㹺�ﳵ���ܽ��
		return true;
	}	
	//���㹺�ﳵ���ܽ��
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Cart> keys = goods.keySet();//��ý��ļ���
		Iterator<Cart> it = keys.iterator();
		while(it.hasNext()){
			Cart i = it.next();
			sum += i.getPrice()*goods.get(i);
		}
		this.setTotalPrice(sum);//���ù��ﳵ���ܽ��
		return this.getTotalPrice();
	}
	public static void main(String[] args){
		Cart i1 = new  Cart("jss1001","��˿��",30,"��˿��","CartImage/jss1.jpg","CartImage/jss1.jpg",15,"Mesocricetus auratus","��");
		Cart i2 = new  Cart("jss1001","������",30,"������","CartImage/jss1.jpg","CartImage/jss1.jpg",20,"Mesocricetus auratus","��");
		Cart i3 = new  Cart("jss1001","��˿��",30,"��˿��","CartImage/jss1.jpg","CartImage/jss1.jpg",15,"Mesocricetus auratus","��");
		PetCart c = new PetCart();
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		c.addGoodsInCart(i3, 3);
		//����������Ʒ�ļ���
		Set<Map.Entry<Cart, Integer>> carts = c.getGoods().entrySet();
		for(Map.Entry<Cart, Integer> obj:carts){
			System.out.println(obj);
		}
		System.out.print(c.calTotalPrice());
	}
}
