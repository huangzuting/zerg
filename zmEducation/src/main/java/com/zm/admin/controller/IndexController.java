package com.zm.admin.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.SysUser;
import com.zm.admin.service.SysUserService;
import com.zm.publics.util.SessionUserUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/login")
public class IndexController {

	@Autowired
	private SysUserService sysUserService;

	// http://127.0.0.1:8080/zmEducation/login/frist.do
	@RequestMapping("/frist")
	public String index() {
		return "/login.jsp";
	}

	// http://127.0.0.1:8080/zmEducation/login/index.do
	@RequestMapping("/index")
	public String show() {
		return "/index.jsp";
	}

	@RequestMapping(path = "/login", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String login(String username, String password, HttpServletResponse response, HttpServletRequest request) {

		SysUser sysUser = sysUserService.getSysUserName(username);
		JSONObject json = new JSONObject();
		System.out.println(sysUser);
		try {

			if (!password.equals(sysUser.getPassword())) {
				json.element("status", false);
				json.element("msg", "密码错误...");
			} else {
				json.element("status", true);
				SessionUserUtil.setOnlineUser(sysUser, request);
				json.element("msg", "index.do");
			}
		} catch (Exception e) {
			json.element("status", false);
			json.element("msg", "用户名不存在...");

		}

		try {
			response.getWriter().write(json.toString());
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json.toString();

	}

}
