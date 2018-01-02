package rental_management;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rental_management.publics.util.DateUtils;
import rental_management.system.bean.Card;
import rental_management.system.bean.Person;
import rental_management.system.mapper.HouseMapper;
import rental_management.system.service.CardService;
import rental_management.system.service.HouseService;
import rental_management.system.service.PersonService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml","classpath:spring.xml", "classpath:spring-tx.xml",})

public class PersonTest {
	@Autowired
	private PersonService personService;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private HouseService houseService;
	
	@Test
	public void house(){
		houseService.delete(33);
	}
	@Test
	public void Test(){
		List<Person> list=personService.list();
		for (Person person : list) {
			System.out.println(person);
		}
		
	}
	@Test
	public void Test1(){
		Person person=personService.getPerson(1);
		System.out.println(person);
	}
	
	@Test
	public void Test2(){
	List<Card> cards = cardService.list();
	// List<Person> persons =personService.list();
	
	
	
	JSONArray jsonArray = new JSONArray();

	for (Card card : cards) {
		JSONObject json = new JSONObject();
		Person person = personService.getPerson(card.getUserId());
		json.element("id", card.getId());
		json.element("name", person.getName());
		json.element("personcardno", card.getCardNo());
		json.element("phone", person.getPhone());
		json.element("sex", person.getSex());
		json.element("identitynumber", person.getIdentityNumber());
		json.element("status", card.getStatus());
		json.element("cdt", card.getCdt());
		json.element("canceldate", card.getCancelDate());

		jsonArray.add(json);
	}
	
	String text = JSONArray.fromObject(jsonArray).toString();
	System.out.println(text);
	
	}
	@Test
	public void test3(){
		Person person=new Person();
		person.setAddress("广州");
		person.setName("测试");
		
		person.setSex(1);
		person.setBrithDate(new Date());
		person.setIdentityNumber("272826298");
		
		person.setPhone("289229269");
		
		
		personService.insert(person);
		
		
		
				
	}
	
	
	@Test
	public void test4(){
		List<Person> list=personService.list();
		
		for (Person person : list) {
			System.out.println(person.toString());
		}
		
		
		
	}
	
	
}
