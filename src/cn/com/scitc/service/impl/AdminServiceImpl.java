package cn.com.scitc.service.impl;

import java.util.List;

import cn.com.scitc.dao.AdminDao;
import cn.com.scitc.dao.impl.AdminDaoImpl;
import cn.com.scitc.domain.Admin;
import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.domain.User;
import cn.com.scitc.service.AdminService;

public class AdminServiceImpl implements AdminService {
/*
 * µÇÂ¼ÑéÖ¤(non-Javadoc)
 * @see cn.com.scitc.service.AdminService#findNameAndPwd(java.lang.String, java.lang.String)
 */
	@Override
	public Admin findNameAndPwd(String name, String pwd) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		return ad.findNameAndPwd(name,pwd);
	}
/*
 * rent(non-Javadoc)
 * @see cn.com.scitc.service.AdminService#findRentAll()
 */
	@Override
	public List<ToRentHouse> findRentAll() throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		return ad.findRentAll();
	}

	@Override
	public void del(String id) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		ad.del(id);
	}

	@Override
	public void update(String id) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		ad.update(id);		
	}

	@Override
	public void update1(String id) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		ad.update1(id);		
	}
/*
 * sale(non-Javadoc)
 * @see cn.com.scitc.service.AdminService#findSaleAll()
 */
	@Override
	public List<ToSaleHouse> findSaleAll() throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		return ad.findSaleAll();
	}

	@Override
	public void del1(String id) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		ad.del1(id);
	}

	@Override
	public void up(String id) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		ad.up(id);	
	}

	@Override
	public void up1(String id) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		ad.up1(id);		
	}
/*
 * user(non-Javadoc)
 * @see cn.com.scitc.service.AdminService#findUser()
 */
	@Override
	public List<User> findUser() throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		return ad.findUser();
	}
	@Override
	public void delUser(String id) throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		ad.delUser(id);
	}
	@Override
	public List<OrderRent> findOrder() throws Exception {
		AdminDao ad = new AdminDaoImpl();		
		return ad.findOrder();
	}

}
