package rental_management.system.service;

import java.util.List;

import rental_management.system.bean.SystemRole;

public interface SystemRoleService {

	public List<SystemRole> list();
	
	public void saveOrUpdate(SystemRole systemRole);

	public void delete(SystemRole systemRole);

	public void delete(int id);
	
	public void updateRoleMenu(int systemRoleId,String... menuIds);
	
	public SystemRole get(int id);
	
	public String getName(int id);
	
	public String getFlag(int id);
	
}
