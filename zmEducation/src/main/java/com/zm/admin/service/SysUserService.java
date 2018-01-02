package com.zm.admin.service;

import java.util.List;

import com.zm.admin.dao.SysUser;

public interface SysUserService {

	public void addorupdate(SysUser sysUser);

	public void deleteById(int id);

	public SysUser selectById(int id);

	public List<SysUser> select();

	public SysUser getSysUserName(String username);

}
