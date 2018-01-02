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

	        // uploads�ļ���λ��
	        String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");
	        System.out.println("uploads�ļ���λ��"+rootPath);
	        // ԭʼ����
	        String originalFileName = file.getOriginalFilename();
	        System.out.println("ԭʼ����"+originalFileName);
	        // ���ļ���
	        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
	        System.out.println("���ļ�����"+newFileName);
	        System.out.println(res);
	        System.out.println(""+originalFileName.substring(originalFileName.lastIndexOf(".")));
	        // ���������ļ���
	        Calendar date = Calendar.getInstance();
	        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

	        // ���ļ�
	        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
	        // �ж�Ŀ���ļ�����Ŀ¼�Ƿ����
	        if( !newFile.getParentFile().exists()) {
	            // ���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
	            newFile.getParentFile().mkdirs();
	        }
	        System.out.println(newFile);
	        // ���ڴ��е�����д�����
	        file.transferTo(newFile);
	        // ������url
	        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
	        System.out.println("������url��"+fileUrl);
	        request.setAttribute("url", fileUrl);
	        response.sendRedirect("/zmEducation/fileupload.jsp");
	        return "/fileupload.jsp";
	    }

}
