package com.zm.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.Mechanism;
import com.zm.admin.service.MechanismService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/mechanism")
public class MechanismController {

	@Autowired
	private MechanismService mechanismService;

	//127.0.0.1:8080/mechanism/show.do
	@RequestMapping("/show")
	public String show() {
		return "/jsp/public/mechanism.jsp";
	}
	
	//127.0.0.1:8080/mechanism/mechanism-input.do
	@RequestMapping("/mechanism-input")
	public String input() {
		return "/jsp/public/mechanism-input.jsp";
	}
	
	//127.0.0.1:8080/mechanism/list.do
	@RequestMapping("/list")
	public List<Mechanism> list(){
		return mechanismService.select();
	}

	//127.0.0.1:8080/mechanism/mechanism-add.do
	@RequestMapping("/mechanism-add")
	@ResponseBody
	public Map<String, String> add(String name, String address, String info, String testService,
			String schoolPermit, String logoUrl, String businessLicense, String contact, String phone,
			HttpServletResponse response, HttpServletRequest request) {
		Mechanism mechanism = new Mechanism();
		mechanism.setName(name);
		mechanism.setAddress(address);
		mechanism.setInfo(info);
		mechanism.setSchoolPermit(schoolPermit);
		mechanism.setTestService(testService);
		mechanism.setBusinessLicense(businessLicense);
		mechanism.setLogo(logoUrl);
		mechanism.setContact(contact);
		mechanism.setPhone(phone);
		/*
		 * 还需要通过注入EnviroService来添加上课环境
		 * 
		 * */
		
		return mechanismService.addorupdate(mechanism);
	}
	
	//127.0.0.1:8080/mechanism/getJson.do
	@RequestMapping("/getJson")
	@ResponseBody
	public JSONArray select() {
		return mechanismService.selectJson();
	}

}
