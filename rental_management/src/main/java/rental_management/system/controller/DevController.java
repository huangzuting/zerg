package rental_management.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import rental_management.system.bean.Dev;
import rental_management.system.service.AddressService;
import rental_management.system.service.DevService;
import rental_management.system.service.HouseService;

@Controller
@RequestMapping("/dev")
public class DevController {

	@Autowired
	private DevService devService;
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/dev-manage")
	public String show(){
		return "/jsp/system/sys-dev.jsp";
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<Dev> list(){
		return devService.selectAll();
	}
	@RequestMapping("/dev-input")
	public String devadd(@RequestParam(value = "id", defaultValue = "-1") Integer id,Model model){	
		model.addAttribute("id", id);
		if (id != -1) {
			Dev dev=devService.selectid(id);
			model.addAttribute("name", dev.getName());
			model.addAttribute("cdp", dev.getCdp());
			model.addAttribute("houseId",dev.getHouseId());
		}

		return "/jsp/system/sys-dev-input.jsp";
	}
	
	@RequestMapping("/dev-addorupdate")
	@ResponseBody
	public Map<String, String> addorupdate(Integer id,String name,String cdp,int houseId){
		Dev dev=new Dev();
		dev.setId(id);
		dev.setCdp(cdp);
		dev.setName(name);
		dev.setHouseId(houseId);
		dev.setHouseAddress(houseService.selectHouseId(houseId).getAddress());
		devService.addorupdate(dev);
		Map<String,String> data=new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");
		return data;
	}
	
	@RequestMapping("/dev-delete")
	@ResponseBody
	public Map<String, String> delete(int id){
		Map<String, String> data = new HashMap<>();
		devService.delete(id);
		data.put("status", "true");
		data.put("msg", "删除成功");
		
		return data;
	}
	
}
