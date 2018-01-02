package com.zm.admin.service;

import java.util.List;

import com.zm.admin.dao.Enviro;

public interface EnviroService {

	public void addorupdate(Enviro enviro);

	public void deleteById(int id);

	public Enviro selectById(int id);

	public List<Enviro> select();

}
