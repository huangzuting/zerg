package rental_management.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;










import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rental_management.publics.util.Push;
import rental_management.publics.util.SessionUserUtil;
import rental_management.system.bean.SystemUser;
import rental_management.system.service.SystemUserService;


@Controller
@RequestMapping("/systemuser")
public class SystemUserController {
	@Autowired
	private SystemUserService systemUserService;
	
	
	//http://127.0.0.1:8080/rental_management/systemuser/list.do
	@RequestMapping("/list")
	public String aaa(){
		
		return "/jsp/system/sys-user.jsp";
	}
	
	@RequestMapping("/syslist")
	public String sys(){
		
		return "/jsp/system/sysUserSelect.jsp";
	}
	
	@RequestMapping("/userlist")
	public void syslist() {
		List<SystemUser> systemusers = systemUserService.list();
		JSONArray jsonArray = JSONArray.fromObject(systemusers);
		
		System.out.println(jsonArray.toString());
		Push push=new Push();
		try {
			push.push(jsonArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	@RequestMapping(path="/userList2",produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<SystemUser> sysList2(){
		
	return	systemUserService.list();
	}
	
	
	@RequestMapping("/me")
	public void me(HttpServletResponse response){
		
		List<SystemUser> systemusers = systemUserService.list();
		String text = JSONArray.fromObject(systemusers).toString();
	
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/sys-user-input")
	public String sysuserinput(){
		
		return "/jsp/system/sys-user-input.jsp";
	}
	
	@RequestMapping("/sysuser-add")
	@ResponseBody
	public Map<String, String> cardInput2(String name, String sex,
			String password, String status, String phone,HttpServletRequest request) {
				
		SystemUser sUser=new SystemUser();
		
		sUser.setName(name);
		sUser.setPassword(password);
		sUser.setPhone(phone);
		sUser.setSex(Integer.valueOf(sex));
		sUser.setStatus(status);
		sUser.setRoleId(1);
		
		systemUserService.insert(sUser);
		
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");

		return data;
	}
	
	
	
}
