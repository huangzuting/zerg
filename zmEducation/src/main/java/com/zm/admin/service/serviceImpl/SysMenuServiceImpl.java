package com.zm.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zm.admin.dao.SysMenu;
import com.zm.admin.dao.SysMenuExample;
import com.zm.admin.mapper.SysMenuMapper;
import com.zm.admin.service.SysMenuService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public void addorupdate(SysMenu sysMenu) {
		if (sysMenu.getId() != null) {
			sysMenuMapper.updateByPrimaryKey(sysMenu);
		} else {
			sysMenuMapper.insert(sysMenu);
		}

	}

	@Override
	public void deleteById(int id) {
		sysMenuMapper.deleteByPrimaryKey(id);

	}

	@Override
	public SysMenu selectById(int id) {
		return sysMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysMenu> select() {
		SysMenuExample example = new SysMenuExample();
		return sysMenuMapper.selectByExample(example);
	}

	public JSONArray tree(List<SysMenu> list) {
		JSONArray array = new JSONArray();
		JSONObject json;
		for (SysMenu sysmenu : list) {
			json = new JSONObject();
			json.element("id", sysmenu.getId());
			json.element("name", sysmenu.getName());
			json.element("text", sysmenu.getName());
			json.element("pid", sysmenu.getpId());
			json.element("pageUrl", sysmenu.getPageUrl());
			json.element("children", tree(sysMenuMapper.getByPId(sysmenu.getId())));
			array.add(json);
		}
		return array;
	}

	@Override
	public JSONArray tree(int parentId) {
		List<SysMenu> list = sysMenuMapper.getByPId(parentId);
		System.out.println(list + "--");
		return tree(list);
	}

	@Override
	public JSONObject getUpTree(Integer id) {

		SysMenu sysmenu;
		JSONArray array = new JSONArray();

		JSONObject treename = null;

		int pid = id;
		while (pid != 0) {
			sysmenu = sysMenuMapper.selectByPrimaryKey(pid);
			treename = new JSONObject();
			treename.element("id", sysmenu.getId());
			treename.element("name", sysmenu.getName());
			treename.element("text", sysmenu.getName());
			treename.element("pid", sysmenu.getpId());
			treename.element("pageUrl", sysmenu.getPageUrl());
			treename.element("children", array);
			array.clear();
			pid = sysmenu.getpId();
			if (pid != 0)
				array.add(treename);

		}

		return treename;

	}

}
