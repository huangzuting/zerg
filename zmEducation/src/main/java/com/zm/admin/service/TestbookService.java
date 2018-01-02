package com.zm.admin.service;

import java.util.List;
import java.util.Map;

import com.zm.admin.dao.Testbook;

import net.sf.json.JSONArray;



public interface TestbookService {
	
	public Map<String, String>  addorupdate(Testbook testbook);

	public void deleteById(int id);

	public Testbook selectById(int id);

	public List<Testbook> select();
	
	public JSONArray selectJson();

}
