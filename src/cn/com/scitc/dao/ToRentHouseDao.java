package cn.com.scitc.dao;

import java.util.List;
import java.util.Map;

import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToRentHouse;

public interface ToRentHouseDao {

	List<ToRentHouse> find4() throws Exception;

	ToRentHouse findById(String id) throws Exception;

	List<ToRentHouse> findByPage(PageBean<ToRentHouse> pb, String and) throws Exception;

	int getTotalRecord(String and) throws Exception;

	List<Map<String, Object>> findCity() throws Exception;

	List<Map<String, Object>> findType() throws Exception;

	List<ToRentHouse> findNew3() throws Exception;

	void add(ToRentHouse rh) throws Exception;

}
