package cn.com.scitc.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.service.ToRentHouseService;
import cn.com.scitc.service.ToSaleHouseService;
import cn.com.scitc.service.impl.ToRentHouseServiceImpl;
import cn.com.scitc.service.impl.ToSaleHouseServiceImpl;
import cn.com.scitc.web.servlet.base.BaseServlet;

public class InfoServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	

	public String getByRentId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			ToRentHouseService rhs = new ToRentHouseServiceImpl();
			ToRentHouse rh = rhs.findById(id);
			if (rh == null) {
				getBySaleId(request, response,id);
				return "/jsp/saleinfo.jsp";
			}else {
				request.setAttribute("rentBean", rh);
				return "/jsp/rentinfo.jsp";
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "查询单个商品失败！");
			return "/jsp/msg.jsp";
		}
		
	}



	private void getBySaleId(HttpServletRequest request,
			HttpServletResponse response, String id) {
			try {
				ToSaleHouseService shs = new ToSaleHouseServiceImpl();
				ToSaleHouse sh = shs.findById(id);
				request.setAttribute("saleBean", sh);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg", "查询单个商品失败！");
			}
		
	}



	public String getBySaleId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			ToSaleHouseService shs = new ToSaleHouseServiceImpl();
			ToSaleHouse sh = shs.findById(id);
			request.setAttribute("saleBean", sh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "查询单个商品失败！");
			return "/jsp/msg.jsp";
		}
		return "/jsp/saleinfo.jsp";
	}

}
