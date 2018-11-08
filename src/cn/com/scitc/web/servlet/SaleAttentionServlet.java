package cn.com.scitc.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import cn.com.scitc.dao.ToSaleHouseDao;

import cn.com.scitc.dao.impl.ToSaleHouseDaoImpl;
import cn.com.scitc.domain.RentAttention;

import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToRentHouseItem;
import cn.com.scitc.domain.ToSaleHouse;

import cn.com.scitc.web.servlet.base.BaseServlet;

public class SaleAttentionServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	

	
	
	public String remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��Ʒ��id
		String id = request.getParameter("id");
		
		//2.��ȡ���ﳵ ִ���Ƴ�
		getAttention(request).delAttention(id);
		
		//3.�ض���
		response.sendRedirect(request.getContextPath()+"/jsp/attention.jsp");
		return null;
	}
	

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getSession().getAttribute("user")==null) {
			request.setAttribute("msg", "��ǰȥ��¼��");
			return "/jsp/msg.jsp";
		}else{
			try {
				String id = request.getParameter("id");
				
				ToRentHouse rh = new ToRentHouse();
				ToSaleHouseDao dao = new ToSaleHouseDaoImpl();
				ToSaleHouse sh = dao.findById(id);
				
				/*
				 * ��װ
				 */
				rh.setRentHouseId(sh.getHouseId());
				rh.setRentHouseAddress(sh.getHouseAddress());
				rh.setRentHouseCity(sh.getHouseCity());
				rh.setRentHousePrice(sh.getHousePrice());
				rh.setRentHouseRoom(sh.getHouseRoom());
				rh.setRentHouseArea(sh.getHouseArea());
				rh.setRentHouseDecoration(sh.getDecoration());
				rh.setRentHousePicture(sh.getHousePicture());
				
				//����ToRentHouseItem
				
				ToRentHouseItem toRentHouseItem = new ToRentHouseItem(rh);
				/*
				 * ��ȡ��ע��session
				 */
				RentAttention rentAttention= getAttention(request);
				rentAttention.addAttention(toRentHouseItem);
				 
				 
				 
				 response.sendRedirect(request.getContextPath()+"/jsp/attention.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "��Ʒ��עʧ�ܣ�");
				return "/jsp/msg.jsp";
			}
		}
		return null;
	}
	/*
	 * ��ȡ��ע��
	 */
	public RentAttention getAttention(HttpServletRequest request) {
		/*
		 * ��ȡsession
		 */
		RentAttention attention = (RentAttention) request.getSession().getAttribute("attention");
		if (attention == null) {
			attention = new RentAttention();
			
			request.getSession().setAttribute("attention", attention);
		}
		/*
		 * attention���ö���
		 */
		return attention;
	}

}
