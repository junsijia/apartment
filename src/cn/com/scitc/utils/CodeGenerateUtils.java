package cn.com.scitc.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CodeGenerateUtils {
	
	public class ImageZipUtil {
	}
		
	public static void main(String[] args) {
		//zipWidthHeightImageFile(new File("C:\\spider\\3.png"),new File("C:\\spider\\3-1.jpg"),425,638,0.7f);
		
		//zipImageFile(new File("D:\\Program Files\\apache-tomcat\\apache-tomcat-8.5.33\\webapps\\house\\images\\1540362177416.jpg"),new File("D:\\Program Files\\apache-tomcat\\apache-tomcat-8.5.33\\webapps\\house\\images\\1540362177416_s.jpg"),425,638,0.7f);
		
		//zipImageFile(new File("C:\\spider\\3.jpg"),new File("C:\\spider\\3-3.jpg"),425,638,0.7f);		
		System.out.println("ok");
	}
	  
	    /** 
	     * 根据设置的宽高等比例压缩图片文件<br> 先保存原文件，再压缩、上传 
	     * @param oldFile  要进行压缩的文件 
	     * @param newFile  新文件 
	     * @param width  宽度 //设置宽度时（高度传入0，等比例缩放） 
	     * @param height 高度 //设置高度时（宽度传入0，等比例缩放） 
	     * @param quality 质量 
	     * @return 返回压缩后的文件的全路径 
	     */  
	    public static String zipImageFile(File oldFile,File newFile, int width, int height,float quality) {  
	        if (oldFile == null) {  
	            return null;  
	        }  
	        try {  
	            /** 对服务器上的临时文件进行处理 */  
	            Image srcFile = ImageIO.read(oldFile);  
	            int w = srcFile.getWidth(null);  
	            int h = srcFile.getHeight(null);  
	            double bili;  
	            if(width>0){  
	                bili=width/(double)w;  
	                height = (int) (h*bili);  
	            }else{  
	                if(height>0){  
	                    bili=height/(double)h;  
	                    width = (int) (w*bili);  
	                }  
	            }  
	            
	            String srcImgPath = newFile.getAbsoluteFile().toString();
	            System.out.println(srcImgPath);
	            String subfix = "jpg";
	    		subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".")+1,srcImgPath.length());
	 
	    		BufferedImage buffImg = null; 
	    		if(subfix.equals("png")){
	    			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    		}else{
	    			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    		}
	 
	    		Graphics2D graphics = buffImg.createGraphics();
	    		graphics.setBackground(new Color(255,255,255));
	    		graphics.setColor(new Color(255,255,255));
	    		graphics.fillRect(0, 0, width, height);
	    		graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);  
	 
	    		ImageIO.write(buffImg, subfix, new File(srcImgPath));  
	  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return newFile.getAbsolutePath();  
	    }
	
}
