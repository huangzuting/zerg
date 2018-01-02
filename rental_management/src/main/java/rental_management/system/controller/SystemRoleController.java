package rental_management.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import rental_management.system.bean.SystemRole;
import rental_management.system.service.SystemRoleService;

@Controller
@RequestMapping("/systemrole")
public class SystemRoleController {
	@Autowired
	private SystemRoleService systemRoleService;
	
	@RequestMapping("/list")
	public String show(){
		
		System.out.println("--------666");

		return "/jsp/system/sys-role.jsp";
	}
	
//	@RequestMapping("/rolelist")
//	public void rolelist(HttpServletResponse response){
//		List<SystemRole> systemrole = systemRoleService.list();
//		String json = JSONArray.fromObject(systemrole).toString();
//		
//		try {
//			response.getWriter().write(json);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	/**
	 * 转发到显示role-menu的页面
	 */
	@RequestMapping("/role-menu")
	public String showMenu(){
		System.out.println("showMenu~");
		return "/jsp/system/sys-role-menu.jsp";
	}
	
	/**
	 * 显示角色主页面
	 */
	@ResponseBody
	@RequestMapping("/rolelist")
	public List<SystemRole> roleList(){
		List<SystemRole> role = systemRoleService.list();
		return role;
		
	}
	
	@RequestMapping("/role-input")
	public String input(String windowid,Model model){
		model.addAttribute("windowid",windowid);
		
		return "/jsp/system/sys-role-input.jsp";
	}
	
	@RequestMapping("/role-saveOrUpdate")
	@ResponseBody
	public Map<String, String> saveOrpdate(String roleName,String flag,int status){
	
			SystemRole sysRole = new SystemRole();
			sysRole.setRoleName(roleName);
			sysRole.setFlag(flag);
			sysRole.setStatus(status);
			
			System.out.println(sysRole.toString());
		
		
	
		systemRoleService.saveOrUpdate(sysRole);
		Map<String,String> data=new HashMap<>();
		data.put("status", "true");
		data.put("msg", "增加成功");
		
		return data;
	}
	
	@RequestMapping("/role-delete")
	@ResponseBody
	public Map<String, String> delete(Integer ids){
		
		systemRoleService.delete(ids);//只能删除一条。。升级中
		Map<String,String> data=new HashMap<>();
		data.put("status", "true");
		data.put("msg", "删除成功");
		return data;
		
	}
	
	
	

	
	
}
