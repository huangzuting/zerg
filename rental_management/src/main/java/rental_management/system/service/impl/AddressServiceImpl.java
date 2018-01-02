package rental_management.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import rental_management.system.bean.Address;
import rental_management.system.mapper.AddressMapper;
import rental_management.system.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	@Override
	public JSONObject getUpTree(int id) {
		Address address;
		JSONObject treename = new JSONObject();
		JSONObject treename2;
		int pid = id;
		while (pid != 0) {
			address = addressMapper.selectId(pid);
			treename2 = new JSONObject();
			treename2.element("id", address.getId());
			treename2.element("name", address.getLocation());
			treename2.element("children", treename);
			treename = treename2;
			pid = address.getPid();
		}
		return treename;
	}

	@Override
	public JSONArray getDownTree(int id) {

		Address address = addressMapper.selectId(id);
		List<Address> list = new ArrayList<>();
		list.add(0, address);
		return getDownTree(list);
	}

	public JSONArray getDownTree(List<Address> addresses) {
		JSONArray array = new JSONArray();
		JSONObject treename;

		for (Address address : addresses) {
			treename = new JSONObject();
			treename.element("id", address.getId());
			treename.element("name", address.getLocation());
			treename.element("text", address.getLocation());
			treename.element("pid", address.getPid());
			treename.element("children", getDownTree(addressMapper.selectPid(address.getId())));
			array.add(treename);
		}

		return array;

	}

	@Override//绑定地址唯一
	public JSONObject getUpTreeId(String name) {
		Address address=addressMapper.selectName(name);
		return getUpTree(address.getId());
	}

	@Override
	public JSONArray getDownTreeId(String name) {
		Address address=addressMapper.selectName(name);
		return getDownTree(address.getId());
	}

	@Override
	public void addorupdate(Address address) {
		if(address.getId()!=-1){
			addressMapper.update(address);
		}
		else{
			addressMapper.add(address);
		}
	
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		addressMapper.delete(id);
	}

	@Override
	public Address select(int id) {
		// TODO Auto-generated method stub
		return addressMapper.selectId(id);
	}

	@Override
	public Address selectPid(int pid) {
		// TODO Auto-generated method stub
		List<Address> address=addressMapper.selectPid(pid);
		return address.get(0);
	}

	@Override
	public Address selectName(String name) {
		// TODO Auto-generated method stub
		return addressMapper.selectName(name);
	}

	@Override
	public Address selects(String[] contents) {
		// TODO Auto-generated method stub
		System.out.println(addressMapper.selects(new String[]{"id","1"}));

		return addressMapper.selects(contents);
	}

	@Override
	public List<Address> selectLevel(int level) {
		// TODO Auto-generated method stub
		/*JSONArray array=new JSONArray();
		List<Address> address=addressMapper.selectLevel(level);
		for (Address address2 : address) {
			array.
			array.element("name",address2.getLocation());
			array.element("houseId",String.valueOf(address2.getId()));
		}*/
		return addressMapper.selectLevel(level);
	}
	
	
	
	

}
