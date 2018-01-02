package rental_management.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import rental_management.system.bean.Card;
import rental_management.system.bean.Dev;
import rental_management.system.mapper.DevCardMapper;
import rental_management.system.service.CardService;
import rental_management.system.service.DevService;

@Controller
@RequestMapping("/relation")
public class RelationController {
	@Autowired
	private DevCardMapper devCardMapper;

	@Autowired
	private DevService devService;

	@Autowired
	private CardService cardService;
	
	@RequestMapping("/devcard-add")
	public void add(int devId, int cardId) {
		devCardMapper.insert(devId, cardId);
	}

	@RequestMapping("/dev-show")
	public void devshow(HttpServletResponse response) {
		List<Dev> list = devService.selectAll();
		JSONArray array = new JSONArray();
		JSONObject devIds;
		for (Dev dev : list) {
			devIds = new JSONObject();
			devIds.element("id", dev.getId());
			devIds.element("text", dev.getName());
			array.add(devIds);
		}
		try {
			response.getWriter().write(array.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/card-show")
	public void cardshow(HttpServletResponse response) {
		List<Card> list = cardService.list();
		JSONArray array = new JSONArray();
		JSONObject cardIds;
		for (Card card : list) {
			cardIds = new JSONObject();
			cardIds.element("id", card.getId());
			cardIds.element("text", card.getName());
			array.add(cardIds);
		}
		try {
			response.getWriter().write(array.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/bind")
	@ResponseBody
	public Map<String,String> bind(Integer devId,Integer cardId){
		Map<String,String> map=new HashMap<>();
		try{
			devCardMapper.insert(devId, cardId);
			map.put("status", "true");
			map.put("msg", "成功绑定");
		}catch(Exception e){
			map.put("status", "false");
		}
		return map;
	}
	
	@RequestMapping("/unbind")
	@ResponseBody
	public Map<String,String> unbind(Integer devId,Integer cardId){
		Map<String,String> map=new HashMap<>();
		if(devId!=null&&cardId!=null){
			devCardMapper.deletedevcard(devId, cardId);
		}else if(devId!=null){
			devCardMapper.deletedev(devId);
		}else if(cardId!=null){
			devCardMapper.deletecard(cardId);
		}else{
			map.put("status", "false");
			return map;

		}
		
		map.put("status", "true");
		map.put("msg", "成功解除绑定");
		return map;
	}
}
