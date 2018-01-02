package rental_management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import rental_management.system.bean.SystemMenu;
import rental_management.system.mapper.SystemMenuMapper;
import rental_management.system.service.SystemMenuService;

@Service
public class SystemMenuServiceImpl implements SystemMenuService {

	@Autowired
	private SystemMenuMapper systemMenuMapper;

	@Override
	public JSONArray tree(int parentId) {
		List<SystemMenu> list = systemMenuMapper.getByPId(parentId);
		System.out.println(list+"--");
		return tree(list);
	}
	
	public JSONArray tree(List<SystemMenu> list){
		JSONArray array = new JSONArray();
		JSONObject json;
		for (SystemMenu sysmenu:list) {
			json = new JSONObject();
			json.element("id", sysmenu.getId());
			json.element("name", sysmenu.getName());
			json.element("text", sysmenu.getName());
			json.element("defineRight", sysmenu.getDefineRight());
			json.element("pid", sysmenu.getPid());
			json.element("pageUrl", sysmenu.getPageUrl());
			json.element("children", tree(systemMenuMapper.getByPId(sysmenu.getId())));
			
			array.add(json);
//			System.out.println(json);
		}
		
		
		return array;
		
	}
	
	public void saveOrUpdate(SystemMenu systemMenu){
		if(systemMenu.getId()!=-1){
			systemMenuMapper.update(systemMenu);
		}else{
			systemMenuMapper.save(systemMenu);
		}
	}

	@Override
	public void delete(int id) {
		systemMenuMapper.delete(id);
	}

	@Override
	public SystemMenu selectId(int id) {
		// TODO Auto-generated method stub
		return systemMenuMapper.selectId(id);
	}

	@Override
	public JSONObject getUpTree(int id) {
		
		SystemMenu sysmenu;
		JSONArray array = new JSONArray();

		JSONObject treename=null;
		int pid = id;
		while (pid != 0) {
			sysmenu = systemMenuMapper.selectId(pid);
			treename = new JSONObject();
			
			treename.element("id", sysmenu.getId());
			treename.element("name", sysmenu.getName());
			treename.element("text", sysmenu.getName());
			treename.element("defineRight", sysmenu.getDefineRight());
			treename.element("pid", sysmenu.getPid());
			treename.element("pageUrl", sysmenu.getPageUrl());
			treename.element("children", array);
			array.clear();
			pid = sysmenu.getPid();
			if(pid!=0)array.add(treename);
		
		}
		return treename;
		
	}

	


}
