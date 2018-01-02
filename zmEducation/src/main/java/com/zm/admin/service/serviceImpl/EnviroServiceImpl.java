package com.zm.admin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.admin.dao.Enviro;
import com.zm.admin.dao.EnviroExample;
import com.zm.admin.mapper.EnviroMapper;
import com.zm.admin.service.EnviroService;

@Service
public class EnviroServiceImpl implements EnviroService {

	@Autowired
	private EnviroMapper enviroMapper;

	@Override
	public void addorupdate(Enviro enviro) {
		if (enviro.getId() != null) {
			enviroMapper.updateByPrimaryKey(enviro);
		} else {
			enviroMapper.insert(enviro);
		}

	}

	@Override
	public void deleteById(int id) {
		enviroMapper.deleteByPrimaryKey(id);

	}

	@Override
	public Enviro selectById(int id) {

		return enviroMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Enviro> select() {
		EnviroExample example = new EnviroExample();

		return enviroMapper.selectByExample(example);
	}
	
	

}
