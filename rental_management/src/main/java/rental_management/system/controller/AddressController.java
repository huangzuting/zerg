package rental_management.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import rental_management.system.bean.Address;
import rental_management.system.service.AddressService;
import rental_management.system.service.HouseService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@Autowired
	private HouseService houseService;

	@RequestMapping("/address-manage")
	public String show(){
		return "/jsp/system/sys-address.jsp";
	}
	
	@RequestMapping("/tree")
	public void tree(HttpServletResponse response) {
		JSONArray array = addressService.getDownTree(1);
		try {
			response.getWriter().write(array.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/tree-input")
	public String input(String windowid, @RequestParam(value = "id", defaultValue = "-1") Integer id,
			@RequestParam(defaultValue = "false") String house, Model model) {
		model.addAttribute("id", id);
		if (id != -1) {
			if (house.equals("true")) {
				return "/jsp/system/sys-house-input.jsp";
			} else {
				Address address=addressService.select(id);
				model.addAttribute("pid", address.getPid());
				model.addAttribute("name", address.getLocation());
			}
		}

		return "/jsp/system/sys-address-input.jsp";
	}

	@RequestMapping("/tree-addorupdate")
	@ResponseBody
	public Map<String, String> addorupdate(Integer id, String name, Integer pid) {

		Address address = new Address();
		address.setLevelJudge(addressService.select(pid).getLevelJudge() + 1);
		address.setLocation(name);
		address.setPid(pid);
		address.setId(id);

		addressService.addorupdate(address);
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");

		return data;
	}

	@RequestMapping("/tree-delete")
	@ResponseBody
	public Map<String, String> delete(Integer id) {
		
		try {
			addressService.selectPid(id);
		} catch (Exception e) {
			try{
				houseService.delete(id);
			}catch(Exception ex){}
		}
		addressService.delete(id);
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "删除成功");
		
		return data;
		
	}

	@RequestMapping("/addhouse")
	@ResponseBody
	public Map<String, String> addhouse(@RequestParam(value = "id", defaultValue = "-1") Integer id, String name) {
		Map<String, String> data = new HashMap<>();
		Address addr = addressService.select(id);

		if (addr.getLevelJudge() < 4) {
			data.put("status", "false");
		} else {
			addorupdate(-1, name, id);
			Address newAddr = addressService.selectName(name);
			JSONObject uptree = addressService.getUpTree(id);
			String address = "";
			address += uptree.getString("name");
			JSONObject object = (JSONObject) uptree.get("children");
			while (object.get("children") != null) {
				address += object.getString("name");
				object = (JSONObject) object.get("children");
			}
			address += name;
			houseService.insert(newAddr.getId(), address);

			data.put("status", "true");
			data.put("msg", "操作成功");
		}
		return data;
	}
	/*
	@RequestMapping("/level")
	public JSONObject getlevel(int id){
		Address address=addressService.select(id);
		JSONObject object=new JSONObject();
		if(address.getLevelJudge()<4){
			object.put("status", false);
		}else{
			object.put("status",true);
		}

		return object;
	}*/
	
	
	@RequestMapping("/houseaddress")
	public void leveladdress(HttpServletResponse response){
		JSONArray array = houseService.selectAllAddress();
		try {
			response.getWriter().write(array.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
