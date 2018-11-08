package cn.com.scitc.service;

import cn.com.scitc.domain.User;

public interface UserService {

	void regist(User user)throws Exception;

	User login(String username, String password)throws Exception;

	void nameAndPwd(String id, String name, String password) throws Exception;

	void updataUser(String id, String linkPerson, Integer age, String sex,
			String qq, String signature) throws Exception;



}
