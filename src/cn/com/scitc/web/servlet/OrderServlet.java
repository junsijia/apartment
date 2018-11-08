package cn.com.scitc.web.servlet;


import java.io.IOException;









import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.scitc.dao.ToRentHouseDao;
import cn.com.scitc.dao.ToSaleHouseDao;
import cn.com.scitc.dao.impl.ToRentHouseDaoImpl;
import cn.com.scitc.dao.impl.ToSaleHouseDaoImpl;
import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.domain.User;
import cn.com.scitc.service.OrderRentService;
import cn.com.scitc.service.impl.OrderRentServiceImpl;
import cn.com.scitc.utils.DateUtils;
import cn.com.scitc.utils.UUIDUtils;
import cn.com.scitc.web.servlet.base.BaseServlet;

public class OrderServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * 订单状态 未付款
	 */
	final int ORDER_WEIFUKUAN=0;
	
	/**
	 * 订单状态 已付款
	 */
	final int ORDER_YIFUKUAN=1;
	
	public String saveRent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				
				
				//session 获取user
				User user = (User) request.getSession().getAttribute("user");
				if (user == null) {
					//未登录 提示
					request.setAttribute("msg", "请先登录!");
					return "/jsp/msg.jsp";
				}
				String hid = request.getParameter("id");
				ToRentHouseDao rhd = new ToRentHouseDaoImpl();
				ToRentHouse rh = rhd.findById(hid);
				if (rh != null) {
					//new OrderRent
					OrderRent or = new OrderRent();
					//封装
					or.setHouse(rh);
					or.setHid(hid);
					or.setAdress(rh.getRentHouseAddress());
					or.setId(UUIDUtils.getId());
					or.setHname(rh.getUsername());
					or.setOrdertime(DateUtils.getDate());
					or.setState(ORDER_WEIFUKUAN);
					or.setUser(user);
					or.setUtelephone(user.getTelphone());
					//调用service完成保存
					OrderRentService ors = new OrderRentServiceImpl();
					ors.save(or);				
					request.setAttribute("rentBean", or);
					
				}else {
					ToSaleHouseDao shd = new ToSaleHouseDaoImpl();
					ToSaleHouse sh = shd.findById(hid);
					OrderRent or = new OrderRent();
					or.setHouse1(sh);
					or.setHid(hid);
					or.setAdress(sh.getHouseAddress());
					or.setId(UUIDUtils.getId());
					or.setHname(sh.getUserName());
					or.setOrdertime(DateUtils.getDate());
					or.setState(ORDER_WEIFUKUAN);
					or.setUser(user);
					or.setUtelephone(user.getTelphone());
					//调用service完成保存
					OrderRentService ors = new OrderRentServiceImpl();
					ors.save(or);				
					request.setAttribute("saleBean", or);
					
				}

				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "/jsp/order.jsp";
	}
	
	
	public String find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String hid = request.getParameter("hid");
			OrderRentService ors = new OrderRentServiceImpl();
			OrderRent or = ors.find(id);
			ToRentHouseDao rhd = new ToRentHouseDaoImpl();
			ToRentHouse rh = rhd.findById(hid);

			or.setHouse(rh);
						
			request.setAttribute("rentBean", or);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/order.jsp";
	}

	public String del(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("oid");
		String hid = request.getParameter("hid");
		OrderRentService ors = new OrderRentServiceImpl();
		ors.del(id);
		return "/servlet/InfoServlet?method=getByRentId&id="+hid;
	}
	
	
	public String del_s(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		OrderRentService ors = new OrderRentServiceImpl();
		ors.del(id);
		return "/servlet/UserServlet?method=order";
	}
}
