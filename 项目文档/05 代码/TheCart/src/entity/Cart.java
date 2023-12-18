package entity;

public class Cart {
	private String Cid;
	private String CartName;
	private float Wight;
	private String Descript;
	private String BigPic;
	private String SmallPic;
	private float price;
	private String Sp;
	private String Kinds;
	public Cart(){
		
	}
	public Cart(String Cid,String CartName,float Wight,String Descript,String BigPic,String SmallPic,float price,String Sp,String Kinds){
		this.Cid = Cid;
		this.CartName = CartName;
		this.Wight = Wight;
		this.Descript = Descript;
		this.BigPic = BigPic;
		this.SmallPic = SmallPic;
		this.price = price;
		this.Sp = Sp;
		this.Kinds = Kinds;
	}
	public String getKinds() {
		return Kinds;
	}
	public void setKinds(String kinds) {
		Kinds = kinds;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getCartName() {
		return CartName;
	}
	public void setCartName(String cartName) {
		CartName = cartName;
	}
	public float getWight() {
		return Wight;
	}
	public void setWight(float wight) {
		Wight = wight;
	}
	public String getDescript() {
		return Descript;
	}
	public void setDescript(String descript) {
		Descript = descript;
	}
	public String getBigPic() {
		return BigPic;
	}
	public void setBigPic(String bigPic) {
		BigPic = bigPic;
	}
	public String getSmallPic() {
		return SmallPic;
	}
	public void setSmallPic(String smallPic) {
		SmallPic = smallPic;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSp() {
		return Sp;
	}
	public void setSp(String sp) {
		Sp = sp;
	}
	public String toString(){
		return "商品编号:"+this.getCid() + ",商品名称:" + this.getCartName();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getCid().hashCode()+ this.getCartName().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == obj){
			return true;
		}
		if(obj instanceof Cart){
			Cart i = (Cart)obj;
			if(this.getCid() == i.getCid() && this.getCartName().equals(i.getCartName())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
}
