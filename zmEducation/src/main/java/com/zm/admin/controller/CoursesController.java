package com.zm.admin.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.Courses;
import com.zm.admin.service.CoursesService;
import com.zm.admin.service.MechanismService;
import com.zm.admin.service.TestbookService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/courses")
public class CoursesController {

	@Autowired
	private CoursesService coursesService;

	@Autowired
	private MechanismService mechanismService;

	@Autowired
	private TestbookService testbookService;

	// 127.0.0.1:8080/courses/show.do
	@RequestMapping("/show")
	public String show() {
		return "/jsp/public/courses.jsp";
	}

	// 127.0.0.1:8080/courses/courses-input.do
	@RequestMapping("/courses-input")
	public String input() {
		return "/jsp/public/courses-input.jsp";
	}

	// 127.0.0.1:8080/courses/list.do
	@RequestMapping("/list")
	public List<Courses> list() {
		return coursesService.select();
	}

	// 127.0.0.1:8080/courses/courses-add.do
	@RequestMapping("/courses-add")
	@ResponseBody
	public Map<String, String> add(String name, String info, String price, String mechanismName, String type,
			String classType, Date duration, HttpServletRequest request, HttpServletResponse response) {

		Courses courses = new Courses();
		courses.setName(name);
		courses.setInfo(info);
		courses.setDuration(duration);
		courses.setPrice(price);
		courses.setClassType(classType);
		courses.setType(type);
		/*
		 * 通过mechanismName获得mechanism_id，添加mechanismService方法selectIdByName()
		 * 还需要通过注入EnviroService来添加上课环境
		 */
		courses.setMechanismId(mechanismService.selectIdByName(mechanismName));
		return coursesService.addorupdate(courses);
	}

	// 127.0.0.1:8080/courses/getJson.do
	@RequestMapping("/getJson")
	@ResponseBody
	public JSONArray select() {

		return coursesService.selectJson();
	}

}
