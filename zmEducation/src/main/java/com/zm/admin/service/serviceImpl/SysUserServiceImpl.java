package com.zm.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.admin.dao.SysUser;
import com.zm.admin.dao.SysUserExample;
import com.zm.admin.dao.SysUserExample.Criteria;
import com.zm.admin.mapper.SysUserMapper;
import com.zm.admin.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public void addorupdate(SysUser sysUser) {
			if (sysUser.getId() != null) {
				sysUserMapper.updateByPrimaryKey(sysUser);
			} else {
				sysUserMapper.insert(sysUser);
			}
		} 


	@Override
	public void deleteById(int id) {
		sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysUser selectById(int id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysUser> select() {
		SysUserExample example = new SysUserExample();
		return sysUserMapper.selectByExample(example);
	}

	@Override
	public SysUser getSysUserName(String username) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<SysUser>sysUsers = sysUserMapper.selectByExample(example);
		SysUser sysUser = sysUsers.get(0);
		return sysUser;
	}

}
