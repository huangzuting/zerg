package com.zm.admin.service;

import java.util.List;
import java.util.Map;

import com.zm.admin.dao.Teacher;

import net.sf.json.JSONArray;

public interface TeacherService {
	
	public Map<String, String> addorupdate(Teacher teacher);
	
	public void deleteById(int id);
	
	public Teacher selectById(int id);
	
	public List<Teacher> select();

	public JSONArray selectJson();

}
