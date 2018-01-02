package com.zm.admin.service;

import java.util.List;
import java.util.Map;

import com.zm.admin.dao.Courses;

import net.sf.json.JSONArray;

public interface CoursesService {
	
	public  Map<String, String> addorupdate(Courses courses);

	public void deleteById(int id);

	public Courses selectById(int id);

	public List<Courses> select();
	
	public JSONArray selectJson();
	
	public Integer selectIdByName(String name);

}
