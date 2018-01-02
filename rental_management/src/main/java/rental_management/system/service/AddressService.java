package rental_management.system.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import rental_management.system.bean.Address;

public interface AddressService {

	public JSONObject getUpTree(int id);
	public JSONArray getDownTree(int pid);
	public JSONObject getUpTreeId(String name);
	public JSONArray getDownTreeId(String name);
	public void addorupdate(Address address);
	public Address selectPid(int pid);
	public void delete(int id);
	public Address select(int id);
	public Address selectName(String name);
	public Address selects(String[] contents);
	public List<Address> selectLevel(int level);
}
