package com.zm.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.admin.dao.SysRole;
import com.zm.admin.service.SysRoleService;

@Controller
@RequestMapping("/systemrole")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping("/list")
	public String show() {

		System.out.println("--------666");

		return "/jsp/system/sys-role.jsp";
	}

	// @RequestMapping("/rolelist")
	// public void rolelist(HttpServletResponse response){
	// List<SysRole> sysrole = sysRoleService.list();
	// String json = JSONArray.fromObject(sysrole).toString();
	//
	// try {
	// response.getWriter().write(json);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	/**
	 * 转发到显示role-menu的页�?
	 */
	@RequestMapping("/role-menu")
	public String showMenu() {
		System.out.println("showMenu~");
		return "/jsp/system/sys-role-menu.jsp";
	}

	/**
	 * 显示角色主页�?
	 */
	@ResponseBody
	@RequestMapping("/rolelist")
	public List<SysRole> roleList() {
		List<SysRole> role = sysRoleService.select();
		return role;

	}

	@RequestMapping("/role-input")
	public String input(String windowid, Model model) {
		model.addAttribute("windowid", windowid);

		return "/jsp/system/sys-role-input.jsp";
	}

	@RequestMapping("/role-saveOrUpdate")
	@ResponseBody
	public Map<String, String> saveOrpdate(String roleName, String flag, int status) {

		SysRole sysRole = new SysRole();
		sysRole.setName(roleName);
		sysRole.setFlag(flag);
		sysRole.setStatus(status);

		System.out.println(sysRole.toString());
		sysRoleService.addorupdate(sysRole);
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "增加成功");

		return data;
	}

	@RequestMapping("/role-delete")
	@ResponseBody
	public Map<String, String> delete(Integer ids) {

		sysRoleService.deleteById(ids);
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "删除成功");
		return data;

	}

}
