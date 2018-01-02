package com.zm.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.SysMenu;
import com.zm.admin.dao.SysUser;
import com.zm.admin.mapper.RoleMenuMapper;
import com.zm.admin.service.SysMenuService;
import com.zm.admin.service.SysUserService;
import com.zm.publics.util.SessionUserUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/systemmenu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@RequestMapping("/list")
	public String show() {
		System.out.println("menu----!!!");
		return "/jsp/system/sys-menu.jsp";
	}

	@RequestMapping("/menulist")
	public void menuList(HttpServletResponse response, HttpServletRequest request) {
		SysUser sysUser = sysUserService.getSysUserName(SessionUserUtil.getOnlineUser(request).getUsername());

		List<Integer> menuIds = roleMenuMapper.selectmenu(sysUser.getRoleId());
		JSONArray array = new JSONArray();
		for (Integer menuid : menuIds) {
			JSONObject json = sysMenuService.getUpTree(menuid);
			array.add(json);
			System.out.println(array.toString());
		}
		

		try {
			response.getWriter().write(JSONArray.fromObject(array).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/menu-input")
	public String input(String windowid, Model model) {
		model.addAttribute("windowid", windowid);
		return "/jsp/system/sys-menu-input.jsp";
	}

	@ResponseBody
	@RequestMapping("/menu-addOrUpdate")
	public Map<String, String> saveOrUpdate(Integer id, String menuName, Integer pid, String url, String defineRight) {
		SysMenu menu = new SysMenu();
		if (id == null) {
			id = -1;
		}
		menu.setId(id);
		menu.setName(menuName);
		menu.setpId(pid);
		menu.setPageUrl(url);

		sysMenuService.addorupdate(menu);

		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");

		return data;

	}

	@ResponseBody
	@RequestMapping("/menu-delete")
	public Map<String, String> delete(Integer id) {

		sysMenuService.deleteById(id);
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");

		return data;
	}

}
