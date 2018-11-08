package cn.com.scitc.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;








import cn.com.scitc.domain.ToRentHouse;
import cn.com.scitc.domain.ToSaleHouse;
import cn.com.scitc.domain.User;
import cn.com.scitc.service.ToRentHouseService;
import cn.com.scitc.service.ToSaleHouseService;
import cn.com.scitc.service.impl.ToRentHouseServiceImpl;
import cn.com.scitc.service.impl.ToSaleHouseServiceImpl;
import cn.com.scitc.utils.DateUtils;
import cn.com.scitc.utils.UUIDUtils;
import cn.com.scitc.web.servlet.base.BaseServlet;

public class FaBuServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	/*
	 * ��ת
	 */
	public String rentFaBu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "���¼~~~~~~~~~");
			return "/jsp/msg.jsp";
		}
		return "/jsp/pro_zu_add.jsp";
	}

	
	public String rentFaBuAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");		
		/*
		 * �ϴ�ͼƬ,��ȡname��value
		 */
		if (ServletFileUpload.isMultipartContent(request)) {
	 
		    try {
			// 1. ����DiskFileItemFactory�������û�������С����ʱ�ļ�Ŀ¼
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//Ĭ����ʱ�ļ���
			// System.out.println(System.getProperty("java.io.tmpdir"));
	 
			// 2. ����ServletFileUpload���󣬲������ϴ��ļ��Ĵ�С���ơ�
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// ��byteΪ��λ ���ܳ���10M 1024byte = 1kb 1024kb=1M 1024M = 1G
			sfu.setSizeMax(10 * 1024 * 1024);
			sfu.setHeaderEncoding("utf-8");
	 
			// 3.
			// ����ServletFileUpload.parseRequest��������request���󣬵õ�һ�������������ϴ����ݵ�List����
			@SuppressWarnings("unchecked")
			List<FileItem> fileItemList = sfu.parseRequest(request);
			Iterator<FileItem> fileItems = fileItemList.iterator();
			Map<String, String> map = new HashMap<>();
			String newFileName="";
			// 4. ����list��ÿ����һ��FileItem���󣬵�����isFormField�����ж��Ƿ����ϴ��ļ�
			while (fileItems.hasNext()) {
				    FileItem fileItem = fileItems.next();
				    // ��ͨ��Ԫ��
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();// name����ֵ
					String value = fileItem.getString("utf-8");// name��Ӧ��valueֵ
					map.put(name, value);
					//System.out.println(name + " = " + value);
			    }
			    // <input type="file">���ϴ��ļ���Ԫ��
			    else {
				String fileName = fileItem.getName();// �ļ�����
				
				//System.out.println("ԭ�ļ�����" + fileName);// Koala.jpg
	 
				String suffix = fileName.substring(fileName.lastIndexOf('.'));
				//System.out.println("��չ����" + suffix);// .jpg
	 
				// ���ļ�����Ψһ��
				newFileName ="images\\"+new Date().getTime() + suffix;
				//System.out.println("���ļ�����" + newFileName);// image\1478509873038.jpg
	 
				// 5. ����FileItem��write()������д���ļ�
				//�˷�����ȡ������webapp�ļ�����
				String contexPath= request.getSession().getServletContext().getRealPath("/");
				
				File file = new File(contexPath + newFileName);
				//System.out.println(file.getAbsolutePath());
				fileItem.write(file);
	 
				// 6. ����FileItem��delete()������ɾ����ʱ�ļ�
				fileItem.delete();
				
			    }
				
			}   
			//��װ������service����	
			ToRentHouse rh = new ToRentHouse();		
			rh.setRentHouseId(UUIDUtils.getId());
			rh.setRentHouseShen(map.get("shen"));
			rh.setRentHouseCity(map.get("shi"));
			rh.setRentHouseAddress(map.get("address"));
			rh.setRentHouseRoom(map.get("room"));
			rh.setRentHouseArea(Double.parseDouble(map.get("area")));
			rh.setRentHouseDecoration(map.get("decoration"));
			rh.setRentHousePrice(Double.parseDouble(map.get("price")));
			rh.setRentHousePicture(newFileName);
			
			rh.setRentHouseBuildedTime(map.get("date"));
			rh.setDepoist(map.get("depoist"));
			
			rh.setVerify(0);
			rh.setPublishdate(DateUtils.getDate());
			rh.setUsername(user.getUserName());
			rh.setDescrible(map.get("sign"));
			
			ToRentHouseService rhs = new ToRentHouseServiceImpl();
			rhs.add(rh);
			request.setAttribute("msg", "�����ɹ������ĵȴ����~~~~");
			return "/jsp/msg.jsp";
		    }catch (Exception e) {
		    	e.printStackTrace();
		    	request.setAttribute("msg", "����ʧ�ܣ����·���");
				return "/jsp/msg.jsp";
		    }
	 
		}
		return null;
	}
	/*
	 * ��ת
	 */
	public String saleFaBu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "���¼~~~~~~~~~");
			return "/jsp/msg.jsp";
		}
		return "/jsp/pro_er_add.jsp";
	}
	public String saleFaBuAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");		
		/*
		 * �ϴ�ͼƬ,��ȡname��value
		 */
		if (ServletFileUpload.isMultipartContent(request)) {
	 
		    try {
			// 1. ����DiskFileItemFactory�������û�������С����ʱ�ļ�Ŀ¼
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//Ĭ����ʱ�ļ���
			// System.out.println(System.getProperty("java.io.tmpdir"));
	 
			// 2. ����ServletFileUpload���󣬲������ϴ��ļ��Ĵ�С���ơ�
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// ��byteΪ��λ ���ܳ���10M 1024byte = 1kb 1024kb=1M 1024M = 1G
			sfu.setSizeMax(10 * 1024 * 1024);
			sfu.setHeaderEncoding("utf-8");
	 
			// 3.
			// ����ServletFileUpload.parseRequest��������request���󣬵õ�һ�������������ϴ����ݵ�List����
			@SuppressWarnings("unchecked")
			List<FileItem> fileItemList = sfu.parseRequest(request);
			Iterator<FileItem> fileItems = fileItemList.iterator();
			Map<String, String> map = new HashMap<>();
			String newFileName="";
			// 4. ����list��ÿ����һ��FileItem���󣬵�����isFormField�����ж��Ƿ����ϴ��ļ�
			while (fileItems.hasNext()) {
				    FileItem fileItem = fileItems.next();
				    // ��ͨ��Ԫ��
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();// name����ֵ
					String value = fileItem.getString("utf-8");// name��Ӧ��valueֵ
					map.put(name, value);
					System.out.println(name + " = " + value);
			    }
			    // <input type="file">���ϴ��ļ���Ԫ��
			    else {
				String fileName = fileItem.getName();// �ļ�����
				
				System.out.println("ԭ�ļ�����" + fileName);// Koala.jpg
	 
				String suffix = fileName.substring(fileName.lastIndexOf('.'));
				System.out.println("��չ����" + suffix);// .jpg
	 
				// ���ļ�����Ψһ��
				newFileName ="images\\"+new Date().getTime() + suffix;
				System.out.println("���ļ�����" + newFileName);// image\1478509873038.jpg
	 
				// 5. ����FileItem��write()������д���ļ�
				//�˷�����ȡ������webapp�ļ�����
				String contexPath= request.getSession().getServletContext().getRealPath("/");
				
				File file = new File(contexPath + newFileName);
				System.out.println(file.getAbsolutePath());
				fileItem.write(file);
	 
				// 6. ����FileItem��delete()������ɾ����ʱ�ļ�
				fileItem.delete();
				
			    }
				
			}   
			//��װ������service����	
			ToSaleHouse sh = new ToSaleHouse();		
			sh.setHouseId(UUIDUtils.getId());
			sh.setHouseShen(map.get("shen"));
			sh.setHouseCity(map.get("shi"));
			sh.setHouseAddress(map.get("address"));
			sh.setHouseRoom(map.get("room"));
			sh.setHouseArea(Double.parseDouble(map.get("area")));
			sh.setDecoration(map.get("decoration"));
			sh.setHousePrice(Double.parseDouble(map.get("price")));
			sh.setHousePicture(newFileName);			
			sh.setBuilddate(map.get("date"));
			sh.setHouseType(map.get("housetype"));
			sh.setFloor("");
			sh.setVerify(0);
			sh.setPublishdate(DateUtils.getDate());
			sh.setUserName(user.getUserName());
			sh.setDescrible(map.get("sign"));
			
			ToSaleHouseService shs = new ToSaleHouseServiceImpl();
			shs.add(sh);
			request.setAttribute("msg", "�����ɹ������ĵȴ����~~~~");
			return "/jsp/msg.jsp";
		    }catch (Exception e) {
		    	e.printStackTrace();
		    	request.setAttribute("msg", "����ʧ�ܣ����·���");
				return "/jsp/msg.jsp";
		    }
	 
		}

		return null;
	}

}
