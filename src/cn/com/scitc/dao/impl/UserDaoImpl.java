package cn.com.scitc.dao.impl;


import java.sql.SQLException;






import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.domain.User;
import cn.com.scitc.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values (?,?,?,?,?,?,?,?,?,?);";
		qr.update(sql,user.getUserId(),
					user.getUserName(),
					user.getUserPassword(),
					user.getLinkPerson(),
					user.getTelphone(),
					user.getEmail(),
					user.getSex(),
					user.getAge(),
					user.getQq(),
					user.getSignature()
				);		
	}

	@Override
	public User getByUsernameAndPwd(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where userName = ? and userPassword = ? limit 1 ";
		return qr.query(sql,new BeanHandler<>(User.class),username,password);
	}

	@Override
	public User checkName(String userName) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where userName = ?  limit 1 ";
		return qr.query(sql,new BeanHandler<>(User.class),userName);
	}


	@Override
	public User findById(String id) throws SQLException  {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where userId = ?  limit 1 ";
		return qr.query(sql,new BeanHandler<>(User.class),id);
	}

	@Override
	public void upUser(String id, String name, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set userName=?,userPassword=? where userId=?";
		qr.update(sql,name,password,id);
	}

	@Override
	public void updataUser(String id, String linkPerson, Integer age,
			String sex, String qq, String signature) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set linkPerson=?,age=?,sex=?,qq=?,signature=? where userId=?";
		qr.update(sql,linkPerson,age,sex,qq,signature,id);		
	}
	

}
