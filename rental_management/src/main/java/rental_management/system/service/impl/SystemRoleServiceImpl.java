package rental_management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rental_management.system.bean.SystemRole;
import rental_management.system.mapper.SystemRoleMapper;
import rental_management.system.service.SystemRoleService;

@Service
public class SystemRoleServiceImpl implements SystemRoleService {
	@Autowired
	private SystemRoleMapper systemRoleMapper;
	
	@Override
	public List<SystemRole> list() {

		return systemRoleMapper.list();
	}

	@Override
	public void saveOrUpdate(SystemRole systemRole) {
		
		if(systemRole.getId()!=0){
			systemRoleMapper.update(systemRole);
		}else{
			systemRoleMapper.save(systemRole);
		}
	}

	@Override
	public void delete(SystemRole systemRole) {
		
	}

	@Override
	public void delete(int id) {
		systemRoleMapper.delete(id);
	}

	@Override
	public void updateRoleMenu(int systemRoleId, String... menuIds) {
		
	}
	
	@Override
	public SystemRole get(int id) {
		// TODO Auto-generated method stub
		return systemRoleMapper.selectId(id);
	}
	
	@Override
	public String getName(int id) {
		// TODO Auto-generated method stub
		return systemRoleMapper.selectId(id).getRoleName();
	}

	@Override
	public String getFlag(int id) {
		// TODO Auto-generated method stub
		return systemRoleMapper.selectId(id).getFlag();
	}

	





	
}
