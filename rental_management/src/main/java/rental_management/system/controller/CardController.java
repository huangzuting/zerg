package rental_management.system.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.type.MappedTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rental_management.publics.util.DateUtils;
import rental_management.publics.util.JsonDateValueProcessor;
import rental_management.system.bean.Card;
import rental_management.system.bean.Dev;
import rental_management.system.bean.Person;
import rental_management.system.mapper.DevCardMapper;
import rental_management.system.mapper.DevMapper;
import rental_management.system.service.CardService;
import rental_management.system.service.PersonService;
import rental_management.system.service.SystemUserService;

@Controller
@RequestMapping("/card")
public class CardController {

	@Autowired
	private CardService cardService;
	@Autowired
	private PersonService personService;
	@Autowired
	private DevMapper devMapper;
	@Autowired
	private DevCardMapper devCardMapper;

	@RequestMapping("/list")
	public String cardlist(HttpServletResponse response) {

		List<Card> cards = cardService.list();
		// List<Person> persons =personService.list();
		JSONArray jsonArray = new JSONArray();

		for (Card card : cards) {
			JSONObject json = new JSONObject();
			Person person = personService.getPerson(card.getPersonId());
			json.element("id", card.getId());
			json.element("name", card.getName());
			json.element("personcardno", card.getCardNo());
			json.element("phone", person.getPhone());
			json.element("sex", person.getSex());
			json.element("identitynumber", person.getIdentityNumber());
			json.element("status", card.getStatus());
			json.element("cdt", DateUtils.DateToDate(card.getCdt()));
			json.element("effectTime", DateUtils.DateToDate(card.getEffectTime()));

			jsonArray.add(json);
		}

		String text = JSONArray.fromObject(jsonArray).toString();
		System.out.println(text);

		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// http://127.0.0.1:8080/rental_management/card/6.do
	@RequestMapping("/6")
	public String list() {
		return "/jsp/system/person.jsp";
	}

	// http://127.0.0.1:8080/rental_management/card/card-input.do
	@RequestMapping("/card-input")
	public String cardInput(String windowid, Model model) {
		model.addAttribute("windowid", windowid);
		return "/jsp/system/person-input.jsp";
	}

	// 新增人员及卡信息获取列表
	// http://127.0.0.1:8080/rental_management/card/card-insert.do
	@RequestMapping("/card-insert")
	public String cardInsert(String windowid, Model model, String id) {
		// model.addAttribute("windowid", windowid);
		Person p2 = personService.getPerson(Integer.valueOf(id));
		Card c2 = cardService.selectId(Integer.valueOf(id));

		model.addAttribute("phone", p2.getPhone());
		model.addAttribute("name", c2.getName());
		model.addAttribute("birthDate", DateUtils.DateToDate(p2.getBrithDate()));
		model.addAttribute("sn", p2.getIdentityNumber());
		model.addAttribute("address", p2.getAddress());
		model.addAttribute("cardNo", c2.getCardNo());
		model.addAttribute("effectTime", DateUtils.DateToDate(c2.getEffectTime()));
		model.addAttribute("personId", id);

		return "/jsp/system/person-update.jsp";
	}

	// 修改人员及卡信息，存在bug，待完善
	// http://127.0.0.1:8080/rental_management/card/card-insert-submit.do
	@RequestMapping("/card-insert-submit")
	@ResponseBody
	public Map<String, String> cardInsertSubmit(String name, String sex, String birthDate, String sn, String address,
			String phone, String cardNo, String effectTime, String personId) {
		// id为CARDid
		Person person = new Person();
		Card card = new Card();

		Card card2 = cardService.selectId(Integer.valueOf(personId));
		int pid = card2.getPersonId();

		person.setName(name);
		person.setSex(Integer.valueOf(sex));
		person.setBrithDate(DateUtils.stringToDate(birthDate, "yyyy-MM-dd"));
		person.setIdentityNumber(cardNo);
		person.setAddress(address);
		person.setPhone(phone);
		person.setId(pid);

		// System.out.println(person.toString());

		Person p1 = personService.seleteName(name);

		card.setCardNo(cardNo);
		card.setEffectTime(DateUtils.stringToDate(effectTime, "yyyy-MM-dd"));
		// 创建的卡ID需要在完person角色建立后获取的personid进行添加，待修改
		card.setId(Integer.valueOf(personId));
		// 创建的userid需要在session中获取，待修改
		card.setUserId(1);
		// 默认状态为1，及时已注册
		card.setStatus(1);
		card.setName(name);
		// System.out.println(card.toString());

		cardService.update(card);
		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");

		return data;

	}

	// 人员新增功能
	// http://127.0.0.1:8080/rental_management/card/card-person-input.do
	@RequestMapping("/card-person-input")
	@ResponseBody
	public Map<String, String> cardInput2(String name, String sex, String birthDate, String sn, String address,
			String phone, String cardNo, String effectTime, String devid) {
		Person person = new Person();
		Card card = new Card();
		Dev dev = new Dev();

		person.setName(name);
		person.setSex(Integer.valueOf(sex));
		person.setBrithDate(DateUtils.stringToDate(birthDate, "yyyy-MM-dd"));
		person.setIdentityNumber(cardNo);
		// 系统传回来的address是gd_dev_let的ID
		dev = devMapper.selectid(Integer.valueOf(address));
		String devName = dev.getHouseAddress() + dev.getName();
		person.setAddress(devName);
		person.setPhone(phone);
		// System.out.println(person.toString());

		try {
			personService.seleteName(name).getName();

		} catch (Exception e) {
			personService.insert(person);
		}

		Person p1 = personService.seleteName(name);

		card.setCardNo(cardNo);
		card.setEffectTime(DateUtils.stringToDate(effectTime, "yyyy-MM-dd"));
		// 创建的卡ID需要在完person角色建立后获取的personid进行添加，待修改
		card.setPersonId(p1.getId());
		// 创建的userid需要在session中获取，待修改
		card.setUserId(1);
		// 默认状态为1，及时已注册
		card.setStatus(1);
		card.setName(name);
		card.setCdt(new Date());
		// System.out.println(card.toString());

		try {
			cardService.selectName(name).getId();

		} catch (Exception e) {
			cardService.insert(card);
		}

		int indevid = Integer.valueOf(devid);
		int incardid = cardService.selectName(name).getId();

		System.out.println("获取到的卡设备id是：" + incardid + "-----" + indevid);
		devCardMapper.insert(indevid, incardid);

		Map<String, String> data = new HashMap<>();
		data.put("status", "true");
		data.put("msg", "操作成功");

		return data;
	}

	// 返回设备列表
	// http://127.0.0.1:8080/rental_management/card/devlist.do

	@RequestMapping("/devlist")
	public void devList(HttpServletResponse response, Model model) {
		List<Dev> devList = devMapper.selectAll();
		JSONArray jsonArray = new JSONArray();
		for (Dev dev : devList) {
			JSONObject jObject = new JSONObject();
			String devName = dev.getHouseAddress() + dev.getName();
			jObject.element("id", dev.getId());
			jObject.element("devid", dev.getId());
			jObject.element("address", devName);
			jObject.element("text", devName);
			jsonArray.add(jObject);

		}

		String text = JSONArray.fromObject(jsonArray).toString();
		// System.out.println(text);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
