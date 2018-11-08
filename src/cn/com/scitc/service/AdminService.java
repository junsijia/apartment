package cn.com.scitc.service;

import java.util.List;

import cn.com.scitc.domain.Admin;
import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.domain.User;

public interface AdminService {

	Admin findNameAndPwd(String name, String pwd) throws Exception;

	List<ToRentHouse> findRentAll() throws Exception;

	void del(String id) throws Exception;

	void update(String id) throws Exception;

	void update1(String id) throws Exception;

	List<ToSaleHouse> findSaleAll() throws Exception;

	void del1(String id) throws Exception;

	void up(String id) throws Exception;

	void up1(String id) throws Exception;

	List<User> findUser() throws Exception;

	void delUser(String id) throws Exception;

	List<OrderRent> findOrder() throws Exception;
	
}
