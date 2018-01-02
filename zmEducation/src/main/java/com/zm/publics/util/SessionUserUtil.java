package com.zm.publics.util;

import java.util.Enumeration;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zm.admin.dao.SysUser;




public class SessionUserUtil {

	public static final String SESSION_SYSUSER_KEY = "SESSION_SYSUSER_KEY";

	public static SysUser getOnlineUser(HttpServletRequest request) {
		SysUser sysUser=(SysUser) request.getSession().getAttribute(SESSION_SYSUSER_KEY);
		
		return sysUser;
	}

	/**
	 * 保存用户信息到sesson
	 * 
	 * @param sysUser
	 */
	public static void setOnlineUser(SysUser sysUser,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_SYSUSER_KEY, sysUser);
	}

	public static void removeOnlineUser(HttpServletRequest request) {
		request.getSession().removeAttribute(SESSION_SYSUSER_KEY);
	}
}
