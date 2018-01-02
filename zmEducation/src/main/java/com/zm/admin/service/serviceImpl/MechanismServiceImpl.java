package com.zm.admin.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.admin.dao.Courses;
import com.zm.admin.dao.CoursesExample;
import com.zm.admin.dao.Mechanism;
import com.zm.admin.dao.MechanismExample;
import com.zm.admin.dao.Teacher;
import com.zm.admin.dao.TeacherExample;
import com.zm.admin.mapper.CoursesMapper;
import com.zm.admin.mapper.MechanismMapper;
import com.zm.admin.mapper.TeacherMapper;
import com.zm.admin.service.MechanismService;
import com.zm.publics.util.DateUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class MechanismServiceImpl implements MechanismService {
	
	@Autowired
	private MechanismMapper mechanismMapper;
	
	@Autowired
	private CoursesMapper coursesmapper;
	
	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public Map<String, String>  addorupdate(Mechanism mechanism) {
		if(mechanism.getId()!=null) {
			mechanismMapper.updateByPrimaryKey(mechanism);
		}else {
			mechanismMapper.insert(mechanism);
		}
		
		Map<String, String> data = new HashMap<>();
		JSONObject json = new JSONObject();
		json.element("status", "true");
		json.element("msg", "添加成功");
		data.put("status", "true");
		data.put("msg", "添加成功");
		return data;
		
	}

	@Override
	public void deleteById(int id) {
		mechanismMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Mechanism selectById(int id) {
		return mechanismMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Mechanism> select() {
		MechanismExample example = new MechanismExample();
		return mechanismMapper.selectByExample(example);
	}
	
	private JSONArray getCourses(int mechanismId){	
		CoursesExample example = new CoursesExample();
		example.createCriteria().andMechanismIdEqualTo(mechanismId);
		List<Courses> list = coursesmapper.selectByExample(example);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Courses courses : list) {
			json.element("Id", "" + courses.getId());
			json.element("name", "" + courses.getName());
			json.element("info", courses.getInfo());
			json.element("duration", DateUtils.DateToDate(courses.getDuration()));
			json.element("price", courses.getPrice());
			json.element("type", courses.getType());
			json.element("classType", courses.getClassType());
			array.add(json);
		}
		return array;
	}
	
	private JSONArray getTeacher(int mechanismId) {
		TeacherExample example = new TeacherExample();
		example.createCriteria().andMechanismIdEqualTo(mechanismId);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		List<Teacher> teachers = teacherMapper.selectByExample(example);
		for (Teacher teacher : teachers) {
			json.element("Id", "" + teacher.getId());
			json.element("name", "" + teacher.getName());
			json.element("info", teacher.getInfo());
			json.element("mechanism", mechanismMapper.selectByPrimaryKey(teacher.getMechanismId()).getName());
			array.add(json);
		}
		return array;
		
	}

	@Override
	public JSONArray selectJson() {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		List<Mechanism> mechanisms = select();
		
		for (Mechanism mechanism : mechanisms) {
			json.element("Id", ""+mechanism.getId());
			json.element("name", ""+mechanism.getName());
			json.element("info", mechanism.getInfo());
			json.element("address",mechanism.getAddress());
			json.element("logo", mechanism.getLogo());
			json.element("testService", mechanism.getTestService());
			json.element("contact", mechanism.getContact());
			json.element("phone", mechanism.getPhone());
			json.element("business", mechanism.getBusinessLicense());
			json.element("schoolPermit", mechanism.getSchoolPermit());
			json.element("courses", getCourses(mechanism.getId()));
			json.element("teacher", getTeacher(mechanism.getId()));
			array.add(json);
		}
		return array;
	}

	@Override
	public Integer selectIdByName(String name) {
		MechanismExample example = new MechanismExample();
		example.createCriteria().andNameEqualTo(name);
		List<Mechanism> list = mechanismMapper.selectByExample(example);
		if(list.size()!=0) {
			return list.get(0).getId();
		}else
		return null;
	}

}
