package cn.com.scitc.web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.scitc.domain.Admin;
import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.domain.User;
import cn.com.scitc.service.AdminService;
import cn.com.scitc.service.impl.AdminServiceImpl;
import cn.com.scitc.web.servlet.base.BaseServlet;

public class AdminServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	
	public String tiaozhuan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			return "/WEB-INF/login.jsp";
	}
	
	public String introduce(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/WEB-INF/introduce.jsp";
	}
	
	
	public String house_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AdminService as = new AdminServiceImpl();
			List<ToRentHouse> list = as.findRentAll();
			if (list != null) {
				request.setAttribute("rh", list);
				return "/WEB-INF/house_list.jsp";
			}else {
				request.setAttribute("msg", "≤È—Ø ß∞‹");
				return "/WEB-INF/index.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String house_list1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AdminService as = new AdminServiceImpl();
			List<ToSaleHouse> list = as.findSaleAll();
			if (list != null) {
				request.setAttribute("sh", list);
				return "/WEB-INF/house_list1.jsp";
			}else {
				request.setAttribute("msg", "≤È—Ø ß∞‹");
				return "/WEB-INF/index.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminService as = new AdminServiceImpl();
		try {
			as.del(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/servlet/AdminServlet?method=house_list";
	}
	
	public String del1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminService as = new AdminServiceImpl();
		try {
			as.del1(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/servlet/AdminServlet?method=house_list";
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminService as = new AdminServiceImpl();
		try {
			as.update(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/servlet/AdminServlet?method=house_list";
	}
	
	public String up(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminService as = new AdminServiceImpl();
		try {
			as.up(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/servlet/AdminServlet?method=house_list";
	}
		

	public String update1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminService as = new AdminServiceImpl();
		try {
			as.update1(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/servlet/AdminServlet?method=house_list";
	}
	
	public String up1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminService as = new AdminServiceImpl();
		try {
			as.up1(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/servlet/AdminServlet?method=house_list";
	}
/*
 * µ«¬º
 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			AdminService as = new AdminServiceImpl();
			Admin admin = as.findNameAndPwd(name,pwd);		
			if (admin != null) {
				request.getSession().setAttribute("admin", admin);
				return "/WEB-INF/index.jsp";
			}else {
				return "/WEB-INF/login.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/*
 * ”√ªßπ‹¿Ì
 */
	public String user_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AdminService as = new AdminServiceImpl();
			List<User> list = as.findUser();
			if (list != null) {
				request.setAttribute("user", list);
				return "/WEB-INF/user_list.jsp";
			}else {
				request.setAttribute("msg", "≤È—Ø ß∞‹");
				return "/WEB-INF/index.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String delUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminService as = new AdminServiceImpl();
		try {
			as.delUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/servlet/AdminServlet?method=user_list";

	}
	
	public String order_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AdminService as = new AdminServiceImpl();
			List<OrderRent> list = as.findOrder();
			if (list != null) {
				request.setAttribute("order", list);
				return "/WEB-INF/order_list.jsp";
			}else {
				request.setAttribute("msg", "≤È—Ø ß∞‹");
				return "/WEB-INF/index.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
