package com.zm.admin.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.admin.dao.Teacher;
import com.zm.admin.dao.TeacherExample;
import com.zm.admin.mapper.MechanismMapper;
import com.zm.admin.mapper.TeacherMapper;
import com.zm.admin.service.TeacherService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private MechanismMapper mechanismMapper;

	@Override
	public Map<String, String> addorupdate(Teacher teacher) {
		if (teacher.getId() != null) {
			teacherMapper.updateByPrimaryKey(teacher);
		} else {
			teacherMapper.insert(teacher);
		}

		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "Ìí¼Ó³É¹¦");
		return data;
	}

	@Override
	public void deleteById(int id) {
		teacherMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Teacher selectById(int id) {
		return teacherMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Teacher> select() {
		TeacherExample example = new TeacherExample();
		return teacherMapper.selectByExample(example);
	}

	@Override
	public JSONArray selectJson() {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		List<Teacher> teachers = select();
		for (Teacher teacher : teachers) {
			json.element("Id", "" + teacher.getId());
			json.element("name", "" + teacher.getName());
			json.element("info", teacher.getInfo());
			json.element("mechanism", mechanismMapper.selectByPrimaryKey(teacher.getMechanismId()).getName());
			array.add(json);
		}
		return array;
	}

}
