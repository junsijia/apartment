package cn.com.scitc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.com.scitc.dao.ToSaleHouseDao;
import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.utils.DataSourceUtils;

public class ToSaleHouseDaoImpl implements ToSaleHouseDao {

	@Override
	public List<ToSaleHouse> find4() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from tosalehouse where verify = 1 order by rand() limit 4";
		return qr.query(sql, new BeanListHandler<>(ToSaleHouse.class));
	}

	@Override
	public ToSaleHouse findById(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from tosalehouse where houseId = ? limit 1";
		return qr.query(sql, new BeanHandler<>(ToSaleHouse.class),id);
	}

	@Override
	public List<Map<String, Object>> findCity() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select houseId,houseCity from tosalehouse group by houseCity";
		return qr.query(sql, new MapListHandler());
	}

	@Override
	public List<Map<String, Object>> findType() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select houseId,houseRoom from tosalehouse group by houseRoom";
		return qr.query(sql, new MapListHandler());
	}

	@Override
	public List<ToSaleHouse> findNew3() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from tosalehouse where verify = 1 order by publishdate desc limit 3";
		return qr.query(sql,new BeanListHandler<>(ToSaleHouse.class));
	}
	
	/*
	 * 查询当前页数的数据
	 * @see cn.com.scitc.dao.ToRentHouseDao#findByPage(cn.com.scitc.domain.PageBean)
	 */
	@Override
	public List<ToSaleHouse> findByPage(PageBean<ToSaleHouse> pb,String and)
			throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from tosalehouse where "+and+" verify = 1 order by publishdate desc limit ?,?";
		return qr.query(sql, new BeanListHandler<>(ToSaleHouse.class),pb.getStartIndex(),pb.getPageSize() );
	}

	/*
	 * 查询总记录数
	 * @see cn.com.scitc.dao.ToRentHouseDao#getTotalRecord()
	 */
	@Override
	public int getTotalRecord(String and) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from tosalehouse where "+and+" verify = 1";
		return ((Long) qr.query(sql, new ScalarHandler())).intValue();
	}

	@Override
	public void add(ToSaleHouse sh) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into tosalehouse values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,sh.getHouseId(),sh.getHouseShen(),sh.getHouseCity(),
				sh.getHouseAddress(),sh.getHouseRoom(),sh.getDecoration(),
				sh.getFloor(),sh.getHouseArea(),sh.getHousePrice(),
				sh.getVerify(),sh.getDescrible(),sh.getHousePicture(),
				sh.getBuilddate(),sh.getUserName(),sh.getHouseType(),
				sh.getPublishdate());
						
	}

}
