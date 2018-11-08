package cn.com.scitc.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.com.scitc.dao.AdminDao;
import cn.com.scitc.domain.Admin;
import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.domain.User;
import cn.com.scitc.utils.DataSourceUtils;

public class AdminDaoImpl implements AdminDao {
/*
 * µÇÂ¼ÑéÖ¤(non-Javadoc)
 * @see cn.com.scitc.dao.AdminDao#findNameAndPwd(java.lang.String, java.lang.String)
 */
	@Override
	public Admin findNameAndPwd(String name, String pwd) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from admin where adminName=? and adminPassword=?";
		return qr.query(sql, new BeanHandler<>(Admin.class),name,pwd);
	}
/*
 * rent(non-Javadoc)
 * @see cn.com.scitc.dao.AdminDao#findRentAll()
 */
	@Override
	public List<ToRentHouse> findRentAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from torenthouse";
		return qr.query(sql, new BeanListHandler<>(ToRentHouse.class));
	}
	
	@Override
	public void del(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from torenthouse where rentHouseId = ?;";
		qr.update(sql,id);
	}
	
	@Override
	public void update(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update torenthouse set verify = 1 where rentHouseId = ?;";
		qr.update(sql,id);
	}
	@Override
	public void update1(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update torenthouse set verify = 0 where rentHouseId = ?;";
		qr.update(sql,id);
	}

/*
 * sale(non-Javadoc)
 * @see cn.com.scitc.dao.AdminDao#findSaleAll()
 */
	@Override
	public List<ToSaleHouse> findSaleAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from tosalehouse";
		return qr.query(sql, new BeanListHandler<>(ToSaleHouse.class));
	}

	@Override
	public void del1(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from tosalehouse where houseId = ?;";
		qr.update(sql,id);
	}

	@Override
	public void up(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update tosalehouse set verify = 1 where houseId = ?;";
		qr.update(sql,id);
	}

	@Override
	public void up1(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update tosalehouse set verify = 0 where houseId = ?;";
		qr.update(sql,id);
	}
	@Override
	public List<User> findUser() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		return qr.query(sql, new BeanListHandler<>(User.class));
	}
	@Override
	public void delUser(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from user where userId = ?;";
		qr.update(sql,id);
	}
	@Override
	public List<OrderRent> findOrder() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orderitem";
		return qr.query(sql, new BeanListHandler<>(OrderRent.class));
	}



}
