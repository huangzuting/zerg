package rental_management.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import rental_management.system.bean.SystemRole;

@Repository
public interface SystemRoleMapper {

	public List<SystemRole> list();
	
	public void save(SystemRole systemRole);

	public void update(SystemRole systemRole);

	public void delete(int id);

	public SystemRole selectId(int id);
	
	public SystemRole selectName(String name);
	
	public List<SystemRole> selectRoleId(int roleId);
}
