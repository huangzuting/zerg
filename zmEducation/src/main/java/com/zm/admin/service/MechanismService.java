package com.zm.admin.service;

import java.util.List;
import java.util.Map;

import com.zm.admin.dao.Mechanism;

import net.sf.json.JSONArray;


public interface MechanismService {
	
	public Map<String, String>  addorupdate(Mechanism mechanism);

	public void deleteById(int id);

	public Mechanism selectById(int id);

	public List<Mechanism> select();
	
	public JSONArray selectJson();
	
	public Integer selectIdByName(String name);

}
