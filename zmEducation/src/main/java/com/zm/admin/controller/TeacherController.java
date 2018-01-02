package com.zm.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.Teacher;
import com.zm.admin.service.MechanismService;
import com.zm.admin.service.TeacherService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@Autowired
	private MechanismService mechanismService;

	@RequestMapping("/list")
	public List<Teacher> list() {
		return teacherService.select();
	}

	// 127.0.0.1:8080/teacher/show.do
	@RequestMapping("/show")
	public String show() {
		return "/jsp/public/teacher.jsp";
	}

	// 127.0.0.1:8080/teacher/teacher-input.do
	@RequestMapping("/teacher-input")
	public String input() {
		return "/jsp/public/teacher-input.jsp";
	}

	@RequestMapping("/teacher-add")
	public Map<String, String> add(String name, String info, String mechanismName, HttpServletRequest request,
			HttpServletResponse response) {
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setInfo(info);

		/*
		 * 根据mechanismName获得mechanismId存入,需要注入MechanismService
		 * 
		 */
		teacher.setMechanismId(mechanismService.selectIdByName(mechanismName));

		return teacherService.addorupdate(teacher);
	}
	
	//127.0.0.1:8080/mechanism/getJson.do
	@RequestMapping("/getJson")
	@ResponseBody
	public JSONArray select() {
		return teacherService.selectJson();
	}
	
}
