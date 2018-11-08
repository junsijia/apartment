package cn.com.scitc.service.impl;

import java.util.List;

import cn.com.scitc.dao.OrderRentDao;
import cn.com.scitc.dao.impl.OrderRentDaoImpl;
import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.service.OrderRentService;

public class OrderRentServiceImpl implements OrderRentService {

	@Override
	public void save(OrderRent or) throws Exception {

		OrderRentDao ord = new OrderRentDaoImpl();		
		ord.save(or);
	}

	@Override
	public void del(String id) throws Exception {
		OrderRentDao ord = new OrderRentDaoImpl();		
		ord.del(id);
	}

	@Override
	public List<OrderRent> findByUserName(String userName) throws Exception {
		OrderRentDao ord = new OrderRentDaoImpl();		
		
		return ord.findByUserName(userName);
	}

	@Override
	public OrderRent find(String id) throws Exception {
		OrderRentDao ord = new OrderRentDaoImpl();		
		
		return ord.find(id);
	}
}
