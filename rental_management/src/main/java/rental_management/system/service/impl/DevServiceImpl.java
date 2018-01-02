package rental_management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import rental_management.system.bean.Dev;
import rental_management.system.mapper.DevMapper;
import rental_management.system.service.DevService;

@Service
public class DevServiceImpl implements DevService {

	@Autowired
	private DevMapper devMapper;

	@Override
	public Dev selecthouse(int houseId) {
		// TODO Auto-generated method stub
		return devMapper.selecthouse(houseId);
	}

	@Override
	public Dev selectid(int id) {
		// TODO Auto-generated method stub
		return devMapper.selectid(id);
	}

	@Override
	public void addorupdate(Dev dev) {
		// TODO Auto-generated method stub
		if(dev.getId()!=-1){
			devMapper.update(dev);
		}else{
			devMapper.insert(dev);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		devMapper.delete(id);
	}
	
	@Override
	public List<Dev> selectAll() {
		// TODO Auto-generated method stub
		return devMapper.selectAll();
	}


}
