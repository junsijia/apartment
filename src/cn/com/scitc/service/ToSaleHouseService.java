package cn.com.scitc.service;

import java.util.List;
import java.util.Map;

import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToSaleHouse;

public interface ToSaleHouseService {

	List<ToSaleHouse> find4() throws Exception;

	ToSaleHouse findById(String id) throws Exception;

	List<Map<String, Object>> findCity() throws Exception;

	List<Map<String, Object>> findType() throws Exception;

	List<ToSaleHouse> findNew3() throws Exception;

	PageBean<ToSaleHouse> findSaleByPage(int pageNumber, Integer pageSize, String and) throws Exception;

	void add(ToSaleHouse sh) throws Exception;

}
