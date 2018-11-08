package cn.com.scitc.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.scitc.dao.ToSaleHouseDao;
import cn.com.scitc.dao.impl.ToSaleHouseDaoImpl;
import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.service.ToSaleHouseService;

public class ToSaleHouseServiceImpl implements ToSaleHouseService {

	@Override
	public List<ToSaleHouse> find4() throws Exception {
		ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
		
	return shd.find4();
	}

	@Override
	public ToSaleHouse findById(String id) throws Exception {
		ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
		return shd.findById(id);
	}

	@Override
	public List<Map<String, Object>> findCity() throws Exception {
		ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
		return shd.findCity();
	}

	@Override
	public List<Map<String, Object>> findType() throws Exception {
		ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
		return shd.findType();
	}

	@Override
	public List<ToSaleHouse> findNew3() throws Exception {
		ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
		return shd.findNew3();
	}

	@Override
	public PageBean<ToSaleHouse> findSaleByPage(int pageNumber, Integer pageSize,String and)
			throws Exception {
		ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
		/*
		 * 创建pageBean
		 */
		PageBean<ToSaleHouse> pb = new PageBean<>(pageNumber, pageSize);
		/*
		 * 设置当前页数据
		 */
		List<ToSaleHouse> data = shd.findByPage(pb,and);
		pb.setData(data);
		/*
		 * 设置总页数
		 */
		int totalRecord = shd.getTotalRecord(and);
		pb.setTotalRecord(totalRecord);
		
		return pb;
	}

	@Override
	public void add(ToSaleHouse sh) throws Exception {
		ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
		shd.add(sh);
	}

}
