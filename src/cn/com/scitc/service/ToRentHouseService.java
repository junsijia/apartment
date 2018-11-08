package cn.com.scitc.service;

import java.util.List;
import java.util.Map;

import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToRentHouse;

public interface ToRentHouseService {

	List<ToRentHouse> find4() throws Exception;

	ToRentHouse findById(String id) throws Exception;

	PageBean<ToRentHouse> findRentByPage(int pageNumber, Integer pageSize, String and) throws Exception;

	List<Map<String, Object>> findCity() throws Exception;

	List<Map<String, Object>> findType() throws Exception;

	List<ToRentHouse> findNew3() throws Exception;

	void add(ToRentHouse rh) throws Exception;


}
