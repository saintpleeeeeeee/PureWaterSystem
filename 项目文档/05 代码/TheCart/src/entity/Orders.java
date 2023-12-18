package entity;

import java.util.Date;

public class Orders {
	String oid;
	String username;
	String goodsname;
	float unitprice;
	float price;
	int counts;
	Date buyTime;
	String mcstate;
	Date mctime;
	public String getMcstate() {
		return mcstate;
	}
	public void setMcstate(String mcstate) {
		this.mcstate = mcstate;
	}
	public Date getMctime() {
		return mctime;
	}
	public void setMctime(Date mctime) {
		this.mctime = mctime;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	
}
