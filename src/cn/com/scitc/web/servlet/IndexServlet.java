package cn.com.scitc.web.servlet;


import java.io.IOException;
import java.util.List;

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

public class IndexServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			 ToRentHouseService rhs = new ToRentHouseServiceImpl();
			 ToSaleHouseService shs = new ToSaleHouseServiceImpl();			 
			 List<ToRentHouse> rh = rhs.find4();
			 List<ToSaleHouse> sh = shs.find4();

			 request.setAttribute("rlist", rh);
			 request.setAttribute("slist", sh);
		} catch (Exception e) {
			
		}
		
		 
		return "/jsp/index.jsp";
	}
}
