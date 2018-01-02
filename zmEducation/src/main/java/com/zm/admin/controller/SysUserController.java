package com.zm.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.SysUser;
import com.zm.admin.service.SysUserService;
import com.zm.publics.util.JsonUtils;
import com.zm.publics.util.Push;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/systemuser")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;

	// http://127.0.0.1:8080/zmeducation/sysuser/list.do
	@RequestMapping("/list")
	public String aaa() {

		return "/jsp/system/sys-user.jsp";
	}

	@RequestMapping("/syslist")
	public String sys() {

		return "/jsp/system/sysUserSelect.jsp";
	}
	
	@RequestMapping("/userlist")
	public void syslist(HttpServletRequest request,HttpServletResponse response) {
		List<SysUser> sysusers = sysUserService.select();
		JSONArray jsonArray  = new JSONArray();
		for (SysUser sysUser : sysusers) {
			jsonArray.add(JsonUtils.toJson(sysUser));
		}

		System.out.println(jsonArray.toString());
		Push push = new Push();
		try {
			push.push(jsonArray,request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	@RequestMapping(path = "/userList2", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<SysUser> sysList2() {

		return sysUserService.select();
	}

	@RequestMapping("/me")
	public void me(HttpServletResponse response) {

		List<SysUser> sysusers = sysUserService.select();
		String text = JSONArray.fromObject(sysusers).toString();

		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/sys-user-input")
	public String sysuserinput() {

		return "/jsp/system/sys-user-input.jsp";
	}
	
	//http://127.0.0.1:8080/zmeducation/sysuser/sysuser-add.do
	@RequestMapping("/sysuser-add")
	public Map<String, String> cardInput2(String name, String password, Integer status, HttpServletRequest request,HttpServletResponse response) {

		SysUser sUser = new SysUser();

		sUser.setUsername(name);
		sUser.setPassword(password);
		sUser.setStatus(status);
		sUser.setRoleId(1);

		sysUserService.addorupdate(sUser);

		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "添加成功");

		return data;
	}

}
