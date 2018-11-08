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
	 * 跳转
	 */
	public String rentFaBu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请登录~~~~~~~~~");
			return "/jsp/msg.jsp";
		}
		return "/jsp/pro_zu_add.jsp";
	}

	
	public String rentFaBuAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");		
		/*
		 * 上传图片,获取name和value
		 */
		if (ServletFileUpload.isMultipartContent(request)) {
	 
		    try {
			// 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//默认临时文件夹
			// System.out.println(System.getProperty("java.io.tmpdir"));
	 
			// 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// 以byte为单位 不能超过10M 1024byte = 1kb 1024kb=1M 1024M = 1G
			sfu.setSizeMax(10 * 1024 * 1024);
			sfu.setHeaderEncoding("utf-8");
	 
			// 3.
			// 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
			@SuppressWarnings("unchecked")
			List<FileItem> fileItemList = sfu.parseRequest(request);
			Iterator<FileItem> fileItems = fileItemList.iterator();
			Map<String, String> map = new HashMap<>();
			String newFileName="";
			// 4. 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
			while (fileItems.hasNext()) {
				    FileItem fileItem = fileItems.next();
				    // 普通表单元素
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();// name属性值
					String value = fileItem.getString("utf-8");// name对应的value值
					map.put(name, value);
					//System.out.println(name + " = " + value);
			    }
			    // <input type="file">的上传文件的元素
			    else {
				String fileName = fileItem.getName();// 文件名称
				
				//System.out.println("原文件名：" + fileName);// Koala.jpg
	 
				String suffix = fileName.substring(fileName.lastIndexOf('.'));
				//System.out.println("扩展名：" + suffix);// .jpg
	 
				// 新文件名（唯一）
				newFileName ="images\\"+new Date().getTime() + suffix;
				//System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg
	 
				// 5. 调用FileItem的write()方法，写入文件
				//此方法获取到工程webapp文件夹下
				String contexPath= request.getSession().getServletContext().getRealPath("/");
				
				File file = new File(contexPath + newFileName);
				//System.out.println(file.getAbsolutePath());
				fileItem.write(file);
	 
				// 6. 调用FileItem的delete()方法，删除临时文件
				fileItem.delete();
				
			    }
				
			}   
			//封装，调用service保存	
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
			request.setAttribute("msg", "发布成功，耐心等待审核~~~~");
			return "/jsp/msg.jsp";
		    }catch (Exception e) {
		    	e.printStackTrace();
		    	request.setAttribute("msg", "发布失败，重新发布");
				return "/jsp/msg.jsp";
		    }
	 
		}
		return null;
	}
	/*
	 * 跳转
	 */
	public String saleFaBu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请登录~~~~~~~~~");
			return "/jsp/msg.jsp";
		}
		return "/jsp/pro_er_add.jsp";
	}
	public String saleFaBuAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");		
		/*
		 * 上传图片,获取name和value
		 */
		if (ServletFileUpload.isMultipartContent(request)) {
	 
		    try {
			// 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//默认临时文件夹
			// System.out.println(System.getProperty("java.io.tmpdir"));
	 
			// 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// 以byte为单位 不能超过10M 1024byte = 1kb 1024kb=1M 1024M = 1G
			sfu.setSizeMax(10 * 1024 * 1024);
			sfu.setHeaderEncoding("utf-8");
	 
			// 3.
			// 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
			@SuppressWarnings("unchecked")
			List<FileItem> fileItemList = sfu.parseRequest(request);
			Iterator<FileItem> fileItems = fileItemList.iterator();
			Map<String, String> map = new HashMap<>();
			String newFileName="";
			// 4. 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
			while (fileItems.hasNext()) {
				    FileItem fileItem = fileItems.next();
				    // 普通表单元素
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();// name属性值
					String value = fileItem.getString("utf-8");// name对应的value值
					map.put(name, value);
					System.out.println(name + " = " + value);
			    }
			    // <input type="file">的上传文件的元素
			    else {
				String fileName = fileItem.getName();// 文件名称
				
				System.out.println("原文件名：" + fileName);// Koala.jpg
	 
				String suffix = fileName.substring(fileName.lastIndexOf('.'));
				System.out.println("扩展名：" + suffix);// .jpg
	 
				// 新文件名（唯一）
				newFileName ="images\\"+new Date().getTime() + suffix;
				System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg
	 
				// 5. 调用FileItem的write()方法，写入文件
				//此方法获取到工程webapp文件夹下
				String contexPath= request.getSession().getServletContext().getRealPath("/");
				
				File file = new File(contexPath + newFileName);
				System.out.println(file.getAbsolutePath());
				fileItem.write(file);
	 
				// 6. 调用FileItem的delete()方法，删除临时文件
				fileItem.delete();
				
			    }
				
			}   
			//封装，调用service保存	
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
			request.setAttribute("msg", "发布成功，耐心等待审核~~~~");
			return "/jsp/msg.jsp";
		    }catch (Exception e) {
		    	e.printStackTrace();
		    	request.setAttribute("msg", "发布失败，重新发布");
				return "/jsp/msg.jsp";
		    }
	 
		}

		return null;
	}

}
