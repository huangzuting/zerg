package com.zm.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/file")
public class FileUploadUtils {
	
	 @RequestMapping("/toFile")  
	    public String toFileUpload() {  
	        return "fileupload";  
	    }  
	  
	
	 @RequestMapping("/fileupload")
	 @ResponseBody
	    public String upload(@RequestParam MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws IOException {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
	        String res = sdf.format(new Date());

	        // uploads文件夹位置
	        String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");
	        System.out.println("uploads文件夹位置"+rootPath);
	        // 原始名称
	        String originalFileName = file.getOriginalFilename();
	        System.out.println("原始名字"+originalFileName);
	        // 新文件名
	        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
	        System.out.println("新文件名字"+newFileName);
	        System.out.println(res);
	        System.out.println(""+originalFileName.substring(originalFileName.lastIndexOf(".")));
	        // 创建年月文件夹
	        Calendar date = Calendar.getInstance();
	        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

	        // 新文件
	        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
	        // 判断目标文件所在目录是否存在
	        if( !newFile.getParentFile().exists()) {
	            // 如果目标文件所在的目录不存在，则创建父目录
	            newFile.getParentFile().mkdirs();
	        }
	        System.out.println(newFile);
	        // 将内存中的数据写入磁盘
	        file.transferTo(newFile);
	        // 完整的url
	        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
	        System.out.println("完整的url："+fileUrl);
	        request.setAttribute("url", fileUrl);
	        response.sendRedirect("/zmEducation/fileupload.jsp");
	        return "/fileupload.jsp";
	    }

}
