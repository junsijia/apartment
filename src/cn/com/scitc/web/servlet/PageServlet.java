package cn.com.scitc.web.servlet;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.scitc.domain.PageBean;
import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.service.ToRentHouseService;
import cn.com.scitc.service.ToSaleHouseService;
import cn.com.scitc.service.impl.ToRentHouseServiceImpl;
import cn.com.scitc.service.impl.ToSaleHouseServiceImpl;
import cn.com.scitc.web.servlet.base.BaseServlet;

public class PageServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String findByRentPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 当前页数pageNumber
			 */
			int pageNumber = 1;
			try {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			/*
			 * 一页显示多少数据pageSize
			 */
			Integer pageSize = 5;
			
			String and = "";
			
			String rentHouseCity = request.getParameter("city");
			if (!rentHouseCity.equals("0")) {
				rentHouseCity = "'"+rentHouseCity+"'";
				and += "rentHouseCity = "+rentHouseCity+" and ";
			}
			String rentHousePrice = request.getParameter("price");
			if (!rentHousePrice.equals("0") && rentHousePrice.equals("500-1000")) {
				and += "rentHousePrice between 500 and 1000 and "; 
			}else if(rentHousePrice.equals("1001-2000")) {
				and += "rentHousePrice between 1001 and 2000 and ";
			}else if(rentHousePrice.equals("2001-3000")) {
				and += "rentHousePrice between 2001 and 3000 and ";
			}else if(rentHousePrice.equals("3001-4000")) {
				and += "rentHousePrice between 3001 and 4000 and ";
			}else if(rentHousePrice.equals("4001")){
				and += "rentHousePrice>4000 and ";
			}
			String rentHouseArea = request.getParameter("area");
			if (!rentHouseArea.equals("0") && rentHouseArea.equals("19")) {
				and += "rentHouseArea between 1 and 19 and ";
			}else if(rentHouseArea.equals("20-40")) {
				and += "rentHouseArea between 20 and 40 and ";
			}else if(rentHouseArea.equals("41-60")) {
				and += "rentHouseArea between 41 and 60 and ";
			}else if(rentHouseArea.equals("61-80")) {
				and += "rentHouseArea between 61 and 80 and ";
			}else if(rentHouseArea.equals("81-100")) {
				and += "rentHouseArea between 81 and 100 and ";
			}else if(rentHouseArea.equals("100")) {
				and += "rentHouseArea>100 and ";
			}
			String rentHouseRoom = request.getParameter("type");
			if (!rentHouseRoom.equals("0")) {
				rentHouseRoom = "'"+rentHouseRoom+"'";
				and += "rentHouseRoom = "+rentHouseRoom+" and ";
			}
			
			
			ToRentHouseService rhs = new ToRentHouseServiceImpl();
			
			List<Map<String, Object>> city = rhs.findCity();
			
			List<Map<String, Object>> type = rhs.findType();
			
			List<ToRentHouse> houseNew = rhs.findNew3();
			
			PageBean<ToRentHouse> pb = rhs.findRentByPage(pageNumber,pageSize,and);
			
			request.setAttribute("house", houseNew);
			request.setAttribute("city", city);
			request.setAttribute("type", type);
			request.setAttribute("pb", pb);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "分页查询失败！");
			return "/jsp/msg.jsp";
		}
		
		return "/jsp/pro_zu.jsp";
	}
	
	
	public String findBySalePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 当前页数pageNumber
			 */
			int pageNumber = 1;
			try {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * 一页显示多少数据pageSize
			 */
			Integer pageSize = 5;
			
			String and = "";
			
			String houseCity = request.getParameter("city");
			if (!houseCity.equals("0")) {
				houseCity = "'"+houseCity+"'";
				and += "houseCity = "+houseCity+" and ";
			}
			String housePrice = request.getParameter("price");
			if (!housePrice.equals("0") && housePrice.equals("40-60")) {
				and += "housePrice between 40 and 60 and "; 
			}else if(housePrice.equals("61-80")) {
				and += "housePrice between 61 and 80 and ";
			}else if(housePrice.equals("81-100")) {
				and += "housePrice between 81 and 100 and ";
			}else if(housePrice.equals("101-120")) {
				and += "housePrice between 101 and 120 and ";
			}else if(housePrice.equals("121")){
				and += "housePrice>120 and ";
			}
			String houseArea = request.getParameter("area");
			if (!houseArea.equals("0") && houseArea.equals("19")) {
				and += "houseArea between 1 and 19 and ";
			}else if(houseArea.equals("20-40")) {
				and += "houseArea between 20 and 40 and ";
			}else if(houseArea.equals("41-60")) {
				and += "houseArea between 41 and 60 and ";
			}else if(houseArea.equals("61-80")) {
				and += "houseArea between 61 and 80 and ";
			}else if(houseArea.equals("81-100")) {
				and += "houseArea between 81 and 100 and ";
			}else if(houseArea.equals("100")) {
				and += "houseArea>100 and ";
			}
			String houseRoom = request.getParameter("type");
			if (!houseRoom.equals("0")) {
				houseRoom = "'"+houseRoom+"'";
				and += "houseRoom = "+houseRoom+" and ";
			}
			
			
			ToSaleHouseService shs = new ToSaleHouseServiceImpl();
			
			List<Map<String, Object>> city = shs.findCity();
			
			List<Map<String, Object>> type = shs.findType();
			
			List<ToSaleHouse> houseNew = shs.findNew3();
			
			PageBean<ToSaleHouse> pb = shs.findSaleByPage(pageNumber,pageSize,and);
			
			request.setAttribute("house", houseNew);
			request.setAttribute("city", city);
			request.setAttribute("type", type);
			request.setAttribute("pb", pb);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "分页查询失败！");
			return "/jsp/msg.jsp";
		}
		
		return "/jsp/pro_er.jsp";
	}
}
