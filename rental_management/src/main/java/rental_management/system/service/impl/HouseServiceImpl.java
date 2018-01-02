package rental_management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import rental_management.system.bean.House;
import rental_management.system.mapper.HouseMapper;
import rental_management.system.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private HouseMapper houseMapper;

	@Override
	public void insert(int houseId,String address) {
		House house=new House();
		house.setHouseId(houseId);
		house.setAddress(address);
		houseMapper.insert(house);

	}

	@Override
	public void delete(int houseId) {
       houseMapper.delete(houseId);

	}

	@Override
	public House selectHouseId(int id) {
		// TODO Auto-generated method stub
		return houseMapper.selectHouseId(id);
	}

	@Override
	public JSONArray selectAllAddress() {
        List<House> list= houseMapper.selectAll();
		JSONArray array=new JSONArray();
		JSONObject object;
		for (House house : list) {
			object=new JSONObject();
			object.element("id", house.getHouseId());
			object.element("houseId", house.getHouseId());
			object.element("address", house.getAddress());
		    object.element("text", house.getAddress());
			array.add(object);
		}
		return array;
	}


}
