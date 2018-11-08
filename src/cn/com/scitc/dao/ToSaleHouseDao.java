package cn.com.scitc.dao;

import java.util.List;
import java.util.Map;

import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToSaleHouse;

public interface ToSaleHouseDao {

	List<ToSaleHouse> find4() throws Exception;

	ToSaleHouse findById(String id) throws Exception;

	List<Map<String, Object>> findCity() throws Exception;

	List<Map<String, Object>> findType() throws Exception;

	List<ToSaleHouse> findNew3() throws Exception;

	List<ToSaleHouse> findByPage(PageBean<ToSaleHouse> pb, String and) throws Exception;

	int getTotalRecord(String and) throws Exception;

	void add(ToSaleHouse sh) throws Exception;

}
