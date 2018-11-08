package cn.com.scitc.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.scitc.dao.ToRentHouseDao;
import cn.com.scitc.dao.impl.ToRentHouseDaoImpl;
import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.service.ToRentHouseService;

public class ToRentHouseServiceImpl implements ToRentHouseService {

	@Override
	public List<ToRentHouse> find4() throws Exception {
		ToRentHouseDao rhd = new ToRentHouseDaoImpl();
		return rhd.find4();
	}

	@Override
	public ToRentHouse findById(String id) throws Exception {
		ToRentHouseDao rhd = new ToRentHouseDaoImpl();
		return rhd.findById(id);
	}

	@Override
	public PageBean<ToRentHouse> findRentByPage(int pageNumber, Integer pageSize,String and)
			throws Exception {
		ToRentHouseDao rhd = new ToRentHouseDaoImpl();
		/*
		 * 创建pageBean
		 */
		PageBean<ToRentHouse> pb = new PageBean<>(pageNumber, pageSize);
		/*
		 * 设置当前页数据
		 */
		List<ToRentHouse> data = rhd.findByPage(pb,and);
		pb.setData(data);
		/*
		 * 设置总页数
		 */
		int totalRecord = rhd.getTotalRecord(and);
		pb.setTotalRecord(totalRecord);
		
		return pb;
	}

	@Override
	public List<Map<String, Object>> findCity() throws Exception {
		ToRentHouseDao rhd = new ToRentHouseDaoImpl();
		return rhd.findCity();
	}

	@Override
	public List<Map<String, Object>> findType() throws Exception {
		ToRentHouseDao rhd = new ToRentHouseDaoImpl();
		return rhd.findType();
	}

	@Override
	public List<ToRentHouse> findNew3() throws Exception {
		ToRentHouseDao rhd = new ToRentHouseDaoImpl();
		return rhd.findNew3();
	}

	@Override
	public void add(ToRentHouse rh) throws Exception {
		ToRentHouseDao rhd = new ToRentHouseDaoImpl();
		rhd.add(rh);
	}

}
