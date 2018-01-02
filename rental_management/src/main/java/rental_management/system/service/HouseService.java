package rental_management.system.service;

import net.sf.json.JSONArray;
import rental_management.system.bean.House;

public interface HouseService {
	public void insert(int houseId,String address);
	public void delete(int houseId);
	public House selectHouseId(int id);
	public JSONArray selectAllAddress();
}
