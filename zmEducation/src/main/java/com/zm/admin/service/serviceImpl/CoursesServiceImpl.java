package com.zm.admin.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.admin.dao.Courses;
import com.zm.admin.dao.CoursesExample;
import com.zm.admin.dao.Testbook;
import com.zm.admin.dao.TestbookExample;
import com.zm.admin.mapper.CoursesMapper;
import com.zm.admin.mapper.MechanismMapper;
import com.zm.admin.mapper.TestbookMapper;
import com.zm.admin.service.CoursesService;
import com.zm.publics.util.DateUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	private CoursesMapper coursesMapper;
	
	@Autowired
	private MechanismMapper mechanismMapper;
	
	@Autowired
	private TestbookMapper testbookMapper;

	@Override
	public Map<String, String> addorupdate(Courses courses) {
		Map<String, String> data = new HashMap<>();
		if (courses.getId() != null) {
			coursesMapper.updateByPrimaryKey(courses);
			data.put("status", "true");
			data.put("msg", "添加成功");
		} else {
			coursesMapper.insert(courses);
			data.put("status", "true");
			data.put("msg", "修改成功");
		}
		return data;
	}

	@Override
	public void deleteById(int id) {
		coursesMapper.deleteByPrimaryKey(id);

	}

	@Override
	public Courses selectById(int id) {
		return coursesMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Courses> select() {
		CoursesExample example = new CoursesExample();
		return coursesMapper.selectByExample(example);
	}
	
	public JSONArray getTestbook(int coursesId) {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		TestbookExample example = new TestbookExample();
		example.createCriteria().andCoursesIdEqualTo(coursesId);
		List<Testbook> testbooks = testbookMapper.selectByExample(example);
		for (Testbook testbook : testbooks) {
			json.element("Id", "" + testbook.getId());
			json.element("name", "" + testbook.getName());
			json.element("info", testbook.getInfo());
			array.add(json);
		}
		return array;
	}

	@Override
	public JSONArray selectJson() {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		List<Courses> courses = select();
		for (Courses course : courses) {
			json.element("Id", "" + course.getId());
			json.element("name", "" + course.getName());
			json.element("info", course.getInfo());
			json.element("duration", DateUtils.DateToDate(course.getDuration()));
			json.element("price", course.getPrice());
			json.element("type", course.getType());
			json.element("classType", course.getClassType());
			json.element("mechanism", mechanismMapper.selectByPrimaryKey(course.getMechanismId()).getName());
			json.element("children", getTestbook(course.getId()));
			array.add(json);
		}
		return array;
	}

	@Override
	public Integer selectIdByName(String name) {
		CoursesExample example = new CoursesExample();
		example.createCriteria().andNameEqualTo(name);
		return coursesMapper.selectByExample(example).get(0).getId();
	}
	
	

}
