package rental_management.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import rental_management.system.bean.SystemUser;

@Repository
public interface SystemUserMapper {
	public List<SystemUser> list();
	
	public SystemUser getSystemUser(String name);
	
	public void insert(SystemUser systemUser);
	
}
