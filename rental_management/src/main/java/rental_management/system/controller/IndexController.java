package rental_management.system.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rental_management.publics.util.SessionUserUtil;
import rental_management.system.bean.SystemUser;
import rental_management.system.service.SystemUserService;

@Controller
@RequestMapping("/login")
public class IndexController {
	@Autowired
	private SystemUserService systemUserService;

	
//	http://127.0.0.1:8080/rental_management/login/frist.do
	@RequestMapping("/frist")
	public String index() {
		return "/login.jsp";
	}

//	http://127.0.0.1:8080/rental_management/login/index.do
	@RequestMapping("/index")
	public String nn() {
		return "/index.jsp";
	}

	
	@RequestMapping(path = "/login",produces="application/json; charset=UTF-8")
	@ResponseBody
	public String login(String username,String password, HttpServletResponse response,HttpServletRequest request) {

		SystemUser systemUser1 = systemUserService.getSystemUser(username);
		JSONObject json = new JSONObject();
		try{

			if (!password.equals(systemUser1.getPassword())) {
				json.element("status", false);
				json.element("msg", "密码错误...");
			}
			 else {
				json.element("status", true);
					// json.element("msg", "index.action?id="+userid);
					SessionUserUtil.setOnlineUser(systemUser1, request);
					json.element("msg", "index.do");
				}
		}catch(Exception e){
			json.element("status", false);
			json.element("msg", "用户名不存在...");
	
		}
		
		try {
			response.getWriter().write(json.toString());
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
}
