package com.zm.admin.service;

import java.util.List;

import com.zm.admin.dao.SysMenu;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface SysMenuService {
	public void addorupdate(SysMenu sysMenu);

	public void deleteById(int id);

	public SysMenu selectById(int id);

	public List<SysMenu> select();

	JSONArray tree(int parentId);

	JSONObject getUpTree(Integer id);

}
