package cn.com.scitc.dao;

import java.util.List;

import cn.com.scitc.domain.OrderRent;

public interface OrderRentDao {

	void save(OrderRent or) throws Exception;

	void del(String id) throws Exception;

	List<OrderRent> findByUserName(String userName) throws Exception;

	OrderRent find(String id) throws Exception;

}
