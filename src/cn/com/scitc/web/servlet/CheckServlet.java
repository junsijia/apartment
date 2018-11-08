package cn.com.scitc.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.dao.impl.UserDaoImpl;
import cn.com.scitc.domain.User;

public class CheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			String userName=request.getParameter("userName");
			/**
			 * 查询数据库里面的user
			 */
			if (userName.equals("")) {
				out.print("<font color='red'>用户名不能为空</font>");
			}else{
				UserDao dao = new UserDaoImpl(); 
				User user = dao.checkName(userName);
				if (user == null) {
					
				}else if(user.getUserName().equals(userName)){
					out.print("<font color='red'>已存在</font>");
				}
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
