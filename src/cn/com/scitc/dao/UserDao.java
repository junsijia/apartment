package cn.com.scitc.dao;

import java.sql.SQLException;

import cn.com.scitc.domain.User;

public interface UserDao {
	void save(User user)throws Exception;

	User getByUsernameAndPwd(String username, String password) throws SQLException;

	User checkName(String userName) throws SQLException;

	User findById(String id) throws SQLException;

	void upUser(String id,String name,String password) throws SQLException;

	void updataUser(String id, String linkPerson, Integer age, String sex,
			String qq, String signature) throws SQLException;
}
