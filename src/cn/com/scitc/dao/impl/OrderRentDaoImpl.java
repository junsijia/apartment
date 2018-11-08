package cn.com.scitc.dao.impl;



import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.com.scitc.dao.OrderRentDao;
import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.utils.DataSourceUtils;

public class OrderRentDaoImpl implements OrderRentDao {

	@Override
	public void save(OrderRent or) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into orderItem values (?,?,?,?,?,?,?,?);";
		qr.update(sql,or.getId(),
					or.getHid(),
					or.getHname(),
					or.getUser().getUserName(),
					or.getUtelephone(),
					or.getOrdertime(),
					or.getState(),
					or.getAdress()
				);		
	}

	@Override
	public void del(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from orderItem where id = ?;";
		qr.update(sql,id);		
	}

	@Override
	public List<OrderRent> findByUserName(String userName) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orderItem where userName = ?;";		
		return qr.query(sql,new BeanListHandler<>(OrderRent.class),userName);
	}

	@Override
	public OrderRent find(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orderItem where id = ? limit 1;";		
		return qr.query(sql,new BeanHandler<>(OrderRent.class),id);
	}

}
