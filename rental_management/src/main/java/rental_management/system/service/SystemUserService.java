package rental_management.system.service;

import java.util.List;

import rental_management.system.bean.SystemUser;

public interface SystemUserService {
	public List<SystemUser> list();

	public SystemUser getSystemUser(String name);
	
	public void insert(SystemUser systemUser);
}
