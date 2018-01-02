package com.zm.admin.service;

import java.util.List;

import com.zm.admin.dao.SysRole;

public interface SysRoleService {

	public void addorupdate(SysRole sysRole);

	public void deleteById(int id);

	public SysRole selectById(int id);

	public List<SysRole> select();
}
