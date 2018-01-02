package rental_management.system.controller;

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

import net.sf.json.JSONArray;
import rental_management.publics.util.SessionUserUtil;
import rental_management.system.bean.SystemMenu;
import rental_management.system.bean.SystemUser;
import rental_management.system.mapper.RoleMenuMapper;
import rental_management.system.service.SystemMenuService;
import rental_management.system.service.SystemUserService;

@Controller
@RequestMapping("/systemmenu")
public class SystemMenuController {
	
	@Autowired
	private SystemMenuService systemMenuService; 
	
	@Autowired
	private SystemUserService systemUserService;
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	@RequestMapping("/list")
	public String show(){
		System.out.println("menu----!!!");
		return "/jsp/system/sys-menu.jsp";
	}
	
	@RequestMapping("/menulist")
	public void menuList(HttpServletResponse response,HttpServletRequest request){
		
		SystemUser systemUser=systemUserService.getSystemUser(SessionUserUtil.getOnlineUser(request).getName());
		List<Integer> menuIds=roleMenuMapper.selectmenu(systemUser.getRoleId());
		JSONArray array=new JSONArray();
		for (Integer menuid : menuIds) {
			array.add(systemMenuService.getUpTree(menuid));
		}

		try {
			response.getWriter().write(JSONArray.fromObject(array).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@RequestMapping("/menu-input")
	public String input(String windowid,
			Model model){
		model.addAttribute("windowid", windowid);
		return "/jsp/system/sys-menu-input.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/menu-saveOrUpdate")
	public Map<String, String> saveOrUpdate(Integer id,String menuName, Integer pid,String url,String defineRight){
		SystemMenu menu = new SystemMenu();
		if(id==null){
			id=-1;
		}
		menu.setId(id);
		menu.setName(menuName);
		menu.setPid(pid);
		menu.setPageUrl(url);
		menu.setDefineRight(defineRight);
		
	    systemMenuService.saveOrUpdate(menu);
		
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");
		
		return data;
		
	}
	
	@ResponseBody
	@RequestMapping("/menu-delete")
	public Map<String, String> delete(Integer id){
		
		systemMenuService.delete(id);
		
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");
		
		return data;
	}
	
	
	
	
}
