package rental_management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rental_management.system.bean.SystemUser;
import rental_management.system.mapper.SystemUserMapper;
import rental_management.system.service.SystemUserService;

@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	private SystemUserMapper systemUserMapper;

	@Override
	public List<SystemUser> list() {
		// System.out.println(systemUserMapper.list());
		return systemUserMapper.list();
	}

	@Override
	public SystemUser getSystemUser(String name) {
		
		return systemUserMapper.getSystemUser(name);
	}
	
	
	@Override
	public void insert(SystemUser systemUser) {
		systemUserMapper.insert(systemUser);
		
	}
}
