package cn.com.scitc.web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
















import cn.com.scitc.domain.OrderRent;
import cn.com.scitc.domain.User;
import cn.com.scitc.service.OrderRentService;
import cn.com.scitc.service.UserService;
import cn.com.scitc.service.impl.OrderRentServiceImpl;
import cn.com.scitc.service.impl.UserServiceImpl;
import cn.com.scitc.utils.UUIDUtils;
import cn.com.scitc.web.servlet.base.BaseServlet;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public String login(HttpServletRequest request, HttpServletResponse response)
			{
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		try {
			UserService us = new UserServiceImpl();
			User user = us.login(username,password);
			
			if (user == null) {
				request.setAttribute("msg", "�û��������벻ƥ��");
				return "/jsp/login.jsp";
			}
			
			request.getSession().setAttribute("user", user);
			
			response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "�û���¼ʧ�ܣ�");
		}
		return null;
	}
	
	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			User user = new User();
			user.setUserId(UUIDUtils.getId());
			user.setUserName(request.getParameter("user"));
			user.setUserPassword(request.getParameter("password"));
			user.setLinkPerson(request.getParameter("linkPerson"));
			user.setTelphone(request.getParameter("telphone"));
			user.setEmail(request.getParameter("email"));
			user.setSex("��");
			user.setAge(0);
			user.setQq("");
			user.setSignature("");
			UserService us=new UserServiceImpl();
			us.regist(user);
			//3.ҳ��ת�� ��ʾ��Ϣ
			request.setAttribute("msg", "��ϲ��,ע��ɹ�!");
		}catch (Exception e) {
			e.printStackTrace();
			//ת���� msg.jsp
			request.setAttribute("msg", "�û�ע��ʧ��!");
			return "/jsp/msg.jsp";
		}
		return "/jsp/msg.jsp";
		
	}

	public String registUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	
	public String loginUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsp/login.jsp";
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/servlet/IndexServlet?method=index");
		return null;
	}
	
	
	public String center(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//����user
			User user = (User) request.getSession().getAttribute("user");
			UserService us = new UserServiceImpl();
			User user_new = us.login(user.getUserName(),user.getUserPassword());
			request.getSession().setAttribute("user", user_new);
		} catch (Exception e) {
		}
		if (request.getSession().getAttribute("user")==null) {
			request.setAttribute("msg", "��ǰȥ��¼��");
			return "/jsp/msg.jsp";
		}
		return "/jsp/user.jsp";
	}

	public String nameAndPwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("userId");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			UserService us = new UserServiceImpl();
			us.nameAndPwd(id,name,password);
			request.setAttribute("msg", "�޸ĳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "�޸�ʧ��");
			response.sendRedirect("/jsp/msg.jsp");
		}
		return "/jsp/msg.jsp";
	}
	
	public String updataUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
			try {
				String id = request.getParameter("userId");
				String linkPerson = request.getParameter("linkPerson");
				Integer age = Integer.parseInt(request.getParameter("age"));
				String sex = request.getParameter("sex");
				String qq = request.getParameter("qq");
				String signature = request.getParameter("signature");
				UserService us = new UserServiceImpl();
				us.updataUser(id,linkPerson,age,sex,qq,signature);
				request.setAttribute("msg", "�޸ĳɹ�");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "�޸�ʧ��");
				response.sendRedirect("/jsp/msg.jsp");
			}
		return "/jsp/msg.jsp";
	}
	
	public String user_pwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsp/user_pwd.jsp";
	}
	
	public String attention(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsp/attention.jsp";
	}
	
	public String order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("user");
			OrderRentService ors = new OrderRentServiceImpl();			
			List<OrderRent> or = ors.findByUserName(user.getUserName());			
			request.setAttribute("bean", or);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", "��ѯʧ��");
			response.sendRedirect("/jsp/msg.jsp");
		}
		return "/jsp/order_info.jsp";
	}
	
}
