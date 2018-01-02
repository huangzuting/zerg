package rental_management.publics.util;

import java.util.Enumeration;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import rental_management.system.bean.SystemUser;


public class SessionUserUtil {

	public static final String SESSION_SYSUSER_KEY = "SESSION_SYSUSER_KEY";

	public static SystemUser getOnlineUser(HttpServletRequest request) {
		SystemUser systemUser=(SystemUser) request.getSession().getAttribute(SESSION_SYSUSER_KEY);
		
		return systemUser;
	}

	/**
	 * 保存用户信息到sesson
	 * 
	 * @param sysUser
	 */
	public static void setOnlineUser(SystemUser systemUser,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_SYSUSER_KEY, systemUser);
	}

	public static void removeOnlineUser(HttpServletRequest request) {
		request.getSession().removeAttribute(SESSION_SYSUSER_KEY);
	}
}
