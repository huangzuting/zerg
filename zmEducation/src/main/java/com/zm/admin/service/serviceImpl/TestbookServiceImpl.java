package com.zm.admin.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.admin.dao.Courses;
import com.zm.admin.dao.Testbook;
import com.zm.admin.dao.TestbookExample;
import com.zm.admin.mapper.CoursesMapper;
import com.zm.admin.mapper.TestbookMapper;
import com.zm.admin.service.TestbookService;
import com.zm.publics.util.DateUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class TestbookServiceImpl implements TestbookService {
	
	@Autowired
	private TestbookMapper testbookMapper;
	
	@Autowired
	private CoursesMapper coursesMapper;

	@Override
	public Map<String, String>  addorupdate(Testbook testbook) {
		Map<String, String> data = new HashMap<>();
		if(testbook.getId()!=null) {
			testbookMapper.updateByPrimaryKey(testbook);
			data.put("status", "true");
			data.put("msg", "添加成功");
		}else {
			testbookMapper.insert(testbook);
			data.put("status", "true");
			data.put("msg", "修改成功");
		}
		return data; 
		
	}

	@Override
	public void deleteById(int id) {
		testbookMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Testbook selectById(int id) {
		return testbookMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Testbook> select() {
		TestbookExample example = new TestbookExample();
		return testbookMapper.selectByExample(example);
	}

	@Override
	public JSONArray selectJson() {
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		List<Testbook> testbooks = select();
		for (Testbook testbook : testbooks) {
			json.element("Id", "" + testbook.getId());
			json.element("name", "" + testbook.getName());
			json.element("info", testbook.getInfo());
			json.element("courses", coursesMapper.selectByPrimaryKey(testbook.getCoursesId()).getName());
			array.add(json);
		}
		return array;
	}

}
