package cn.com.scitc.domain;

import cn.com.scitc.domain.ToRentHouse;

public class OrderRent {
	/*
	 * -------------订单 order
		id   订单编号 uuid
		
		hid   商品id		
		
		name   卖家
		
		user   买家 session
		
		utelephone   买家电话
		
		ordertime  下单时间
		
		state   订单状态    0:未付款	1:已付款
	*/
	private String id;
	private String hid;
	private String hname;
	private String adress;

	private String userName;
	private String utelephone;
	private String ordertime;
	private Integer state;
	
	//表示当前订单属于那个用户
	private User user;
	//房源
	private ToRentHouse house;
	private ToSaleHouse house1;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ToRentHouse getHouse() {
		return house;
	}
	public void setHouse(ToRentHouse house) {
		this.house = house;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public ToSaleHouse getHouse1() {
		return house1;
	}
	public void setHouse1(ToSaleHouse house1) {
		this.house1 = house1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
