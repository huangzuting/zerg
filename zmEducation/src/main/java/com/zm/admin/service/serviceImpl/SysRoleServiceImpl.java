package com.zm.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.admin.dao.SysRole;
import com.zm.admin.dao.SysRoleExample;
import com.zm.admin.mapper.SysRoleMapper;
import com.zm.admin.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public void addorupdate(SysRole sysRole) {
		if(sysRole.getId()!=null) {
			sysRoleMapper.updateByPrimaryKey(sysRole);
		}else {
			sysRoleMapper.insert(sysRole);
		}		
	}

	@Override
	public void deleteById(int id) {
		sysRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysRole selectById(int id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysRole> select() {
		SysRoleExample example = new SysRoleExample();
		return sysRoleMapper.selectByExample(example);
	}

}
