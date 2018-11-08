package cn.com.scitc.service.impl;

import java.sql.SQLException;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.dao.impl.UserDaoImpl;
import cn.com.scitc.domain.User;
import cn.com.scitc.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user) throws Exception {
		
		UserDao dao = new UserDaoImpl();
		dao.save(user);
	}

	@Override
	public User login(String username, String password) throws Exception {

		UserDao dao = new UserDaoImpl();
		
		return dao.getByUsernameAndPwd(username,password);
	}

	@Override
	public void nameAndPwd(String id, String name, String password) throws Exception  {
		// TODO Auto-generated method stub
		UserDao dao = new UserDaoImpl();
		dao.upUser(id,name,password);
	}

	@Override
	public void updataUser(String id, String linkPerson, Integer age,
			String sex, String qq, String signature) throws SQLException {
		UserDao dao = new UserDaoImpl();
		dao.updataUser(id,linkPerson,age,sex,qq,signature);
	}

}
