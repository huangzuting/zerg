package com.zm.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.Testbook;
import com.zm.admin.service.CoursesService;
import com.zm.admin.service.TestbookService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/testbook")
public class TestbookController {
		@Autowired
		private TestbookService testbookService;
		
		@Autowired
		private CoursesService coursesService;
		
		@RequestMapping("/list")
		public List<Testbook> list(){
			return testbookService.select();
		}
		
		// 127.0.0.1:8080/testbook/show.do
		@RequestMapping("/show")
		public String show() {
			return "/jsp/public/teacher.jsp";
		}

		// 127.0.0.1:8080/testbook/testbook-input.do
		@RequestMapping("/testbook-input")
		public String input() {
			return "/jsp/public/testbook-input.jsp";
		}
		
		@RequestMapping("/testbook-add")
		public Map<String, String> add (String name , String info ,String coursesName,
				HttpServletRequest request,HttpServletResponse response){
			Testbook testbook = new  Testbook();
			testbook.setName(name);
			testbook.setInfo(info);
			/*通过coursesName来获得coursesId，需注入CoursesService并调用selectIdByName()方法
			 * 
			 * */
			testbook.setCoursesId(coursesService.selectIdByName(coursesName));		
			return testbookService.addorupdate(testbook);
		}
		
		//127.0.0.1:8080/testbook/getJson.do
		@RequestMapping("/getJson")
		@ResponseBody
		public JSONArray select() {
			return testbookService.selectJson();
		}

		
}
